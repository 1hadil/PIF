package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.CStatus;
import tn.esprit.flouslab.Entities.Claim;

import java.util.List;

public interface IClaimService {
    Claim addClaim(Claim c);
    Claim getClaimbyid (Long id);
    void deleteClaim (Long id);
    List<Claim> getALL();
    public Claim updateclaim(Claim c,Long id) ;
    public List<Claim> getALLbyuser(int id);

    Claim addclaimandassigntoinsurance(Claim c, Long idinsurance,Integer id);
    Long getTotalClaimCount();
    Long  countclaimsbystatus (CStatus status);

}
