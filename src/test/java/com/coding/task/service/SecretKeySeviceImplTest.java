package com.coding.task.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coding.task.repository.SecretKeyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecretKeySeviceImplTest {
	
	@InjectMocks
	SecretKeyServiceImpl secretKeyServiceImpl;
	
	@Mock
	SecretKeyRepository secretKeyRepository;
	
	public static final String KEY="3861";
	
	@Test
	public void existsByKeyTest() {
		secretKeyServiceImpl.existsByKey(KEY);
		verify(secretKeyRepository).existsByKey(KEY);
	}
	

}
