package com.springgraphql.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.springgraphql.tutorial.mongo.repository")
public class SpringGraphqlTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphqlTutorialApplication.class, args);
    }

}
