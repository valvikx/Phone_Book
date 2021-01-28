package phonebook.hashtable;

import phonebook.domain.Contact;

import java.util.List;

public class CreatingHashTable {

    public static HashTable<Contact> create(List<Contact> contacts) {

        HashTable<Contact> hashTable = new HashTable<>();

        contacts.forEach(contact -> hashTable.put(Math.abs(contact.hashCode()), contact));

        return hashTable;

    }

}
