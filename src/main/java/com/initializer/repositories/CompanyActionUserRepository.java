package com.initializer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.initializer.entities.CompanyActionUser;

@Repository
public interface CompanyActionUserRepository extends MongoRepository<CompanyActionUser, String>{

}
