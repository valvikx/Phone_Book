package by.valvik.phonebook.command;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.sorting.SortingMethod;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.time.Duration;
import java.util.List;

import static java.util.Comparator.comparing;

public abstract class BaseCommand {

    private static final String FOUND_ENTRIES = "Found %d of %d entries.\n";

    private static final String TIME_TEMPLATE = "%s %d min. %d sec. %d ms. %d ns.\n";

    private static final String SEARCHING_TIME = "Searching time:";

    private static final String SORTING_TIME = "Sorting time:";

    public static final String TIME_TAKEN = "Time taken:";

    private final Timer timer;

    private final Console console;

    private final SearchingMethod searchingMethod;

    private SortingMethod sortingMethod;

    private List<Contact> foundContacts;

    public BaseCommand(Timer timer, Console console, SearchingMethod searchingMethod) {

        this.timer = timer;

        this.console = console;

        this.searchingMethod = searchingMethod;

    }

    public BaseCommand(Timer timer, Console console, SearchingMethod searchingMethod, SortingMethod sortingMethod) {

        this.timer = timer;

        this.console = console;

        this.searchingMethod = searchingMethod;

        this.sortingMethod = sortingMethod;

    }

    public abstract void execute(List<Contact> contacts, List<Contact> searchedContacts);

    public void determineSortAndSearchDuration(List<Contact> contacts, List<Contact> searchedContacts) {

        Duration sortDuration = getSortDuration(contacts);

        Duration searchDuration = getSearchDuration(contacts, searchedContacts);

        Duration totalDuration = sortDuration.plus(searchDuration);

        determineElapsedTime(totalDuration, TIME_TAKEN);

    }

    public Duration getSortDuration(List<Contact> contacts) {

        Duration duration = sort(contacts);

        determineElapsedTime(duration, SORTING_TIME);

        return duration;

    }

    public Duration getSearchDuration(List<Contact> contacts, List<Contact> searchedContacts) {

        Duration duration = search(contacts, searchedContacts);

        console.display(FOUND_ENTRIES, foundContacts.size(), searchedContacts.size());

        determineElapsedTime(duration, SEARCHING_TIME);

        return duration;

    }

    public void determineElapsedTime(Duration duration, String operation) {

        timer.setDuration(duration);

        console.display(TIME_TEMPLATE, operation,
                timer.getMinutes(), timer.getSeconds(), timer.getMillis(), timer.getNanos());

    }

    public Console getConsole() {

        return console;

    }

    public Timer getTimer() {

        return timer;

    }

    private Duration search(List<Contact> contacts, List<Contact> searchedContacts) {

        timer.start();

        foundContacts = searchingMethod.apply(contacts, searchedContacts, comparing(Contact::name));

        return timer.finish();

    }

    private Duration sort(List<Contact> contacts) {

        timer.start();

        sortingMethod.apply(contacts, comparing(Contact::name));

        return timer.finish();

    }

}
