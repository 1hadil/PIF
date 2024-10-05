package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.Premium;

@Repository

public interface PremiumRepository extends CrudRepository<Premium,Long> {
}