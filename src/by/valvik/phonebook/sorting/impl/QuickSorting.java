package by.valvik.phonebook.sorting.impl;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.sorting.Sorting;

import java.util.Comparator;
import java.util.List;

public class QuickSorting implements Sorting {

    @Override
    public void sort(List<Contact> contacts, Comparator<Contact> comparator) {

        sort(contacts, comparator, 0, contacts.size() - 1);

    }

    private void sort(List<Contact> contacts, Comparator<Contact> comparator, int left, int right) {

        if (left < right) {

            int pivotIndex = partition(contacts, comparator, left, right);

            sort(contacts, comparator, left, pivotIndex - 1);

            sort(contacts, comparator, pivotIndex + 1, right);

        }


    }

    private int partition(List<Contact> source, Comparator<Contact> comparator, int left, int right) {

        Contact pivot = source.get(right);

        int partitionIndex = left;

        for (int i = left; i < right; i++) {

            if (comparator.compare(source.get(i), pivot) < 0) {

                swap(source, i, partitionIndex);

                partitionIndex++;

            }

        }

        swap(source, partitionIndex, right);

        return partitionIndex;

    }

}
