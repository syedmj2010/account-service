package com.account.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Account;
import com.account.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping(value = "/ping")
	public String ping() {
		return "Account Service is Up";

	}
	
	@PostMapping(value = "/accounts")
	public ResponseEntity<Account> createCompany(@RequestBody Account account, HttpServletRequest request) {

		log.info("Create Account Method is calling");
//
//		String companyObject = accountService.callCompany();
//
//		JSONObject obj = new JSONObject(companyObject);
//
//		String companyUuId = obj.getString("uuid");
//		log.info("Company UUID" + companyUuId);
//		account.setCompanyUuid(companyUuId);

		Account createdUser = accountService.createAccount(account, request);

		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

	}
}
