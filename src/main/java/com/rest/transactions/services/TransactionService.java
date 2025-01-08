package com.rest.transactions.services;

 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.transactions.entities.Transaction;
import com.rest.transactions.repositories.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        if (transactionRepository.existsById(id)) {
            updatedTransaction.setId(id);  // Update the ID field
            return transactionRepository.save(updatedTransaction);
        }
        return null;  
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}

