package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.CStatus;
import tn.esprit.flouslab.Entities.Claim;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Repositories.ClaimRepository;
import tn.esprit.flouslab.Repositories.InsuranceRepository;

import java.util.List;


    @Service
    @AllArgsConstructor

    public class ClaimServiceImpl implements IClaimService {
        private ClaimRepository claimrep;

        private InsuranceRepository inrep;


        @Override
        public Claim addClaim(Claim c) {
            return claimrep.save(c);
        }

        @Override
        public Claim getClaimbyid(Long id) {
            return claimrep.findById(id).orElse(null);
        }

        @Override
        public void deleteClaim(Long id) {
            claimrep.deleteById(id);

        }

        @Override
        public List<Claim> getALL() {
            return (List<Claim>) claimrep.findAll();
        }

        @Override
        public Claim updateclaim(Claim c) {
            Claim claim = claimrep.findById(c.getIdClaim()).orElse(null);
            claim.setDate(c.getDate());
            claim.setDetails(c.getDetails());
            claim.setStatus(c.getStatus());
            claim.setAmount(c.getAmount());

            return claimrep.save(claim);
        }

        @Override
        public Claim addclaimandassigntoinsurance(Claim c, Long idinsurance) {
            c.setStatus(CStatus.Pending);
            claimrep.save(c);
            Insurance insurance = inrep.findById(idinsurance).orElse(null);
            c.setInsurance(insurance);
            return claimrep.save(c);
        }

        @Override
        public Long getTotalClaimCount() {
            return claimrep.count();
        }

        @Override
        public Long countclaimsbystatus(CStatus status) {
            return claimrep.countByStatus(status);
        }
    }



