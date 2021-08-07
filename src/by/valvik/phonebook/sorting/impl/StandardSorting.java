package by.valvik.phonebook.sorting.impl;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.sorting.Sorting;

import java.util.Comparator;
import java.util.List;

public class StandardSorting implements Sorting {

    @Override
    public void sort(List<Contact> contacts, Comparator<Contact> comparator) {

        contacts.sort(comparator);

    }

}
