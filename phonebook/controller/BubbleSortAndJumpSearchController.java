package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.searching.Searching;
import phonebook.searching.impl.JumpSearching;
import phonebook.sorting.Sorting;
import phonebook.sorting.impl.StandardSorting;
import phonebook.view.Console;

import java.util.List;

public class BubbleSortAndJumpSearchController extends ProcessingController {

    public BubbleSortAndJumpSearchController(Console console) {

        super(console, new Searching(new JumpSearching()),
              // The bubble sorting is replaced with java library sorting!!!
              // The bubble sorting of the test data from the directory.txt is over 10 hours!!!
              new Sorting(new StandardSorting()));

    }

    @Override
    void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        console.displayStartSearching("bubble sort + jump search");

        displayFoundContactsAfterSearching(contacts, searchedContacts);

    }

}
