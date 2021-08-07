package by.valvik.phonebook.controller;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.sorting.SortingMethod;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

import static java.util.Comparator.comparing;

public abstract class ProcessingController {

    protected final Timer timer;

    protected final Console console;

    protected SearchingMethod searching;

    private SortingMethod sorting;

    protected long searchingMillis;

    private long sortingMillis;

    protected List<Contact> foundContacts;

    public ProcessingController(Timer timer, Console console) {

        this.timer = timer;

        this.console = console;

    }

    public ProcessingController(Timer timer, Console console, SearchingMethod searching) {

        this.timer = timer;

        this.console = console;

        this.searching = searching;

    }

    public ProcessingController(Timer timer, Console console, SearchingMethod searching, SortingMethod sorting) {

        this.timer = timer;

        this.console = console;

        this.searching = searching;

        this.sorting = sorting;

    }

    public abstract void execute(List<Contact> contacts, List<Contact> searchedContacts);

    public void displayFoundContacts(List<Contact> contacts, List<Contact> searchedContacts) {

        search(contacts, searchedContacts);

        console.displayFoundContacts(foundContacts.size(), searchedContacts.size());

    }

    public void displayFoundContactsAfterSearching(List<Contact> contacts, List<Contact> searchedContacts) {

        sort(contacts);

        displayFoundContacts(contacts, searchedContacts);

        displayTakenTime();

        displaySortingTime();

        displaySearchingTime();

    }

    private void search(List<Contact> contacts, List<Contact> searchedContacts) {

        timer.start();

        foundContacts = searching.apply(contacts, searchedContacts, comparing(Contact::name));

        timer.finish();

        searchingMillis = timer.toMillis();

    }

    private void sort(List<Contact> contacts) {

        timer.start();

        sorting.apply(contacts, comparing(Contact::name));

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
