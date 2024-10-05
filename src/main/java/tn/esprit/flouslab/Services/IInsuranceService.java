package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Insurance;

import java.util.List;

public interface IInsuranceService {
    Insurance addInsurance (Insurance i);
    Insurance getInsuranceById (Long id);
    void deleteInsurance (Long id);
    List<Insurance> getAll();

    Insurance updateInsurance (Insurance i);




}
