package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Entities.Premium;
import tn.esprit.flouslab.Repositories.InsuranceRepository;
import tn.esprit.flouslab.Repositories.PremiumRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class PremiumServiceImpl implements IPremiumService {

    private PremiumRepository premrep;
    private InsuranceRepository insurancerep;
    @Override
    public Premium addPremium(Premium p) {
        return premrep.save(p);
    }

    @Override
    public Premium getPremiumById(Long id) {
        return premrep.findById(id).orElse(null);
    }

    @Override
    public void deletePremium(Long id) {
        premrep.deleteById(id);

    }

    @Override
    public List<Premium> getALL() {
        return  (List<Premium>) premrep.findAll();
    }

    @Override
    public Premium updatePremium(Premium p) {
        return premrep.save(p);
    }

    @Override
    public List<Premium> getALLpr(Long id) {
        Insurance insurance = insurancerep.findById(id).orElse(null);
        return  premrep.findPremiumByInsurance(insurance);
    }

    @Override
    public Premium payment(Long idPremium) {
        Premium premium=premrep.findById(idPremium).get();
        premium.setAmount(0f);
        premium.setStatus(false);
        return premrep.save(premium);
    }

    @Override
    public Long getTotalPremiumCount() {
        return premrep.count();
    }

    @Override
    public List<Premium> findallpremiumsofuser(Long iduser) {
        return premrep.findByInsuranceUserId(iduser);
    }

    @Override
    public Premium assignpremiumtoinsurance(Long idpremium, Long idinsurance) {
        Premium p = premrep.findById(idpremium).orElse(null);
        Insurance i=insurancerep.findById(idinsurance).orElse(null);
        p.setInsurance(i);
        return premrep.save(p);

    }


}

