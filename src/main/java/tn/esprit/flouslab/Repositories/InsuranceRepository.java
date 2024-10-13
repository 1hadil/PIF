package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Entities.User;

import java.util.List;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance,Long> {
    List<Insurance> findByUser(User user);
}
