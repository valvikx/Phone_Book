package phonebook.domain;

public class Contact {

    private final int phoneNumber;

    private final String name;

    public Contact(int phoneNumber, String name) {

        this.name = name;

        this.phoneNumber = phoneNumber;

    }

    public Contact(String name) {

        this.phoneNumber = -1;

        this.name = name;

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

}
