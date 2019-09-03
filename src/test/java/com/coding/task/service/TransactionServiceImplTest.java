package com.coding.task.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coding.task.models.Account;
import com.coding.task.models.Transaction;
import com.coding.task.repository.TransactionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceImplTest {
	
	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	
	@Mock
	TransactionRepository transactionRepository;
	
	@Test
	public void saveTransactionTest() {
		Transaction transaction = mock(Transaction.class);
		transactionServiceImpl.saveTransaction(transaction);
		verify(transactionRepository).save(transaction);
	}
	
	@Test
	public void transactionListTest() {
		Account account = mock(Account.class);
		transactionServiceImpl.transactionList(account);
		verify(transactionRepository).findByAccount(account);
	}

}
