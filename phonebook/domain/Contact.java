package phonebook.domain;

import java.util.Objects;

public class Contact {

    private final int phoneNumber;

    private final String name;

    public Contact(int phoneNumber, String name) {

        this.name = name;

        this.phoneNumber = phoneNumber;

    }

    public String getName() {

        return name;

    }

    public int getPhoneNumber() {

        return phoneNumber;

    }

    @Override
    public String toString() {
        return "People{" +
                "phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        return Objects.equals(name, contact.name);

    }

    @Override
    public int hashCode() {

        return Objects.hash(name);

    }

}
