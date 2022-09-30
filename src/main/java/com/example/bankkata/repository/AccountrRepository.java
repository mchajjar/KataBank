package com.example.bankkata.repository;

import com.example.bankkata.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountrRepository extends JpaRepository<Account,Integer> {

    
}
