package by.valvik.phonebook.command;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.searching.impl.LinearSearching;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

public class LinearSearchCommand extends BaseCommand {

    private static final String LINEAR_SEARCH = "LINEAR SEARCH";

    public LinearSearchCommand(Timer timer, Console console) {

        super(timer, console, new SearchingMethod(new LinearSearching()));

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        getConsole().displayStartSearching(LINEAR_SEARCH);

        getSearchDuration(contacts, searchedContacts);

        getConsole().displayEmptyLine();

    }

}
