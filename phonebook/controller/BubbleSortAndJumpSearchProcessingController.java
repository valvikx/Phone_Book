package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.searching.Searching;
import phonebook.searching.impl.JumpSearching;
import phonebook.sorting.Sorting;
import phonebook.sorting.impl.StandardSorting;
import phonebook.view.Console;

import java.util.List;

public class BubbleSortAndJumpSearchProcessingController extends ProcessingController {

    public BubbleSortAndJumpSearchProcessingController(Console console) {

        super(console, new Searching(new JumpSearching()),
              // The bubble sorting is replaced with java library sorting!!!
              // The test data from the directory.txt is sorted by the bubble sorting over 10 hours!!!
              new Sorting(new StandardSorting()));

    }

    @Override
    void execute(List<Contact> contacts, List<Contact> searchContacts) {

        console.displayStartSearching("bubble sort + jump search");

        sortAndSearch(contacts, searchContacts);

    }

}
