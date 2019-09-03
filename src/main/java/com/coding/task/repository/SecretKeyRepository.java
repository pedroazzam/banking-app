package com.coding.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.task.models.SecretKey;

public interface SecretKeyRepository extends JpaRepository<SecretKey, Long>{
	
	boolean existsByKey(String key);
	
}
