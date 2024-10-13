package tn.esprit.flouslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail (String email) ;

}
