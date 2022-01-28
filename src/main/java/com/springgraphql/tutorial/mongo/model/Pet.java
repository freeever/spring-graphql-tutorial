package com.springgraphql.tutorial.mongo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@NoArgsConstructor
@Document("person")
public class Pet {
    @Id
    String id;
    String name;
    Person owner;
}
