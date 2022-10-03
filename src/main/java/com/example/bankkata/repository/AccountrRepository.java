package com.example.bankkata.repository;

import com.example.bankkata.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountrRepository extends JpaRepository<Account,Integer> {

    @Query("SELECT u FROM Account u WHERE u.userId.cin = ?1")
    List<Account> findAccountByUser(Integer userId);
}
