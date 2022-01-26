package com.springgraphql.tutorial.resolver.bank.query;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Client;
import com.springgraphql.tutorial.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {
        log.info("Retrieving bank account id: {}", id);
        List<String> middleNames = Arrays.asList(new String[] {"Mid1", "Mid2"});
//        Client clientA = Client.builder().id(UUID.randomUUID()).firstName("ClientA")
//                .lastName("Jordan").middleNames(middleNames).build();
//        Client clientB = Client.builder().id(UUID.randomUUID()).firstName("ClientB")
//                .lastName("Jordan").middleNames(middleNames).build();
//        clientA.setClient(clientB);
//        clientB.setClient(clientA);

        var requestedFields = environment.getSelectionSet().getFields().stream()
                .map(SelectedField::getName).collect(Collectors.toUnmodifiableSet());

        log.info("Contains filed \"firstName\"? {}", requestedFields.contains("firstName"));

        return BankAccount.builder().id(id).currency(Currency.CAD).build();
    }
}
