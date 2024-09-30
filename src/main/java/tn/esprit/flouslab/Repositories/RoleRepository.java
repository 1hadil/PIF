package tn.esprit.flouslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.flouslab.Entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Integer> {
    Optional <Role> findByName(String role) ;
}
