package by.valvik.phonebook.hashtable;

import by.valvik.phonebook.domain.Contact;

import java.util.List;

public class HashTableHandler {

    private final HashTable<Contact> hashTable ;

    public HashTableHandler() {

        this.hashTable = new HashTable<>();

    }

    public void fillHashTable(List<Contact> contacts) {

        contacts.forEach(contact -> hashTable.put(contact.hashCode(), contact));

    }

    public HashTable<Contact> getHashTable() {

        return hashTable;

    }

}
