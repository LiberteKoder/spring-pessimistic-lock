package com.example.pessimistic.service;

import com.example.pessimistic.pojo.Balance;
import com.example.pessimistic.repository.BalanceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BalanceService {

    private final BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Transactional
    public void incrementBalance() {
        Balance balance = balanceRepository.findBalanceByOwner("user-1")
                .orElseThrow(() -> new EntityNotFoundException("Balance not found"));
        log.info("balance incrementing..");
        balance.setBalance(balance.getBalance() + 1);
        balanceRepository.save(balance);
    }
}