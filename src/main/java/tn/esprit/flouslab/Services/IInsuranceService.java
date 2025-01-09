package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Insurance;

import java.util.List;

public interface IInsuranceService {
    public Long addInsurance(Insurance i,Integer id) ;
    Insurance getInsuranceById (Long id);
    void deleteInsurance (Long id);
    Iterable<Insurance> getAll();

    Insurance updateInsurance (Insurance i,Long id);
    Insurance addinsuranceandassigntouser (Insurance insurance,Integer iduser);
    Insurance assigninsurancetouser(Long idinsurance,Integer iduser);
    Long gettotalinsurance();
    public List<Insurance> getallbyuser(Integer iduser);

    public Insurance createInsurance(Integer iduser,Long idorder );
   // public double estimatePremium(String iduser, String product);




}
