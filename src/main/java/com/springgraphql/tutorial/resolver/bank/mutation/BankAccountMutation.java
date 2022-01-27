package com.springgraphql.tutorial.resolver.bank.mutation;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Currency;
import com.springgraphql.tutorial.domain.bank.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
@Validated
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock;

    public BankAccount createBankAccount(@Valid CreateBankAccountInput input) {
        log.info("Creating bank account for {}", input);

        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD)
                .createdAt(ZonedDateTime.now(clock))
                .createdOn(LocalDate.now(clock))
                .build();
    }

    public BankAccount updateBankAccount(UUID id, String name, int age) {
        log.info("Updating bank account for {}. Name: {}, age: {}", id, name, age);

        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD)
                .createdAt(ZonedDateTime.now(clock))
                .createdOn(LocalDate.now(clock))
                .build();
    }
}
