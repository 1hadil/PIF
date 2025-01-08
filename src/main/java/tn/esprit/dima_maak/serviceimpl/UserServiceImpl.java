package tn.esprit.dima_maak.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.dima_maak.DTO.LoginResponseDTO;
import tn.esprit.dima_maak.entities.*;
import tn.esprit.dima_maak.services.*;
import tn.esprit.dima_maak.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class UserServiceImpl  implements IUserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LocationRepository locationRepository;
    private final ConfirmationRepository confirmationRepository;

    private final PasswordEncoder encoder;

    @Lazy
    @Autowired
    AuthenticationManager authenticationManager;
    private final ITokenService tokenService;
    public static final String UPLOAD_DIR = "uploads/profiles/";
    private final IEmailService emailService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, ITokenService tokenService, ConfirmationRepository confirmationRepository, IEmailService emailService,  LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.tokenService = tokenService;
        this.confirmationRepository = confirmationRepository;
        this.emailService = emailService;

        this.locationRepository = locationRepository;

    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User retrieveUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public User addUser(User c) {
        // Encoder le mot de passe
        c.setPassword(encoder.encode(c.getPassword()));

        if (c.getRole() == null || c.getRole().isEmpty()) {
            Role defaultRole = roleRepository.findById(2L)
                    .orElseThrow(() -> new EntityNotFoundException("Default role not found"));
            c.setRole(new HashSet<>(Collections.singleton(defaultRole))); // Utilisez un HashSet modifiable
        }


        // Enregistrer l'utilisateur
        return userRepository.save(c);
    }

    @Override
    public void removeUser(Long id) throws IOException {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.getPhoto() != null && user.getPhoto().equals("someValue")) {
                // Traitement
            }

            Confirmation c = confirmationRepository.findConfirmationByUser(user);
            if (c != null) {
                if (!"default.jpg".equals(user.getPhoto())) {
                    this.deleteProfilePicture(user.getPhoto());
                }
                confirmationRepository.delete(c);
            }
            userRepository.deleteById(id);
        }
    }

    @Override
    public User modifyUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with id: " + user.getId());
        }
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user by this email exists"));
    }

    @Override
    public User registerUser(User user) {
        //////////////////// Check if the email is unique/////////////////////
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return null;
        }
        //////////////////////////////////////////////////////////////////////
        String encodedPassword = encoder.encode(user.getPassword());
        Role userRole = roleRepository.findById(2L).get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        user.setPassword(encodedPassword);
        user.setStatus(UStatus.Pending);
        user.setRole(authorities);
        user.setBalance(0f);
        user.setLp(0);
        Confirmation confirmation = new Confirmation(user);
        if (user.getAddress() != null) {
            locationRepository.save(user.getAddress());
        } else {
            System.out.println("NO LOCATION PASSED");
        }
        userRepository.save(user);
        confirmationRepository.save(confirmation);
        /////////////////MAILING//////////////////////////
        //emailService.sendSimpleMailMessage(user.getSurname()+ " "+ user.getName(),user.getEmail(),confirmation.getToken());
        emailService.sendHtmlEmail(user.getSurname() + " " + user.getName(), user.getEmail(), confirmation.getToken());
        /////////////////////////////////////////////////
        return user;
    }

    @Override
    public LoginResponseDTO login(String email, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            String token = tokenService.generateJwt(auth);
            User user = userRepository.findByEmail(email).get();
            return new LoginResponseDTO(user.getName(), token);
        } catch (AuthenticationException e) {
            return new LoginResponseDTO("No email to return", "Invalid email/password supplied");
        }
    }

    @Override
    public void logout() {
        SecurityContextHolder.clearContext();
    }

    @Override
    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    /////////////////////////////// PROFILE PICTURE UPLOAD LOGIC///////////////////////////////////////////////////////////
    // Method to save profile picture
    @Override
    public String saveProfilePicture(MultipartFile file) throws IOException {
        // Create a unique file name to prevent conflicts
        String fileName = generateUniqueFileName(file.getOriginalFilename());
        // Create the directory if it doesn't exist
        createUploadDirectoryIfNotExist();
        // Get the file path to save the image
        String filePath = UPLOAD_DIR + fileName;
        // Save the file to the specified location
        Path destPath = Paths.get(filePath);
        Files.copy(file.getInputStream(), destPath);

        return fileName;
    }

    @Override
    public void deleteProfilePicture(String fileName) throws IOException {
        // Construct the file path
        String filePath = UPLOAD_DIR + fileName;

        // Create a Path object for the file
        Path path = Paths.get(filePath);

        // Check if the file exists
        if (Files.exists(path)) {
            // Delete the file
            Files.delete(path);
            System.out.println("Profile picture deleted successfully: " + fileName);
        } else {
            // File doesn't exist
            System.out.println("Profile picture not found: " + fileName);
        }
    }

    // Helper method to generate a unique file name
    private String generateUniqueFileName(String originalFileName) {
        String uuid = UUID.randomUUID().toString();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return uuid + extension;
    }

    // Helper method to create upload directory if it doesn't exist
    private void createUploadDirectoryIfNotExist() {
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        User user = userRepository.findByEmail(confirmation.getUser().getEmail()).get();
        user.setStatus(UStatus.Active);
        confirmationRepository.delete(confirmation);
        userRepository.save(user);
        return Boolean.TRUE;
    }


    public String generateAffiliateLink(User user) {
        return "http://localhost:4200/signup/" + user.getId();
    }

    public int[] countUsers() {
        int[] counts = new int[5];
        counts[0] = userRepository.countUsers();
        counts[1] = userRepository.countUsersWithSalaryLessThan1000();
        counts[2] = userRepository.countUsersWithSalaryBetween1000And3000();
        counts[3] = userRepository.countUsersWithSalaryBetween3000And6000();
        counts[4] = userRepository.countUsersWithSalaryMoreThan6000();
        return counts;
    }

    //User statistics by age
    public int[] countUsersByAge() {
        int[] counts = new int[4];
        counts[0] = userRepository.countUsersBelow18();
        counts[1] = userRepository.countUsersBetween18And25();
        counts[2] = userRepository.countUsersBetween25And40();
        counts[3] = userRepository.countUsersAbove40();
        return counts;
    }

    //User statistics by location
    public List<Object[]> findAllUserCoordinates() {
        return userRepository.findAllUserCoordinates();
    }

    @Override
    public void notifyUsers() {

    }
    @Override
    public int countAllUsers() {
        return userRepository.countAllUsers();
    }

}


