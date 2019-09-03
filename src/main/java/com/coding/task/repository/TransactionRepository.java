package com.coding.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.task.models.Account;
import com.coding.task.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findByAccount(Account account);

}
