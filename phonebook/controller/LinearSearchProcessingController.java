package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.searching.Searching;
import phonebook.searching.impl.LinearSearching;
import phonebook.view.Console;

import java.util.List;

public class LinearSearchProcessingController extends ProcessingController {

    public LinearSearchProcessingController(Console console) {

        super(console, new Searching(new LinearSearching()), null);

    }

    @Override
    void execute(List<Contact> contacts, List<Contact> searchContacts) {

        console.displayStartSearching("linear search");

        search(contacts, searchContacts);

        console.displayFoundContacts(foundContacts.size(), searchContacts.size());

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        console.displayMessage("\n");

    }

}
