package by.valvik.phonebook.searching;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.hashtable.HashTable;

import java.util.Comparator;
import java.util.List;

import static java.lang.Math.abs;

public record SearchingMethod(Searching method) {

    public List<Contact> apply(List<Contact> contacts, List<Contact> searchedContacts,
                               Comparator<Contact> comparator) {

        return searchedContacts.stream()
                               .filter(fc -> method.getIdx(contacts, fc, comparator) > -1)
                               .toList();

    }

    public List<Contact> apply(HashTable<Contact> contacts, List<Contact> searchedContacts) {

        return searchedContacts.stream()
                               .filter(c -> contacts.get(abs(c.hashCode())) != null)
                               .toList();

    }

}
