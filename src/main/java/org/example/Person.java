package org.example;

import com.google.gson.JsonSyntaxException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.google.gson.Gson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    // геттеры и сеттеры

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(30);

        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);

        Person newPerson = null;
        try {
            newPerson = gson.fromJson(json, Person.class);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(newPerson.toString());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}