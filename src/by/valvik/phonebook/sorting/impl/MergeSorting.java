package by.valvik.phonebook.sorting.impl;

import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.sorting.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorting implements Sorting {

    @Override
    public void sort(List<Contact> contacts, Comparator<Contact> comparator) {

        mergeSort(contacts, comparator, 0, contacts.size());

    }

    private void mergeSort(List<Contact> contacts, Comparator<Contact> comparator,
                           int left, int right) {

        if (right <= left + 1) {

            return;

        }

        int mid = left + (right - left) / 2;

        mergeSort(contacts, comparator, left, mid);

        mergeSort(contacts, comparator, mid, right);

        merge(contacts, comparator, left, mid, right);

    }

    private void merge(List<Contact> contacts, Comparator<Contact> comparator,
                       int left, int mid, int right) {

        int i = left;

        int j = mid;

        int k = 0;

        List<Contact> temp = new ArrayList<>();

        while (i < mid && j < right) {

            if (comparator.compare(contacts.get(i), contacts.get(j)) <= 0) {

                temp.add(contacts.get(i));

                i++;

            } else {

                temp.add(contacts.get(j));

                j++;

            }

            k++;

        }

        for (; i < mid; i++, k++) {

            temp.add(contacts.get(i));

        }

        for (; j < right; j++, k++) {

            temp.add(contacts.get(j));

        }

        for (int n = 0; n < temp.size(); n++) {

            contacts.set(left + n, temp.get(n));

        }

    }

}
