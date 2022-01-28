package com.springgraphql.tutorial.mongo.model;

import lombok.Data;

@Data
public class Address {
    String addressLine1;
    String city;
    String postcode;
}
