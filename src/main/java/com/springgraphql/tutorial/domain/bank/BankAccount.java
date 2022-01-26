package com.springgraphql.tutorial.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Value
public class BankAccount {

    UUID id;
    Client client;
    Currency currency;
    ZonedDateTime createdAt;
    LocalDate createdOn;
}
