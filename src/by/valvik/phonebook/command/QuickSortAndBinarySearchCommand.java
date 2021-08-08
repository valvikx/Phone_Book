package by.valvik.phonebook.command;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.searching.impl.BinarySearching;
import by.valvik.phonebook.sorting.SortingMethod;
import by.valvik.phonebook.sorting.impl.QuickSorting;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

public class QuickSortAndBinarySearchCommand extends BaseCommand {

    private static final String QUICK_SORT_BINARY_SEARCH = "quick sort + binary search";

    public QuickSortAndBinarySearchCommand(Timer timer, Console console) {

        super(timer, console, new SearchingMethod(new BinarySearching()),
              new SortingMethod(new QuickSorting()));

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        getConsole().displayStartSearching(QUICK_SORT_BINARY_SEARCH);

        determineSortAndSearchDuration(contacts, searchedContacts);

    }

}
