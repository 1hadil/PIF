package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Premium;

import java.util.List;

public interface IPremiumService {
    Premium addPremium (Premium p);
    Premium getPremiumById (Long id);
    void deletePremium (Long id);
    List<Premium> getALL();
    Premium updatePremium (Premium p);

}
