package com.example.bankkata.repository;

import com.example.bankkata.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Integer> {

    @Query("SELECT u FROM Operation u WHERE u.accountFrom.id = ?1")
    List<Operation> findAllByAccountId(Integer accountId);
}
