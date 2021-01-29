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

            List<Contact> searchedContacts = phoneBookIO.getData(FIND_PATH);

            new LinearSearchController(console).execute(contacts, searchedContacts);

            new BubbleSortAndJumpSearchController(console).execute(new ArrayList<>(contacts),
                                                                   searchedContacts);

            new QuickSortAndBinarySearchController(console).execute(new ArrayList<>(contacts),
                                                                    searchedContacts);

            new HashTableController(console).execute(contacts, searchedContacts);

        } catch (PhoneBookException e) {

            console.display(e.getMessage());

        }

    }

}
