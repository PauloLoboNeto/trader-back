package com.initializer.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.initializer.entities.CompanyAction;

@Repository
public interface CompanyActionRepository extends MongoRepository<CompanyAction, String> {

	public Optional<CompanyAction> findById(String id);
}
