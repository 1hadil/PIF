package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.CStatus;
import tn.esprit.flouslab.Entities.Claim;

@Repository

public interface ClaimRepository extends CrudRepository<Claim,Long> {
    Long countByStatus (CStatus status);
}
