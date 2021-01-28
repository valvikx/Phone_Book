package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.searching.Searching;
import phonebook.sorting.Sorting;
import phonebook.timer.Timer;
import phonebook.view.Console;

import java.util.Comparator;
import java.util.List;

public abstract class ProcessingController {

    final Timer timer = new Timer();

    final Searching searching;

    final Sorting sorting;

    final Console console;

    long sortingMillis;

    long searchingMillis;

    List<Contact> foundContacts;

    public ProcessingController(Console console, Searching searching, Sorting sorting) {

        this.console = console;

        this.searching = searching;

        this.sorting = sorting;

    }

    abstract void execute(List<Contact> contacts, List<Contact> searchContacts);

    void search(List<Contact> contacts, List<Contact> searchContacts) {

        timer.start();

        foundContacts =
                searching.apply(contacts, searchContacts, Comparator.comparing(Contact::getName));

        timer.finish();

        searchingMillis = timer.toMillis();

    }

    void sort(List<Contact> contacts) {

        timer.start();

        sorting.apply(contacts, Comparator.comparing(Contact::getName));

        timer.finish();

        sortingMillis = timer.toMillis();

    }

    void sortAndSearch(List<Contact> contacts, List<Contact> searchContacts) {

        sort(contacts);

        search(contacts, searchContacts);

        console.displayFoundContacts(foundContacts.size(), searchContacts.size());

        timer.sumMillis(sortingMillis, searchingMillis);

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        timer.setNewDuration(sortingMillis);

        console.displaySortingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        timer.setNewDuration(searchingMillis);

        console.displaySearchingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

}
