package phonebook.searching;

import phonebook.domain.Contact;
import phonebook.hashtable.HashTable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Searching {

    private final ISearching method;

    public Searching(ISearching method) {

        this.method = method;

    }

    public List<Contact> apply(List<Contact> contacts, List<Contact> searchedContacts,
                               Comparator<Contact> comparator) {

        return searchedContacts.stream()
                               .filter(fc -> method.getIdx(contacts, fc, comparator) > -1)
                               .collect(Collectors.toList());

    }

    public List<Contact> apply(HashTable<Contact> contacts, List<Contact> searchedContacts) {

        return searchedContacts.stream()
                               .filter(fc -> contacts.get(Math.abs(fc.hashCode())) != null)
                               .collect(Collectors.toList());

    }

}
