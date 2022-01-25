package com.springgraphql.tutorial.resolver;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Client;
import com.springgraphql.tutorial.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account id: {}", id);
        List<String> middleNames = Arrays.asList(new String[] {"Mid1", "Mid2"});
        Client client = Client.builder().id(UUID.randomUUID()).firstName("Michael")
                .lastName("Jordan").middleNames(middleNames).build();
        return BankAccount.builder().id(id).client(client).currency(Currency.CAD).build();
    }
}
