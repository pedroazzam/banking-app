package com.coding.task.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coding.task.models.Client;
import com.coding.task.repository.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {
	
	@InjectMocks
	ClientServiceImpl clientServiceImpl;
	
	@Mock
	ClientRepository clientRepository;
	
	public static final long ID = 1;
	public static final String EMAIL="";
	public static final String PASSWORD="";
	
	
	@Test
	public void findByIdTest() {
		clientServiceImpl.findById(ID);
		verify(clientRepository).findById(ID);
	}
	
	@Test
	public void findAllTest() {
		clientServiceImpl.findAll();
		verify(clientRepository).findAll();
	}
	
	@Test
	public void findByEmailAndPasswordTest() {
		clientServiceImpl.findByEmailAndPassword(EMAIL,PASSWORD);
		verify(clientRepository).findByEmailAndPassword(EMAIL, PASSWORD);
	}
	
	@Test
	public void saveTest() {
		Client client  = mock(Client.class);
		clientServiceImpl.save(client);
		verify(clientRepository).save(client);
	}

}
