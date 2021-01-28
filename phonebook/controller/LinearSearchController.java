package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.searching.Searching;
import phonebook.searching.impl.LinearSearching;
import phonebook.view.Console;

import java.util.List;

public class LinearSearchController extends ProcessingController {

    public LinearSearchController(Console console) {

        super(console, new Searching(new LinearSearching()), null);

    }

    @Override
    void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        console.displayStartSearching("linear search");

        displayFoundContacts(contacts, searchedContacts);

        displaySearchingTime();

    }

}
