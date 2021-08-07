package by.valvik.phonebook.searching;


import by.valvik.phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public interface Searching {

    int getIdx(List<Contact> contacts, Contact searchedContact, Comparator<Contact> comparator);

}
