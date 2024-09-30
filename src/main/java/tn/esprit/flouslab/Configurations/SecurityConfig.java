package tn.esprit.flouslab.Configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final JwtFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(
                                    "/auth/**",  // Enlève l'espace entre /auth/ et **
                                    "/v2/api-docs",
                                    "/v3/api-docs",
                                    "/v3/api-docs/**", // Enlève l'espace entre /v3/api-docs/ et **
                                    "/swagger-resources",
                                    "/swagger-resources/**", // Enlève l'espace entre /swagger-resources/ et **
                                    "/configuration/ui",
                                    "/configuration/security",
                                    "/swagger-ui/**", // Enlève l'espace entre /swagger-ui/ et **
                                    "/webjars/**", // Enlève l'espace entre /webjars/ et **
                                    "/swagger-ui.html"
                            ).permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Pas de session, gestion sans état
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}



