package me.yurimatheus.casadocodigo.domain.common;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Name() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
