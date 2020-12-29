package phonebook.util;

import phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public class Sorting {

    public static void bubble(List<Contact> source, Comparator<Contact> comparator) {

        for (int i = 0; i < source.size() - 1; i++) {

            for (int j = 0; j < source.size() - i - 1; j++) {

                if (comparator.compare(source.get(j), source.get(j + 1)) > 0) {

                    swap(source, j, j + 1);

                }

            }

        }

    }

    public static void quick(List<Contact> source, Comparator<Contact> comparator,
                             int left, int right) {

        if (left < right) {

            int pivotIndex = partition(source, comparator, left, right);

            quick(source, comparator, left, pivotIndex - 1);

            quick(source, comparator, pivotIndex + 1, right);

        }

    }

    private static int partition(List<Contact> source, Comparator<Contact> comparator,
                                 int left, int right) {

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

    private static void swap(List<Contact> list, int firstIdx, int secondIdx) {

        Contact temp = list.set(firstIdx, list.get(secondIdx));

        list.set(secondIdx, temp);

    }

}
