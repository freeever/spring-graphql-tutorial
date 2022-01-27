package com.springgraphql.tutorial;

import com.springgraphql.tutorial.domain.bank.BankAccount;
import com.springgraphql.tutorial.domain.bank.Currency;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BankAccountRepository {
    private final List<BankAccount> bankAccounts = List.of(
            BankAccount.builder().id(UUID.fromString("6a00b01f-a968-4c9b-830c-0c338e834522"))
                    .currency(Currency.USD)
                    .createdAt(ZonedDateTime.parse("2019-05-03T12:12:00+00:00"))
                    .build(),
            BankAccount.builder().id(UUID.fromString("45d5d51c-7344-4b93-bfc0-97d9a258e532"))
                    .currency(Currency.CAD)
                    .createdAt(ZonedDateTime.parse("2020-05-03T12:12:00+00:00"))
                    .build(),
            BankAccount.builder().id(UUID.fromString("ec1f648b-003e-4a92-b46f-3c67c6a47830"))
                    .currency(Currency.USD)
                    .createdAt(ZonedDateTime.parse("2017-05-03T12:12:00+00:00"))
                    .build(),
            BankAccount.builder().id(UUID.fromString("87b822a3-4b56-4fbf-b937-c3617c1dbcc8"))
                    .currency(Currency.CAD)
                    .createdAt(ZonedDateTime.parse("2014-05-03T12:12:00+00:00"))
                    .build(),
            BankAccount.builder().id(UUID.fromString("682e065b-feba-439b-9b07-1eb26d4de16f"))
                    .currency(Currency.CAD)
                    .createdAt(ZonedDateTime.parse("2015-05-03T12:12:00+00:00"))
                    .build(),
            BankAccount.builder().id(UUID.fromString("c05148eb-4592-400c-a9ce-4a5243985175"))
                    .currency(Currency.USD)
                    .createdAt(ZonedDateTime.parse("2013-05-03T12:12:00+00:00"))
                    .build()
    ).stream()
            .sorted(Comparator.comparing(BankAccount::getId))
            .collect(Collectors.toUnmodifiableList());

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public List<BankAccount> getBankAccountsAfter(UUID id) {
        return bankAccounts.stream()
                .dropWhile(bankAccount -> bankAccount.getId().compareTo(id) != 1)
                .collect(Collectors.toUnmodifiableList());
    }
}

