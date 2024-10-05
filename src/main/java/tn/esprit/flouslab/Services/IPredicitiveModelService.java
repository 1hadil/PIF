package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.PredictiveModel;

import java.util.List;

public interface IPredicitiveModelService {
    PredictiveModel addPredictiveModel(PredictiveModel pm);
    PredictiveModel getPredictiveModelbyid (Long id);
    void deletePredictiveModel (Long id);
    List<PredictiveModel> getALL();
    PredictiveModel updatePredictiveModel (PredictiveModel pm);

}
