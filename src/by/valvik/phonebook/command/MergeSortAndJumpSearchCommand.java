package by.valvik.phonebook.command;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.searching.impl.JumpSearching;
import by.valvik.phonebook.sorting.SortingMethod;
import by.valvik.phonebook.sorting.impl.MergeSorting;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

public class MergeSortAndJumpSearchCommand extends BaseCommand {

    private static final String MERGE_SORT_JUMP_SEARCH = "MERGE SORT + JUMP SEARCH";

    public MergeSortAndJumpSearchCommand(Timer timer, Console console) {

        super(timer, console, new SearchingMethod(new JumpSearching()),
              // The bubble sorting is replaced with merge sorting!!!
              // The bubble sorting of the test data from the directory.txt is over 10 hours!!!
              new SortingMethod(new MergeSorting()));

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        getConsole().displayStartSearching(MERGE_SORT_JUMP_SEARCH);

        determineSortAndSearchDuration(contacts, searchedContacts);

        getConsole().displayEmptyLine();

    }

}
