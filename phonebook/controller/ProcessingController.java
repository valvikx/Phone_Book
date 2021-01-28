package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.searching.Searching;
import phonebook.sorting.Sorting;
import phonebook.timer.Timer;
import phonebook.view.Console;

import java.util.Comparator;
import java.util.List;

public abstract class ProcessingController {

    protected final Timer timer = new Timer();

    protected final Console console;

    protected long sortingMillis;

    protected long searchingMillis;

    protected final Searching searching;

    private final Sorting sorting;

    protected List<Contact> foundContacts;

    public ProcessingController(Console console, Searching searching, Sorting sorting) {

        this.console = console;

        this.searching = searching;

        this.sorting = sorting;

    }

    abstract void execute(List<Contact> contacts, List<Contact> searchedContacts);

    protected void displayFoundContacts(List<Contact> contacts, List<Contact> searchedContacts) {

        search(contacts, searchedContacts);

        console.displayFoundContacts(foundContacts.size(), searchedContacts.size());

    }

    protected void displayFoundContactsAfterSearching(List<Contact> contacts,
                                                      List<Contact> searchedContacts) {

        sort(contacts);

        displayFoundContacts(contacts, searchedContacts);

        displayTakenTime();

        displaySortingTime();

        displaySearchingTime();

    }

    private void search(List<Contact> contacts, List<Contact> searchedContacts) {

        timer.start();

        foundContacts =
                searching.apply(contacts, searchedContacts, Comparator.comparing(Contact::getName));

        timer.finish();

        searchingMillis = timer.toMillis();

    }

    private void sort(List<Contact> contacts) {

        timer.start();

        sorting.apply(contacts, Comparator.comparing(Contact::getName));

        timer.finish();

        sortingMillis = timer.toMillis();

    }

    private void displayTakenTime() {

        timer.sumMillis(sortingMillis, searchingMillis);

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

    private void displaySortingTime() {

        timer.setNewDuration(sortingMillis);

        console.displaySortingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

    protected void displaySearchingTime() {

        timer.setNewDuration(searchingMillis);

        console.displaySearchingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

}
