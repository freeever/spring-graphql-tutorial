package com.springgraphql.tutorial.mongo.service;

import com.springgraphql.tutorial.mongo.model.Person;
import com.springgraphql.tutorial.mongo.model.Pet;
import com.springgraphql.tutorial.mongo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final MongoTemplate mongoTemplate;

    public List<Person> findAll() {
        List<Person> persons = personRepository.findAll();
        log.info("Found persons: {}", persons.size());
        return persons;
    }

    public List<Person> findByName(String name) {
        List<Person> persons = personRepository.findByName(name);
        log.info("Found {} persons by name {}", persons.size(), name);
        return persons;
    }

    public List<Person> findByAddressCity(String city) {
        List<Person> persons = personRepository.findByAddressCity(city);
        log.info("Found {} persons by city {}", persons.size(), city);
        return persons;
    }

    public List<Person> findByPet(String pet) {
        AggregationOperation match = Aggregation.match(Criteria.where("name").is("smith"));
        AggregationOperation query = Aggregation.lookup("pets", "pets", "petId", "pets");

//        ProjectionOperation projectStage = Aggregation.project(Fields.from(
//                Fields.field("name", "name"),
//                Fields.field("address", "address"),
//                Fields.field("pets", "pets")));

        Aggregation aggregation = Aggregation.newAggregation(query, match);

        AggregationResults<Person> results = mongoTemplate.aggregate(aggregation,
                mongoTemplate.getCollectionName(Person.class), Person.class);

        return results.getMappedResults();
    }

    public List<Person> findByPet_bak(String pet) {
        AggregationOperation match = Aggregation.match(Criteria.where("name").is("smith"));
        AggregationOperation query = Aggregation.lookup("pets", "pets", "petId", "myPets");

        ProjectionOperation projectStage = Aggregation.project(Fields.from(
                Fields.field("name", "name"),
                Fields.field("address", "address"),
                Fields.field("pets", "pets")));

        Aggregation aggregation = Aggregation.newAggregation(query, match, projectStage);

        AggregationResults<Person> results = mongoTemplate.aggregate(aggregation,
                mongoTemplate.getCollectionName(Person.class), Person.class);

        return results.getMappedResults();
    }

}
