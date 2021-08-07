package by.valvik.phonebook.sorting;

import by.valvik.phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public interface Sorting {

    void sort(List<Contact> contacts, Comparator<Contact> comparator);

    default void swap(List<Contact> contacts, int firstIdx, int secondIdx) {

        Contact temp = contacts.set(firstIdx, contacts.get(secondIdx));

        contacts.set(secondIdx, temp);

    }

}
