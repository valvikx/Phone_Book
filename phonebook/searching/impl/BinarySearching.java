package phonebook.searching.impl;

import phonebook.domain.Contact;
import phonebook.searching.ISearching;

import java.util.Comparator;
import java.util.List;

public class BinarySearching implements ISearching {

    @Override
    public int getIdx(List<Contact> contacts, Contact searchedContact,
                      Comparator<Contact> comparator) {

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
