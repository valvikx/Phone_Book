package by.valvik.phonebook.hashtable;

import java.util.Arrays;

public class HashTable<V> {

    private static final int SCALING_FACTOR = 8;

    private int size;

    private Entry<V>[] table;

    public HashTable() {

        this.size = 4;

        this.table = new Entry[size];

    }

    public void put(int key, V value) {

        int idx = findKey(key);

        table[idx] = new Entry<>(key, value);

    }

    public V get(int key) {

        int idx = findKey(key);

        if (idx == -1 || table[idx] == null) {

            return null;

        }

        return table[idx].value();

    }

    private int findKey(int key) {

        int hash = key % size;

        while (!(table[hash] == null || table[hash].key() == key)) {

            hash = (hash + 1) % size;

            if (hash == key % size) {

                rehash();

            }

        }

        return hash;
    }

    private void rehash() {

        Entry<V>[] oldTable = table;

        size *= SCALING_FACTOR;

        table = new Entry[size];

        Arrays.stream(oldTable)
              .forEach(entry -> put(entry.key(), entry.value()));

    }

    private record Entry<V>(int key, V value) {

    }

}
