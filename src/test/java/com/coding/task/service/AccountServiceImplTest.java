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
import com.coding.task.models.Client;
import com.coding.task.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepository accountRepository;
	
	@Test
	public void findAllTest() {
		accountServiceImpl.findAll();
		verify(accountRepository).findAll();
	}
	
	@Test
	public void findByClientTest() {
		Client client = mock(Client.class);
		accountServiceImpl.findByClient(client);
		verify(accountRepository).findByClient(client);
	}
	
	@Test
	public void saveTest() {
		Account account = mock(Account.class);
		accountServiceImpl.save(account);
		verify(accountRepository).save(account);
	}
	
	@Test
	public void updateAccountTest() {
		Account account = mock(Account.class);
		accountServiceImpl.updateAccount(account);
		verify(accountRepository).save(account);
	}
	
	

}
