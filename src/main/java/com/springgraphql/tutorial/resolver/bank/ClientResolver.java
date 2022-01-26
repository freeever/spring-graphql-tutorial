package com.springgraphql.tutorial.resolver.bank;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public CompletableFuture<Client> client(BankAccount bankAccount) {
//        log.info("Requesting client data for bank account id {}", bankAccount.getId());

//        throw new GraphQLException("Client unavailable!");
//        throw new RuntimeException("Server Internal Error!");

//        return DataFetcherResult.<Client>newResult()
//                .data(Client.builder().id(UUID.randomUUID())
//                .firstName("Stephen")
//                .lastName("Curry")
//                .build())
//            .error(new GenericGraphQLError("Could not get sub-client id"))
//            .build();
        log.info("Stop me debugging");
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Requesting client data for bank account id {}", bankAccount.getId());
                    return Client.builder().id(UUID.randomUUID())
                        .firstName("Stephen")
                        .lastName("Curry")
                        .build();
                },
                executorService);
    }
}
