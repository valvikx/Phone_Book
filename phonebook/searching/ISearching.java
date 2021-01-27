package phonebook.searching;

import phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public interface ISearching {

    int search(List<Contact> contacts, Contact contact, Comparator<Contact> comparator);

}
