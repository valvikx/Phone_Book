package by.valvik.phonebook.io;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.exception.AppException;

import java.util.List;

public interface FileIO {

    List<Contact> getData(String filePath) throws AppException;

}
