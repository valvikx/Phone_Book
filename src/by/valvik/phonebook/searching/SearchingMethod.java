package by.valvik.phonebook.searching;

import by.valvik.phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public record SearchingMethod(Searching method) {

    public List<Contact> apply(List<Contact> contacts, List<Contact> searchedContacts,
                               Comparator<Contact> comparator) {

        return searchedContacts.stream()
                               .filter(fc -> method.getIdx(contacts, fc, comparator) > -1)
                               .toList();

    }

}
