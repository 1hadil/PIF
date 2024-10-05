package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.PredictiveModel;

@Repository

public interface PredictiveModelRepository extends CrudRepository<PredictiveModel,Long> {
}
