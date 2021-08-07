package by.valvik.phonebook.hashtable;

import by.valvik.phonebook.domain.Contact;

import java.util.List;

import static java.lang.Math.abs;

public class HashTableCreating {

    public static HashTable<Contact> create(List<Contact> contacts) {

        HashTable<Contact> hashTable = new HashTable<>();

        contacts.forEach(contact -> hashTable.put(abs(contact.hashCode()), contact));

        return hashTable;

    }

}
