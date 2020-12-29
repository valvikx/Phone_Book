package phonebook.model;

import phonebook.datastruct.HashTable;
import phonebook.domain.Contact;
import phonebook.util.HashTableCreating;
import phonebook.util.Searching;
import phonebook.util.Sorting;

import java.util.Comparator;
import java.util.List;

import static phonebook.constant.Methods.*;

public class Find {

    public void applySearching(List<Contact> source, List<Contact> finds,
                               List<Contact> results, int flagMethod) {

        for (Contact find : finds) {

            int idx = -1;

            switch (flagMethod) {

                case LINEAR:

                    idx = Searching.linear(source, find, Comparator.comparing(Contact::getName));

                    break;

                case JUMP:

                    idx = Searching.jump(source, find, Comparator.comparing(Contact::getName), 0);

                    break;

                case BINARY:

                    idx = Searching.binary(source, find, Comparator.comparing(Contact::getName));

                    break;

            }

            if (idx > -1) {

                results.add(source.get(idx));

            }

        }

    }

    public void applySearching(HashTable<Contact> source, List<Contact> finds,
                               List<Contact> results) {

        for (Contact find : finds) {

            if (find != null) {

                results.add(source.get(Math.abs(find.getName().hashCode())));

            }

        }

    }

    public void applySorting(List<Contact> source, int flagMethod) {

        switch (flagMethod) {

            case STANDARD:

                source.sort(Comparator.comparing(Contact::getName));

                break;


            case BUBBLE:

                Sorting.bubble(source, Comparator.comparing(Contact::getName));

                break;

            case QUICK:

                Sorting.quick(source, Comparator.comparing(Contact::getName),
                          0, source.size() - 1);

                break;

        }

    }

    public HashTable<Contact> applyHashTableCreating(List<Contact> source) {

        return HashTableCreating.create(source, Contact::getName);

    }

}
