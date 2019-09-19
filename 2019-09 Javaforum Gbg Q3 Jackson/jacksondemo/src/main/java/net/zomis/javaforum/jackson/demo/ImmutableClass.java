package net.zomis.javaforum.jackson.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.zomis.javaforum.jackson.demo.domain.persons.Person;
import net.zomis.javaforum.jackson.demo.domain.persons.PersonWithoutCreator;

import java.io.IOException;

/**
 * Demonstrates that Jackson is capabale of handling immutable classes,
 * and that you don't need to add an empty constructor specifically for Jackson
 */
public class ImmutableClass {

    private static final Person SIMON = new Person("Simon", 32);
    private String json;

    public void write() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        json = mapper.writeValueAsString(SIMON);
        System.out.println(json);
    }

    public void read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.readValue(json, Person.class);
        System.out.println(person.equals(SIMON) ? "Person equals SIMON" : "Person is someone else");
    }

    public void readWithoutCreator() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // @JsonAutoDetect or @JsonProperty annotations are really important here!
        PersonWithoutCreator person = mapper.readValue(json, PersonWithoutCreator.class);
        System.out.println("PersonWithoutCreator is " + person);
    }

    public void convert() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        PersonWithoutCreator person = mapper.readValue(json, PersonWithoutCreator.class);

        Person converted = mapper.convertValue(person, Person.class);
        System.out.println("Converted person is: " + converted);
    }

    public static void main(String[] args) {
        ImmutableClass test = new ImmutableClass();
        Tools.runSteps(test::write, test::read, test::readWithoutCreator, test::convert);
    }

}
