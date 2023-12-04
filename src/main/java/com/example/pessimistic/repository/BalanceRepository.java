package com.example.pessimistic.repository;

import com.example.pessimistic.pojo.Balance;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BalanceRepository extends JpaRepository<Balance, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Balance> findBalanceByOwner(String owner);

}
