package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Claim;

import java.util.List;

public interface IClaimService {
    Claim addClaim(Claim c);
    Claim getClaimbyid (Long id);
    void deleteClaim (Long id);
    List<Claim> getALL();
    Claim updateclaim (Claim c);

}
