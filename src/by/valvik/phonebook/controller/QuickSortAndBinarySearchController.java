package by.valvik.phonebook.controller;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.searching.impl.BinarySearching;
import by.valvik.phonebook.sorting.SortingMethod;
import by.valvik.phonebook.sorting.impl.QuickSorting;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

public class QuickSortAndBinarySearchController extends ProcessingController {

    private static final String QUICK_SORT_BINARY_SEARCH = "quick sort + binary search";

    public QuickSortAndBinarySearchController(Timer timer, Console console) {

        super(timer, console, new SearchingMethod(new BinarySearching()),
              new SortingMethod(new QuickSorting()));

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        console.displayStartSearching(QUICK_SORT_BINARY_SEARCH);

        displayFoundContactsAfterSearching(contacts, searchedContacts);

    }

}
