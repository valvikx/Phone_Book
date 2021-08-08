package by.valvik.phonebook.command;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.searching.impl.JumpSearching;
import by.valvik.phonebook.sorting.SortingMethod;
import by.valvik.phonebook.sorting.impl.StandardSorting;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

public class BubbleSortAndJumpSearchCommand extends BaseCommand {

    private static final String BUBBLE_SORT_JUMP_SEARCH = "bubble sort + jump search";

    public BubbleSortAndJumpSearchCommand(Timer timer, Console console) {

        super(timer, console, new SearchingMethod(new JumpSearching()),
              // The bubble sorting is replaced with java library sorting!!!
              // The bubble sorting of the test data from the directory.txt is over 10 hours!!!
              new SortingMethod(new StandardSorting()));

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        getConsole().displayStartSearching(BUBBLE_SORT_JUMP_SEARCH);

        determineSortAndSearchDuration(contacts, searchedContacts);

    }

}
