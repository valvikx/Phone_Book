package phonebook.controller;

import phonebook.domain.Contact;
import phonebook.exception.PhoneBookException;
import phonebook.io.PhoneBookIO;
import phonebook.view.Console;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookController {

    // https://stepik.org/media/attachments/lesson/197761/directory.txt
    private static final String DIRECTORY_PATH = "C:\\Users\\dell\\IdeaProjects\\Phone Book Source\\directory.txt";

    // https://stepik.org/media/attachments/lesson/197761/find.txt
    private static final String FIND_PATH = "C:\\Users\\dell\\IdeaProjects\\Phone Book Source\\find.txt";

    private final Console console = new Console();

    public void run() {

        PhoneBookIO phoneBookIO = new PhoneBookIO();

        try {

            List<Contact> contacts = phoneBookIO.getData(DIRECTORY_PATH);

            List<Contact> searchContacts = phoneBookIO.getData(FIND_PATH);

            new LinearSearchController(console).start(contacts, searchContacts);

            new BubbleSortAndJumpSearchController(console).start(new ArrayList<>(contacts), searchContacts);

            new QuickSortBinarySearchController(console).start(new ArrayList<>(contacts), searchContacts);

            new HashTableController(console).start(contacts, searchContacts);

        } catch (PhoneBookException e) {

            console.displayMessage(e.getMessage());

        }

    }

}
