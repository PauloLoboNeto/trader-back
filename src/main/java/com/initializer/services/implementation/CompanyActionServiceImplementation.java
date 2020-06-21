package com.initializer.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initializer.entities.CompanyAction;
import com.initializer.repositories.CompanyActionRepository;
import com.initializer.services.interfaces.CompanyActionService;

@Service
public class CompanyActionServiceImplementation implements CompanyActionService {

	@Autowired
	CompanyActionRepository companyActionRepository;

	public Optional<CompanyAction> getCompanyAction(String id) {
		return companyActionRepository.findById(id);
//		5e9e4197025c9533cc38fd08
	}
	
	public List<CompanyAction> getAllCompanyAction(){
		return this.companyActionRepository.findAll();
	}

}
