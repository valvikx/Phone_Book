package phonebook.io;

import phonebook.domain.Contact;
import phonebook.exception.PhoneBookException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBookIO {

    private static final String ERROR_LOAD = "Cannot load data from %s file";

    private static final String ERROR_SAVE = "Unable to save data in %s file";

    public List<Contact> getData(String filePath) throws PhoneBookException {

        Path path = Paths.get(filePath);

        try {

            return Files
                         .lines(path)
                         .map(s -> {

                             // see structure of directory.txt
                             if (Character.isDigit(s.charAt(0))) {

                                 String[] tokens = s.split("\\s+", 2);

                                 return new Contact(Integer.parseInt(tokens[0]), tokens[1]);

                             } else {

                                 // see structure of find.txt
                                 return new Contact(0, s);

                             }

                         })
                         .collect(Collectors.toList());

        } catch (IOException | NumberFormatException e) {

            throw new PhoneBookException(String.format(ERROR_LOAD, filePath));

        }

    }

    public void saveData(String filePath, List<Contact> source) throws PhoneBookException {

        File file = new File(filePath);

        try (PrintWriter printWriter = new PrintWriter(file)) {

            source.forEach(p -> printWriter.printf("%d %s\n", p.getPhoneNumber(), p.getName()));

        } catch (IOException e) {

            throw new PhoneBookException(String.format(ERROR_SAVE, filePath));

        }

    }

}
