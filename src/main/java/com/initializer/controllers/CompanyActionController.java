package com.initializer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initializer.controllers.exceptions.CompanyActionNotFoundExceptionHandler;
import com.initializer.entities.CompanyAction;
import com.initializer.entities.CompanyActionUser;
import com.initializer.services.interfaces.CompanyActionService;
import com.initializer.services.interfaces.CompanyActionUserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(tags = { "companyAction" })
public class CompanyActionController {

	private CompanyActionService companyActionService;
	private CompanyActionUserService companyActionUserService;
	
	@Autowired
	public CompanyActionController(CompanyActionService companyActionService, CompanyActionUserService companyActionUserService) {
		this.companyActionService = companyActionService;
		this.companyActionUserService = companyActionUserService;
	}

	//OBTER COMPANHIA PESQUISADA
	@RequestMapping(method = RequestMethod.GET, value = "companyAction/{id}")
	public Optional<CompanyAction> getCompanyAction(@PathVariable("id") String id) {
		return this.companyActionService.getCompanyAction(id);
	}

	// OBTER TODAS AS COMPANHIAS ANEXADAS AO PAINEL DO USUARIO
	@RequestMapping(method = RequestMethod.GET, value = "companyAction")
	public List<CompanyActionUser> getAllUserCompanyAction() {
		return this.companyActionUserService.getAllCompanyAction();
	}

	// DELETA COMPANHIA AO CLICAR NO X
	@RequestMapping(method = RequestMethod.DELETE, value = "companyAction/{id}")
	public ResponseEntity<Void> deleteUserCompanyAction(@PathVariable("id") String id) {
		CompanyActionUser companyActionUser = this.companyActionUserService.findCompanyAction(id).orElseThrow(()-> new CompanyActionNotFoundExceptionHandler(id));
		this.companyActionUserService.deleteCompanyAction(companyActionUser);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// caso ok = ResponseEntity.ok(response)
	// caso NOK = ResponseEntity<Tipo>(response, HttpStatus)

}
