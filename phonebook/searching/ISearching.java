package phonebook.searching;

import phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public interface ISearching {

    int getIdx(List<Contact> contacts, Contact searchedContact,
               Comparator<Contact> comparator);

}
