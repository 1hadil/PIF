package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Forecast;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Entities.PredictiveModel;
import tn.esprit.flouslab.Repositories.InsuranceRepository;
import tn.esprit.flouslab.Repositories.PredictiveModelRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class PredictiveModelImpl implements IPredicitiveModelService {


    private PredictiveModelRepository premodrep;
    private InsuranceRepository inrep;
    @Override
    public PredictiveModel addPredictiveModel(PredictiveModel pm) {
        return premodrep.save(pm);
    }

    @Override
    public PredictiveModel getPredictiveModelbyid(Long id) {
        return premodrep.findById(id).orElse(null);
    }

    @Override
    public void deletePredictiveModel(Long id) {
        premodrep.deleteById(id);

    }

    @Override
    public List<PredictiveModel> getALL() {
        return (List<PredictiveModel>) premodrep.findAll();
    }

    @Override
    public PredictiveModel updatePredictiveModel(PredictiveModel pm) {
        PredictiveModel predictiveModel=premodrep.findById(pm.getIdModel()).orElse(null);
        predictiveModel.setCreationDate(pm.getCreationDate());
        predictiveModel.setType(pm.getType());
        predictiveModel.setName(pm.getName());
        predictiveModel.setParameters(pm.getParameters());
        return  premodrep.save(predictiveModel);
    }

    @Override
    public Insurance addpredictivemodelandassigntoinsurance(PredictiveModel pm, Long idin) {
        premodrep.save(pm);
            Insurance insurance = inrep.findById(idin).orElse(null);
        Set<PredictiveModel> predictivemodels = new HashSet<>();
        predictivemodels.add(pm);
        insurance.setPredictiveModels(predictivemodels);
        return insurance;

    }
}
