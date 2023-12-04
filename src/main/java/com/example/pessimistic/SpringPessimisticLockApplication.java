package com.example.pessimistic;

import com.example.pessimistic.pojo.Balance;
import com.example.pessimistic.repository.BalanceRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringPessimisticLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPessimisticLockApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(BalanceRepository balanceRepository) {
        return args -> {

            Balance balance = Balance.builder().
                    owner("user-1")
                    .balance(0)
                    .build();
            balanceRepository.save(balance);
        };

    }
}
