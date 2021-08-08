package by.valvik.phonebook.command;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.hashtable.HashTableHandler;
import by.valvik.phonebook.searching.SearchingMethod;
import by.valvik.phonebook.searching.impl.HashTableSearchingAdapter;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.time.Duration;
import java.util.List;

public class HashTableSearchCommand extends BaseCommand {

    private static final String HASH_TABLE = "hash table";

    private static final String CREATING_TIME = "Creating time:";

    private final HashTableHandler hashTableHandler;

    public HashTableSearchCommand(Timer timer, Console console, HashTableHandler hashTableHandler) {

        super(timer, console,
              new SearchingMethod(new HashTableSearchingAdapter(hashTableHandler)));

        this.hashTableHandler = hashTableHandler;

    }

    @Override
    public void execute(List<Contact> contacts, List<Contact> searchedContacts) {

        getConsole().displayStartSearching(HASH_TABLE);

        Duration fillDuration = determineFillHashTableDuration(contacts);

        determineElapsedTime(fillDuration, CREATING_TIME);

        Duration searchDuration = getSearchDuration(contacts, searchedContacts);

        Duration totalDuration = fillDuration.plus(searchDuration);

        determineElapsedTime(totalDuration, TIME_TAKEN);

    }

    private Duration determineFillHashTableDuration(List<Contact> contacts) {

        getTimer().start();

        hashTableHandler.fillHashTable(contacts);

        return getTimer().finish();

    }

}
