package by.valvik.phonebook.sorting.impl;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.sorting.Sorting;

import java.util.Comparator;
import java.util.List;

public class BubleSorting implements Sorting {

    @Override
    public void sort(List<Contact> contacts, Comparator<Contact> comparator) {

        for (int i = 0; i < contacts.size() - 1; i++) {

            for (int j = 0; j < contacts.size() - i - 1; j++) {

                if (comparator.compare(contacts.get(j), contacts.get(j + 1)) > 0) {

                    swap(contacts, j, j + 1);

                }

            }

        }

    }

}
