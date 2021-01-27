package phonebook.hashtable;

import phonebook.domain.Contact;

import java.util.List;
import java.util.function.Function;

public class CreatingHashTable {

    public static <T> HashTable<Contact> create(List<Contact> contacts,
                                                Function<Contact, T> keyExtractor) {

        HashTable<Contact> hashTable = new HashTable<>();

        contacts.forEach(contact -> {

                                   T key = keyExtractor.apply(contact);

                                   hashTable.put(Math.abs(key.hashCode()), contact);

        });

        return hashTable;

    }

}
