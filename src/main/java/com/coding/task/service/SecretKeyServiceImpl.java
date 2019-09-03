package com.coding.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.task.repository.SecretKeyRepository;

@Service
public class SecretKeyServiceImpl implements SecretKeyService{
	
	@Autowired
	SecretKeyRepository secretKeyRepository;

	@Override
	public boolean existsByKey(String key) {
		return secretKeyRepository.existsByKey(key);
	}

}
