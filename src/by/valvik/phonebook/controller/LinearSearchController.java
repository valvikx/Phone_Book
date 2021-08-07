package by.valvik.phonebook.controller;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.searching.impl.LinearSearching;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

public class LinearSearchController extends ProcessingController {

    private static final String LINEAR_SEARCH = "linear search";

    public LinearSearchController(Timer timer, Console console) {

        super(timer, console, new SearchingMethod(new LinearSearching()));

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        console.displayStartSearching(LINEAR_SEARCH);

        displayFoundContacts(contacts, searchedContacts);

        displaySearchingTime();

    }

}
