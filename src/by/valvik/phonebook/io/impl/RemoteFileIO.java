package by.valvik.phonebook.io.impl;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.exception.AppException;
import by.valvik.phonebook.io.FileIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;

public class RemoteFileIO implements FileIO {

    private static final String ERROR_LOAD = "Cannot load data file from %s";

    private static final String REGEX = "\\s+";

    private static final int LIMIT = 2;

    public List<Contact> getData(String filePath) throws AppException {

        try {

            List<Contact> contacts = new ArrayList<>();

            URL url = new URL(filePath);

            try(InputStream inputStream = url.openStream()){

                Scanner scanner = new Scanner(inputStream);

                while(scanner.hasNextLine()){

                    String line = scanner.nextLine();

                    if (isDigit(line.charAt(0))) {

                        String[] tokens = line.split(REGEX, LIMIT);

                        contacts.add(new Contact(parseInt(tokens[0]), tokens[1]));

                    } else {

                        contacts.add(new Contact(line));

                    }

                }

                return contacts;

            }

        } catch (IOException | NumberFormatException e) {

            throw new AppException(String.format(ERROR_LOAD, filePath));

        }

    }

}
