package phonebook.searching.impl;

import phonebook.domain.Contact;
import phonebook.searching.ISearching;

import java.util.Comparator;
import java.util.List;

public class LinearSearching implements ISearching {

    @Override
    public int search(List<Contact> contacts, Contact contact,
                      Comparator<Contact> comparator) {

        for (int i = 0; i < contacts.size(); i++) {

            if (comparator.compare(contacts.get(i), contact) == 0) {

                return i;

            }

        }

        return -1;

    }

}
