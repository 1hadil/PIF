package com.rest.transactions.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.transactions.entities.Claim;
import com.rest.transactions.services.ClaimService;
 


@RestController
@RequestMapping("/claim")

public class ClaimController {
    private final ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    // GET all transactions
    @GetMapping
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    // GET a transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Optional<Claim> claim = claimService.getClaimById(id);
        return claim.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST (create) a new claim
    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimService.saveClaim(claim);
        return ResponseEntity.status(201).body(savedClaim);  // Status 201: Created
    }

    // PUT (update) an existing claim
    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
        Claim updatedClaim = claimService.updateClaim(id, claim);
        return updatedClaim != null ? ResponseEntity.ok(updatedClaim) 
                                          : ResponseEntity.notFound().build();
    }

    // DELETE a claim
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();  // Status 204: No Content
    }
    
}
