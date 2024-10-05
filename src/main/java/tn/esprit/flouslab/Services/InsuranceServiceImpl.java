package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Repositories.InsuranceRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class InsuranceServiceImpl implements IInsuranceService {

    @Autowired
    private InsuranceRepository inrep;
    @Override
    public Insurance addInsurance(Insurance i) {
        return inrep.save(i);
    }

    @Override
    public Insurance getInsuranceById(Long id) {
        return inrep.findById(id).orElse(null);
    }

    @Override
    public void deleteInsurance(Long id) {
        inrep.deleteById(id);

    }

    @Override
    public List<Insurance> getAll() {
        return (List<Insurance>) inrep.findAll();
    }

    @Override
    public Insurance updateInsurance(Insurance i) {
        Insurance insurance= inrep.findById(i.getIdInsurance()).orElse(null);
        insurance.setState(i.getState());
        insurance.setStartDate(i.getStartDate());
        insurance.setEndDate(i.getEndDate());
        insurance.setClientcoverageamount(i.getClientcoverageamount());
        insurance.setType(i.getType());
        insurance.setClientpremium(i.getClientpremium());
        insurance.setPolicy(i.getPolicy());
        return inrep.save(insurance);

    }
}
