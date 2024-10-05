package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.PredictiveModel;
import tn.esprit.flouslab.Repositories.PredictiveModelRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class PredictiveModelImpl implements IPredicitiveModelService {


    private PredictiveModelRepository premodrep;
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
}
