package com.initializer.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initializer.entities.CompanyActionUser;
import com.initializer.repositories.CompanyActionUserRepository;
import com.initializer.services.interfaces.CompanyActionUserService;

@Service
public class CompanyActionUserServiceImplementation implements CompanyActionUserService {

	@Autowired
	private CompanyActionUserRepository companyActionUserRepository;
	@Override
	public List<CompanyActionUser> getAllCompanyAction() {
		return null;
	}

	@Override
	public void deleteCompanyAction(String id) {
		this.companyActionUserRepository.deleteById(id);
	
	}

	@Override
	public Optional<CompanyActionUser> findCompanyAction(String id) {
		return this.companyActionUserRepository.findById(id);
		
	}

	@Override
	public void deleteCompanyAction(CompanyActionUser companyActionUser) {
		this.companyActionUserRepository.delete(companyActionUser);
		
	}

}
