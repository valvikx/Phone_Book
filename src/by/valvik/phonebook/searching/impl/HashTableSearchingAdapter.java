package by.valvik.phonebook.searching.impl;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.hashtable.HashTable;
import by.valvik.phonebook.hashtable.HashTableHandler;
import by.valvik.phonebook.searching.Searching;

import java.util.Comparator;
import java.util.List;

import static java.util.Objects.nonNull;

public class HashTableSearchingAdapter implements Searching {

    private final HashTable<Contact> hashTable;

    public HashTableSearchingAdapter(HashTableHandler hashTableHandler) {

        this.hashTable = hashTableHandler.getHashTable();

    }

    @Override
    public int getIdx(List<Contact> contacts, Contact searchedContact, Comparator<Contact> comparator) {

        Contact contact = hashTable.get(searchedContact.hashCode());

        return nonNull(contact) ? 0 : -1;

    }

}
