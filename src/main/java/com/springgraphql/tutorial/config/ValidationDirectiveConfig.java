package com.springgraphql.tutorial.config;

import graphql.validation.rules.OnValidationErrorStrategy;
import graphql.validation.rules.ValidationRules;
import graphql.validation.schemawiring.ValidationSchemaWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationDirectiveConfig {

    @Bean
    public ValidationSchemaWiring stuff() {
        // This contains by default the standard library provided @Directive constraints
        ValidationRules validationRules = ValidationRules.newValidationRules()
                .onValidationErrorStrategy(OnValidationErrorStrategy.RETURN_NULL)
                .build();

        // This will rewrite your data fetchers when rules apply to them so that validation
        return new ValidationSchemaWiring(validationRules);
    }
}
