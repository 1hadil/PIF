package com.rest.transactions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transactions.entities.Claim;
import com.rest.transactions.repositories.ClaimRepository;

@Service
public class ClaimService {
    private final ClaimRepository claimRepository;

    @Autowired
    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Optional<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public Claim updateClaim(Long id, Claim updatedClaim) {
        return claimRepository.findById(id).map(existingClaim -> {
            updatedClaim.setId(id);
            return claimRepository.save(updatedClaim);
        }).orElseThrow(() -> new RuntimeException("Claim not found with id " + id));
    }

    public void deleteClaim(Long id) {
        if (claimRepository.existsById(id)) {
            claimRepository.deleteById(id);
        } else {
            throw new RuntimeException("Claim not found with id " + id);
        }
    }
}