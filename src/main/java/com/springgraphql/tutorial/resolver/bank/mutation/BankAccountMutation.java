package com.springgraphql.tutorial.resolver.bank.mutation;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Currency;
import com.springgraphql.tutorial.domain.bank.input.CreateBankAcountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {
    public BankAccount createBankAccount(CreateBankAcountInput input) {
        log.info("Creating bank account for {}", input);

        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD).build();
    }
}
