package phonebook.datastruct;

import java.util.Arrays;

public class HashTable<V> {

    private int size = 4;

    private Entry<V>[] table;

    public HashTable() {

        table = new Entry[size];

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

        return table[idx].getValue();

    }

    private int findKey(int key) {

        int hash = key % size;

        while (!(table[hash] == null || table[hash].getKey() == key)) {

            hash = (hash + 1) % size;

            if (hash == key % size) {

                rehash();

            }

        }

        return hash;
    }

    private void rehash() {

        int scalingFactor = 8;

        Entry<V>[] oldTable = table;

        size *= scalingFactor;

        table = new Entry[size];

        Arrays
              .stream(oldTable)
              .forEach(entry -> put(entry.getKey(), entry.getValue()));

    }

    private static class Entry<V> {

        private final int key;

        private final V value;

        public Entry(int key, V value) {

            this.key = key;

            this.value = value;

        }

        public int getKey() {

            return key;

        }

        public V getValue() {

            return value;

        }

    }

}
