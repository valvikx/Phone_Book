package phonebook.sorting;

import phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public class Sorting {

    private final ISorting method;

    public Sorting(ISorting method) {

        this.method = method;

    }

    public void apply(List<Contact> contacts, Comparator<Contact> comparator) {

        method.sort(contacts, comparator);

    }

}
