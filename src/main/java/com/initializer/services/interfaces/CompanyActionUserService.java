package com.initializer.services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.initializer.entities.CompanyActionUser;

@Service
public interface CompanyActionUserService {

	public List<CompanyActionUser> getAllCompanyAction();
	public void deleteCompanyAction(String id);
	public void deleteCompanyAction(CompanyActionUser companyActionUser);
	public Optional<CompanyActionUser> findCompanyAction(String id);
}
