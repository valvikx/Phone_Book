package by.valvik.phonebook.searching.impl;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.Searching;

import java.util.Comparator;
import java.util.List;


public class LinearSearching implements Searching {

    @Override
    public int getIdx(List<Contact> contacts, Contact searchedContact, Comparator<Contact> comparator) {

        for (int i = 0; i < contacts.size(); i++) {

            if (comparator.compare(contacts.get(i), searchedContact) == 0) {

                return i;

            }

        }

        return -1;

    }

}
