package by.valvik.phonebook.controller;

import by.valvik.phonebook.command.*;
import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.exception.AppException;
import by.valvik.phonebook.hashtable.HashTableHandler;
import by.valvik.phonebook.timer.Timer;
import by.valvik.phonebook.view.Console;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    public void run() {

        Console console = new Console();

        Timer timer = new Timer();

        HashTableHandler hashTableHandler = new HashTableHandler();

        try {

            DataCommand dataCommand = new DataCommand(console);

            dataCommand.execute();

            List<Contact> contacts = dataCommand.getContacts();

            List<Contact> searchedContacts = dataCommand.getSearchedContacts();

            new LinearSearchCommand(timer, console).execute(contacts, searchedContacts);

            new BubbleSortAndJumpSearchCommand(timer, console).execute(new ArrayList<>(contacts), searchedContacts);

            new QuickSortAndBinarySearchCommand(timer, console).execute(new ArrayList<>(contacts), searchedContacts);

            new HashTableSearchCommand(timer, console, hashTableHandler).execute(contacts, searchedContacts);

        } catch (AppException e) {

            console.display(e.getMessage());

        }

    }

}
