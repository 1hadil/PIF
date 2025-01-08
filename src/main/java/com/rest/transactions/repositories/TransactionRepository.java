package com.rest.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.transactions.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
     
}
