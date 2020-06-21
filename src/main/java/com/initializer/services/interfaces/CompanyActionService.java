package com.initializer.services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.initializer.entities.CompanyAction;

@Service
public interface CompanyActionService {
	public Optional<CompanyAction> getCompanyAction(String id);
	public List<CompanyAction> getAllCompanyAction();
}
