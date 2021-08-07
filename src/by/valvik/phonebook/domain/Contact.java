package by.valvik.phonebook.domain;

import java.util.Objects;

public record Contact(int phoneNumber, String name) {

    public Contact(String name) {

        this(0, name);

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Contact contact)) return false;

        return Objects.equals(name, contact.name);

    }

    @Override
    public int hashCode() {

        return Objects.hash(name);

    }

}
