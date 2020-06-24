package org.level.up.covid19.springcovid.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@Slf4j
public class SchemaValidator {

    @Autowired
    private ObjectMapper objectMapper;
    private final static JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

    public ValidationResult validateSchema(String jsonInstance, String jsonPath) throws JsonProcessingException {

        String rawSchema = null;
        try {
            rawSchema = new String(Files.readAllBytes
                    (Paths.get(jsonPath)));
        } catch (IOException e) {
            log.info(e.getLocalizedMessage());
        }
        JsonSchema finalSchema = factory.getSchema(rawSchema);
        JsonNode rawNode = objectMapper.readTree(jsonInstance);

        return finalSchema.validateAndCollect(rawNode);

    }
}
