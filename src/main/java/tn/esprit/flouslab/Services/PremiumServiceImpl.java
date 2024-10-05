package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Premium;
import tn.esprit.flouslab.Repositories.PremiumRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class PremiumServiceImpl implements IPremiumService {

    private PremiumRepository premrep;
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
}

