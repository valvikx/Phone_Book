package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.searching.Searching;
import phonebook.searching.impl.BinarySearching;
import phonebook.sorting.Sorting;
import phonebook.sorting.impl.QuickSorting;
import phonebook.view.Console;

import java.util.List;

public class QuickSortAndBinarySearchProcessingController extends ProcessingController {

    public QuickSortAndBinarySearchProcessingController(Console console) {

        super(console, new Searching(new BinarySearching()),
              new Sorting(new QuickSorting()));

    }

    @Override
    void execute(List<Contact> contacts, List<Contact> searchContacts) {

        console.displayStartSearching("quick sort + binary search");

        sortAndSearch(contacts, searchContacts);

    }

}
