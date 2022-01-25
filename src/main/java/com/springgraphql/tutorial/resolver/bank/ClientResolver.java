package com.springgraphql.tutorial.resolver.bank;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public DataFetcherResult<Client> client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());

//        throw new GraphQLException("Client unavailable!");
//        throw new RuntimeException("Server Internal Error!");

        return DataFetcherResult.<Client>newResult()
                .data(Client.builder().id(UUID.randomUUID())
                .firstName("Stephen")
                .lastName("Curry")
                .build())
            .error(new GenericGraphQLError("Could not get sub-client id"))
            .build();

//        return Client.builder().id(UUID.randomUUID())
//                .firstName("Stephen")
//                .lastName("Curry")
//                .build();
    }
}
