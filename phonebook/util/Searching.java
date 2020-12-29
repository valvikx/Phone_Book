package phonebook.util;

import phonebook.domain.Contact;

import java.util.Comparator;
import java.util.List;

public class Searching {

    public static int linear(List<Contact> source, Contact find,
                             Comparator<Contact> comparator) {

        for (int i = 0; i < source.size(); i++) {

            if (comparator.compare(source.get(i), find) == 0) {

                return i;

            }

        }

        return -1;

    }

    public static int jump(List<Contact> source, Contact find,
                           Comparator<Contact> comparator, int startIdx) {

        int currentIdx = 0;

        int prevIdx = 0;

        if (comparator.compare(source.get(source.size() - 1), find) < 0) {

            return -1;

        }

        if (comparator.compare(source.get(currentIdx), find) == 0) {

            return startIdx;

        } else if (source.size() == 1) {

            return -1;

        }

        int jumpLength = (int) Math.sqrt(source.size());

        while (currentIdx < source.size() - 1) {

            currentIdx = Math.min(source.size() - 1, currentIdx + jumpLength);

            if (comparator.compare(source.get(currentIdx), find) > 0) {

                break;

            } else if (comparator.compare(source.get(currentIdx), find) == 0) {

                break;

            }

            prevIdx = currentIdx;

        }

        List<Contact> subPhoneBook = source.subList(prevIdx + 1, currentIdx + 1);

        return jump(subPhoneBook, find, comparator, startIdx + prevIdx + 1);

    }

    public static int binary(List<Contact> source, Contact find,
                             Comparator<Contact> comparator) {

        int left = 0;

        int right = source.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (comparator.compare(source.get(mid), find) == 0) {

                return mid;

            } else if (comparator.compare(source.get(mid), find) > 0) {

                right = mid - 1;

            } else {

                left = mid + 1;
            }
        }

        return -1;

    }

}
