package by.valvik.phonebook.controller;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.hashtable.HashTable;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.List;

import static by.valvik.phonebook.hashtable.HashTableCreating.create;

public class HashTableController extends ProcessingController {

    private static final String HASH_TABLE = "hash table";

    public HashTableController(Timer timer, Console console) {

        super(timer, console);

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        console.displayStartSearching(HASH_TABLE);

        timer.start();

        HashTable<Contact> contactsHashTable = create(contacts);

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
