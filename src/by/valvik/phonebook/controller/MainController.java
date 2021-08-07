package by.valvik.phonebook.controller;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.exception.AppException;
import by.valvik.phonebook.io.FileIO;
import by.valvik.phonebook.io.impl.RemoteFileIO;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private static final String DIRECTORY_URL = "https://stepik.org/media/attachments/lesson/197761/directory.txt";

    private static final String FIND_URL = "https://stepik.org/media/attachments/lesson/197761/find.txt";

    private static final String PLEASE_WAIT_UNTIL_TEST_FILES_ARE_LOADED = "Please wait until the test files are downloaded...\n";

    private static final String TEST_FILES_DOWNLOADED = "Test files downloaded.\n";

    private static final String LIST_WITH_D_CONTACTS_IS_CREATED = "List with %d contacts is created.\n\r\n";

    private final Console console;

    public MainController() {

        this.console = new Console();

    }

    public void run() {

        FileIO fileIO = new RemoteFileIO();

        Timer timer = new Timer();

        try {

            console.display(PLEASE_WAIT_UNTIL_TEST_FILES_ARE_LOADED);

            List<Contact> contacts = fileIO.getData(DIRECTORY_URL);

            List<Contact> searchedContacts = fileIO.getData(FIND_URL);

            console.display(TEST_FILES_DOWNLOADED);

            console.display(LIST_WITH_D_CONTACTS_IS_CREATED, contacts.size());

            new LinearSearchController(timer, console).execute(contacts, searchedContacts);

            new BubbleSortAndJumpSearchController(timer, console).execute(new ArrayList<>(contacts), searchedContacts);

            new QuickSortAndBinarySearchController(timer, console).execute(new ArrayList<>(contacts), searchedContacts);

            new HashTableController(timer, console).execute(contacts, searchedContacts);

        } catch (AppException e) {

            console.display(e.getMessage());

        }

    }

}
