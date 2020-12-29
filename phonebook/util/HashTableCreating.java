package phonebook.util;

import phonebook.datastruct.HashTable;
import phonebook.domain.Contact;

import java.util.List;
import java.util.function.Function;

public class HashTableCreating {

    public static <T> HashTable<Contact> create(List<Contact> source,
                                                Function<Contact, T> keyExtractor) {

        HashTable<Contact> hashTable = new HashTable<>();

        source.forEach(contact -> {

                                   T key = keyExtractor.apply(contact);

                                   hashTable.put(Math.abs(key.hashCode()), contact);

        });

        return hashTable;

    }

}
