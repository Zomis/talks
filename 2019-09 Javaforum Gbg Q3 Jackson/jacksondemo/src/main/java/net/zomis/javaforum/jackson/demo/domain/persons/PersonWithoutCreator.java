package net.zomis.javaforum.jackson.demo.domain.persons;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonWithoutCreator {

    private final String name;
    private final int age;

    private PersonWithoutCreator() {
        System.out.println("Jackson was here!");
        this.name = null;
        this.age = 0;
    }

    public PersonWithoutCreator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithoutCreator person = (PersonWithoutCreator) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "PersonWithoutCreator{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
