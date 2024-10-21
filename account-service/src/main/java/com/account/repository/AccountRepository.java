package com.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
