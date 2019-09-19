package net.zomis.javaforum.jackson.demo;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.zomis.javaforum.jackson.demo.domain.persons.Person;

import java.io.IOException;
import java.math.BigDecimal;

class RandomInformation {

    @JsonUnwrapped
    public Person person;
    public BigDecimal value;

}

public class UnwrappedExample {

    private String json;

    private void run() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        RandomInformation data = new RandomInformation();
        data.person = new Person("Simon Forsberg", 32);
        data.value = BigDecimal.TEN.pow(2).add(BigDecimal.valueOf(10.3));
        json = mapper.writeValueAsString(data);
        System.out.println(json);
    }

    private void load() throws IOException {
        RandomInformation information = new ObjectMapper().readValue(json, RandomInformation.class);
        System.out.println(information.person);
        System.out.println(information.value);
    }

    public static void main(String[] args) {
        UnwrappedExample example = new UnwrappedExample();
        Tools.runSteps(example::run, example::load);
    }

}
