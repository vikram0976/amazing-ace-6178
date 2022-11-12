package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwala.model.CurrantUserSession;

public interface SessionRepo extends JpaRepository<CurrantUserSession, Integer> {
	
	
	public CurrantUserSession findByUuid(String uuid);
	
}