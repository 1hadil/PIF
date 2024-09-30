package tn.esprit.flouslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.flouslab.Entities.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository <Token, Integer>{
    Optional<Token> findByToken(String token) ;

}
