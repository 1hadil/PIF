package tn.esprit.flouslab.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.esprit.flouslab.Entities.RegistrationRequest;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.User;
import tn.esprit.flouslab.Repositories.RoleRepository;
import tn.esprit.flouslab.Repositories.UserRepository;

import java.security.SecureRandom;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AthenticationService {
private  final RoleRepository roleRepository ;
private final PasswordEncoder passwordEncoder ;
private final UserRepository userRepository ;

    public void register(RegistrationRequest request) {
        var userRole = roleRepository.findByName("USER")
                //better exception
                .orElseThrow(() -> new IllegalStateException("ROLE USER WAS NOT INITIALIZED")) ;
        var  user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();
           userRepository.save(user);
           sendValidationEmail(user);

    }

    private void sendValidationEmail(User user) {
        var newToken = generateAndSaveActivationToken(user);
        // send Email
    }

    private String generateAndSaveActivationToken(User user) {
        // generate a token
        String  generatedToken = generateActivationCode(6);
        return null ;
        
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom() ;
        for (int i = 0; i < length ; i ++ ){

              int randomindex = secureRandom.nextInt(characters.length());  // 0..9
              codeBuilder.append(characters.charAt(randomindex));
        }
        return codeBuilder.toString() ;
    }
}
