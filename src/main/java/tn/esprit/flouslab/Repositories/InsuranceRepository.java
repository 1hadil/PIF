package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.Insurance;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance,Long> {
}
