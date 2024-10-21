package com.account.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;

	private Integer companyId;
	private Integer userId;
	private Integer accountNum;	
	private String enrolledDate;
	private String acctStatus;
	
	private String uuid;
	private String companyUuid;
	
	private String userUuid;
	
	private String createdBy;

	private String createdAt;

	private String updatedBy;

	private String updatedAt;

}
