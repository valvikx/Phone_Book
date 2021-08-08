package by.valvik.phonebook.dao;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.exception.AppException;

import java.util.List;

public interface Dao {

    List<Contact> getData(String filePath) throws AppException;

}
