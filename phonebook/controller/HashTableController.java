package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.hashtable.CreatingHashTable;
import phonebook.hashtable.HashTable;
import phonebook.searching.Searching;
import phonebook.view.Console;

import java.util.List;

public class HashTableController extends ProcessingController {

    public HashTableController(Console console) {

        super(console, new Searching(null), null);

    }

    @Override
    void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        console.displayStartSearching("hash table");

        timer.start();

        HashTable<Contact> contactsHashTable = CreatingHashTable.create(contacts);

        timer.finish();

        long creatingMillis = timer.toMillis();

        timer.start();

        foundContacts = searching.apply(contactsHashTable, searchedContacts);

        timer.finish();

        searchingMillis = timer.toMillis();

        console.displayFoundContacts(foundContacts.size(), searchedContacts.size());

        timer.sumMillis(creatingMillis, searchingMillis);

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        timer.setNewDuration(creatingMillis);

        console.displayCreatingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        displaySearchingTime();

    }

}
