package phonebook.controller;

import phonebook.datastruct.HashTable;
import phonebook.domain.Contact;
import phonebook.exception.PhoneBookException;
import phonebook.io.PhoneBookIO;
import phonebook.model.Find;
import phonebook.model.Timer;
import phonebook.view.Console;

import java.util.ArrayList;
import java.util.List;

import static phonebook.constant.Methods.*;

public class PhoneBook {

    // https://stepik.org/media/attachments/lesson/197761/directory.txt
    private static final String DIRECTORY_PATH = "C:\\Users\\dell\\IdeaProjects\\Phone Book Source\\directory.txt";

    // https://stepik.org/media/attachments/lesson/197761/find.txt
    private static final String FIND_PATH = "C:\\Users\\dell\\IdeaProjects\\Phone Book Source\\find.txt";

    private static final String LINEAR_SEARCH = "linear search";

    private static final String BUBBLE_SORT_JUMP_SEARCH = "bubble sort + jump search";

    private static final String QUICK_SORT_BINARY_SEARCH = "quick sort + binary search";

    private static final String HASH_TABLE = "hash table";

    private final Timer timer = new Timer();

    private final Console console = new Console();

    private final Find find = new Find();

    private final List<Contact> searchResults = new ArrayList<>();

    private List<Contact> phoneBook;

    private List<Contact> findContacts;

    public void run() {

        PhoneBookIO phoneBookIO = new PhoneBookIO();

        try {

            phoneBook = phoneBookIO.getData(DIRECTORY_PATH);

            findContacts = phoneBookIO.getData(FIND_PATH);

            linearSearch();

            console.displayEmptyLine();

            bubbleSortAndJumpSearch();

            console.displayEmptyLine();

            quickSortAndBinarySearch();

            console.displayEmptyLine();

            createAndSearchHashTable();

        } catch (PhoneBookException e) {

            console.displayMessage(e.getMessage());

        }

    }

    private void linearSearch() {

        console.displayStartSearching(LINEAR_SEARCH);

        timer.start();

        find.applySearching(phoneBook, findContacts, searchResults, LINEAR);

        timer.finish();

        console.displayFoundEntries(searchResults.size(), findContacts.size());

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

    private void bubbleSortAndJumpSearch() {

        // Bubble sort replaced by standard library sort !!!
        // Test data from directory.txt processes by bubble sort more than 10 hours !!!
        sortAndSearch(BUBBLE_SORT_JUMP_SEARCH, STANDARD, JUMP);

    }

    private void quickSortAndBinarySearch() {

        sortAndSearch(QUICK_SORT_BINARY_SEARCH, QUICK, BINARY);

    }

    private void createAndSearchHashTable() {

        createAndSearch();

    }

    private void sortAndSearch(String title, int sortingMethod, int searchingMethod) {

        searchResults.clear();

        List<Contact> phoneBookCopy = new ArrayList<>(phoneBook);

        console.displayStartSearching(title);

        timer.start();

        find.applySorting(phoneBookCopy, sortingMethod);

        timer.finish();

        console.displaySortingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        long sortingMillis = timer.toMillis();

        timer.start();

        find.applySearching(phoneBookCopy, findContacts, searchResults, searchingMethod);

        timer.finish();

        long searchingMillis = timer.toMillis();

        console.displaySearchingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        console.displayFoundEntries(searchResults.size(), findContacts.size());

        timer.addMillis(sortingMillis, searchingMillis);

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

    private void createAndSearch() {

        searchResults.clear();

        console.displayStartSearching(HASH_TABLE);

        timer.start();

        HashTable<Contact> hashTable = find.applyHashTableCreating(phoneBook);

        timer.finish();

        console.displayCreatingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        long creatingMillis = timer.toMillis();

        timer.start();

        find.applySearching(hashTable, findContacts, searchResults);

        timer.finish();

        long searchingMillis = timer.toMillis();

        console.displaySearchingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        console.displayFoundEntries(searchResults.size(), findContacts.size());

        timer.addMillis(creatingMillis, searchingMillis);

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

}
