package com.springgraphql.tutorial.mongo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document("persons")
public class Person {
    @Id
    String id;
    String name;
    Address address;
    @DocumentReference(lazy = false)
    List<Pet> pets;
}
