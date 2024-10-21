package com.account.service;

import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.account.model.Account;
import com.account.repository.AccountRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	RestTemplate restTemplate;

	public Account createAccount(Account account, HttpServletRequest request) {
		
		account.setUuid(generateUUID(request));
		
		String companyObject = callCompany(account.getCompanyId());
		
		String userObject = callUser(account.getUserId());

		
		
		return accountRepository.save(account);
	}

	public String generateUUID(HttpServletRequest request) {
		String operationId = request.getHeader("X-Operation-Id");
		if (StringUtils.isBlank(operationId)) {
			operationId = UUID.randomUUID().toString().replace("-", "");
		}

		return operationId;
	}

	public String callCompany(Integer companyId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8081/company/companyById/"+companyId, HttpMethod.GET, entity, String.class)
				.getBody();

	}
	
	
	public String callUser(Integer userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8081/user/userById/"+userId, HttpMethod.GET, entity, String.class)
				.getBody();

	}

}
