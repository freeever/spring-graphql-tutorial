package com.springgraphql.tutorial.resolver.bank.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {

    /**
     * @param environment Must be the last parameter
     * @return
     */
    public UUID uploadFile(DataFetchingEnvironment environment) {
        log.info("Uploading file");

        DefaultGraphQLServletContext context = environment.getContext();
        context.getFileParts().forEach(part -> {
            log.info("Uploading: {}, size: {}", part.getSubmittedFileName(), part.getSize());
        });

        return UUID.randomUUID();
    }
}
