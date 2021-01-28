package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.hashtable.CreatingHashTable;
import phonebook.hashtable.HashTable;
import phonebook.searching.Searching;
import phonebook.view.Console;

import java.util.List;

public class HashTableProcessingController extends ProcessingController {

    public HashTableProcessingController(Console console) {

        super(console, new Searching(null), null);

    }

    @Override
    void execute(List<Contact> contacts, List<Contact> findContacts) {

        console.displayStartSearching("hash table");

        timer.start();

        HashTable<Contact> contactsHashTable = CreatingHashTable.create(contacts, Contact::getName);

        timer.finish();

        long creatingMillis = timer.toMillis();

        timer.start();

        List<Contact> searchedContacts = searching.apply(contactsHashTable, findContacts);

        timer.finish();

        searchingMillis = timer.toMillis();

        console.displayFoundContacts(searchedContacts.size(), findContacts.size());

        timer.sumMillis(creatingMillis, searchingMillis);

        console.displayElapsedTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        timer.setNewDuration(creatingMillis);

        console.displayCreatingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

        timer.setNewDuration(searchingMillis);

        console.displaySearchingTime(timer.getMinutes(), timer.getSeconds(), timer.getMillis());

    }

}
