package com.springgraphql.tutorial.rest;

import com.springgraphql.tutorial.mongo.model.Person;
import com.springgraphql.tutorial.mongo.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/persons")
@RestController
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<Person> findAllPersons() {
        log.info("Find all persons!");
        return personService.findAll();
    }

    @GetMapping("/{name}")
    public List<Person> findByName(@PathVariable String name) {
        log.info("Find person by: {}", name);
        return personService.findByName(name);
    }

    @GetMapping("/city/{city}")
    public List<Person> findByPetName(@PathVariable("city") String city) {
        log.info("Find person who is from: {}", city);
        return personService.findByAddressCity(city);
    }

    @GetMapping("/pet/{pet}")
    public List<Person> findByPet(@PathVariable("pet") String pet) {
        log.info("Find person who has pet: {}", pet);
        return personService.findByPet(pet);
    }
}
