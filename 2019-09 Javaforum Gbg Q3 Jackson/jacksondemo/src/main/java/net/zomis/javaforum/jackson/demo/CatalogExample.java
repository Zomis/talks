package net.zomis.javaforum.jackson.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.zomis.javaforum.jackson.demo.domain.products.Catalog;

import java.io.IOException;

/**
 * Demonstrates how Jackson is able to determine the type of an object and use that type to deserialize.
 */
public class CatalogExample {

    private final ObjectMapper mapper = new ObjectMapper()
        .registerModule(new JavaTimeModule()) // or `.findAndRegisterModules()`
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private String json;

    public void save() throws JsonProcessingException {
        json = mapper.writeValueAsString(Tools.createExampleCatalog());
        System.out.println(json);
    }

    public void load() throws IOException {
        Catalog catalog = mapper.readValue(json, Catalog.class);
        System.out.println(catalog);
    }

    public static void main(String[] args) {
        CatalogExample catalogExample = new CatalogExample();
        Tools.runSteps(catalogExample::save, catalogExample::load);
    }

}
