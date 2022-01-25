package com.springgraphql.tutorial.resolver.bank.query;

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
//        Client clientA = Client.builder().id(UUID.randomUUID()).firstName("ClientA")
//                .lastName("Jordan").middleNames(middleNames).build();
//        Client clientB = Client.builder().id(UUID.randomUUID()).firstName("ClientB")
//                .lastName("Jordan").middleNames(middleNames).build();
//        clientA.setClient(clientB);
//        clientB.setClient(clientA);
        return BankAccount.builder().id(id).currency(Currency.CAD).build();
    }
}
