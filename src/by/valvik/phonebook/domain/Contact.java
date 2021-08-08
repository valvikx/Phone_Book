package by.valvik.phonebook.domain;

import java.util.Objects;

import static java.lang.Math.abs;

public record Contact(int phoneNumber, String name) {

    public Contact(String name) {

        this(-1, name);

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Contact contact)) return false;

        return Objects.equals(name, contact.name);

    }

    @Override
    public int hashCode() {

        return abs(Objects.hash(name));

    }

}