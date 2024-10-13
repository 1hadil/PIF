package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Entities.Premium;

import java.util.List;

@Repository

public interface PremiumRepository extends CrudRepository<Premium,Long> {
    List<Premium> findPremiumByInsurance(Insurance insurance);
    List<Premium> findByInsuranceUserId(Long userid);

}