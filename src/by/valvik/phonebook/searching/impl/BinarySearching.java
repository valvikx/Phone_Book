package by.valvik.phonebook.searching.impl;


import by.valvik.phonebook.domain.Contact;
import by.valvik.phonebook.searching.Searching;

import java.util.Comparator;
import java.util.List;

public class BinarySearching implements Searching {

    @Override
    public int getIdx(List<Contact> contacts, Contact searchedContact, Comparator<Contact> comparator) {

        int left = 0;

        int right = contacts.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (comparator.compare(contacts.get(mid), searchedContact) == 0) {

                return mid;

            } else if (comparator.compare(contacts.get(mid), searchedContact) > 0) {

                right = mid - 1;

            } else {

                left = mid + 1;

            }

        }

        return -1;

    }

}
