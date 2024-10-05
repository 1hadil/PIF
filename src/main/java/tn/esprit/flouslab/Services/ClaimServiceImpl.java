package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Claim;
import tn.esprit.flouslab.Repositories.ClaimRepository;

import java.util.List;


    @Service
    @AllArgsConstructor

    public class ClaimServiceImpl implements IClaimService {
        private ClaimRepository claimrep;

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
    }



