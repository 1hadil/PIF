package com.rest.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.transactions.entities.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
