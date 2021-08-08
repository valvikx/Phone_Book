package by.valvik.phonebook.command;

import by.valvik.phonebook.dao.Dao;
import by.valvik.phonebook.dao.impl.RemoteDao;
import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.exception.AppException;
import by.valvik.phonebook.view.Console;

import java.util.List;

public class DataCommand {

    private static final String DIRECTORY_URL = "https://stepik.org/media/attachments/lesson/197761/directory.txt";

    private static final String FIND_URL = "https://stepik.org/media/attachments/lesson/197761/find.txt";

    private static final String PHONE_BOOK = """
        ************************** Phone book ************************************
        *** Application for testing a variety of sorting and search algorithms ***      
        Please wait until the test files are downloaded...\n
        """;

    private static final String TEST_FILES_DOWNLOADED = """
        Download process is complete.
        >>List of %d contacts has been created.                 
        >>List of %d searched contacts has been created.\n
        """;

    private final Dao dao;

    private final Console console;

    private List<Contact> contacts;

    private List<Contact> searchedContacts;

    public DataCommand(Console console) {

        this.console = console;

        this.dao = new RemoteDao();

    }

    public void execute() throws AppException {

        console.display(PHONE_BOOK);

        contacts = dao.getData(DIRECTORY_URL);

        searchedContacts = dao.getData(FIND_URL);

        console.display(TEST_FILES_DOWNLOADED, contacts.size(), searchedContacts.size());

    }

    public List<Contact> getContacts() {

        return contacts;

    }

    public List<Contact> getSearchedContacts() {

        return searchedContacts;

    }

}
