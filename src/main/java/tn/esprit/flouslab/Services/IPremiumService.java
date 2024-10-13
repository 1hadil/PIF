package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Premium;

import java.util.List;

public interface IPremiumService {
    Premium addPremium (Premium p);
    Premium getPremiumById (Long id);
    void deletePremium (Long id);
    List<Premium> getALL();
    Premium updatePremium (Premium p);
    public List<Premium> getALLpr(Long id);
    public Premium payment(Long idPremium);
    Long getTotalPremiumCount();
    List<Premium> findallpremiumsofuser (Long iduser);
    Premium assignpremiumtoinsurance (Long idpremium,Long idinsurance );




}
