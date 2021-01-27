package phonebook.sorting.impl;

import phonebook.domain.Contact;
import phonebook.sorting.ISorting;

import java.util.Comparator;
import java.util.List;

public class StandardSorting implements ISorting {

    @Override
    public void sort(List<Contact> contacts, Comparator<Contact> comparator) {

        contacts.sort(comparator);

    }

}
