package by.valvik.phonebook.sorting;

import by.valvik.phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public record SortingMethod(Sorting method) {

    public void apply(List<Contact> contacts, Comparator<Contact> comparator) {

        method.sort(contacts, comparator);

    }

}
