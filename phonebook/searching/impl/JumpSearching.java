package phonebook.searching.impl;

import phonebook.domain.Contact;
import phonebook.searching.ISearching;

import java.util.Comparator;
import java.util.List;

public class JumpSearching implements ISearching {

    @Override
    public int getIdx(List<Contact> contacts, Contact searchedContact,
                      Comparator<Contact> comparator) {

        return getIdx(contacts, searchedContact, comparator, 0);

    }

    private int getIdx(List<Contact> contacts, Contact searchedContact,
                       Comparator<Contact> comparator, int startIdx) {

        int currentIdx = 0;

        int previousIdx = 0;

        if (comparator.compare(contacts.get(contacts.size() - 1), searchedContact) < 0) {

            return -1;

        }

        if (comparator.compare(contacts.get(currentIdx), searchedContact) == 0) {

            return startIdx;

        } else if (contacts.size() == 1) {

            return -1;

        }

        int jumpLength = (int) Math.sqrt(contacts.size());

        while (currentIdx < contacts.size() - 1) {

            currentIdx = Math.min(contacts.size() - 1, currentIdx + jumpLength);

            if (comparator.compare(contacts.get(currentIdx), searchedContact) > 0 ||
                    comparator.compare(contacts.get(currentIdx), searchedContact) == 0) {

                break;

            }

            previousIdx = currentIdx;

        }

        List<Contact> subContacts = contacts.subList(previousIdx + 1, currentIdx + 1);

        return getIdx(subContacts, searchedContact, comparator, startIdx + previousIdx + 1);

    }

}
