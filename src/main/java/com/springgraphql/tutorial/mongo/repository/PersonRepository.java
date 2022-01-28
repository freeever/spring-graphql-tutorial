package com.springgraphql.tutorial.mongo.repository;

import com.springgraphql.tutorial.mongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByName(String name);
    List<Person> findByAddressCity(String city);
}
