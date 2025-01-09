package tn.esprit.flouslab.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.RegistrationRequest;
import tn.esprit.flouslab.Entities.User;
import tn.esprit.flouslab.Repositories.UserRepository;
import tn.esprit.flouslab.Services.AthenticationService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Authentication")
public class AuthenticationController {
    private  final AthenticationService service ;
    private final UserRepository userRepository;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
          @RequestBody @Valid RegistrationRequest request
    ) {
        service.register(request);
        return ResponseEntity.accepted().build();
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestParam String email,@RequestParam String password) {

        try {
            // Vérification de l'utilisateur
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new IllegalArgumentException("Nom d'utilisateur incorrect"));

            // Vérification du mot de passe (comparaison avec le hachage)
            if (!password.equals(user.getPassword())) {
                return ResponseEntity.badRequest().body("Mot de passe incorrect");
            }

            // Préparer la réponse
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Connexion réussie");
            response.put("username", user.getUsername());
            response.put("role", user.getRoles());
            response.put("id", user.getId());

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur d'authentification");
        }
    }

}
