package com.springgraphql.tutorial.resolver.bank;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Client;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());

//        throw new GraphQLException("Client unavailable!");
//        throw new RuntimeException("Server Internal Error!");

        return Client.builder().id(UUID.randomUUID())
                .firstName("Stephen")
                .lastName("Curry")
                .build();
    }
}
