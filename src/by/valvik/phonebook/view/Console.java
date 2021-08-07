package by.valvik.phonebook.view;

public class Console {

    private static final String START_SEARCHING = "Start searching (%s)...\n";

    private static final String FOUND_ENTRIES = "Found %d / %d entries. ";

    private static final String TIME_TAKEN = "Time taken: %d min. %d sec. %d ms.\n";

    private static final String SORTING_TIME = "Sorting time: %d min. %d sec. %d ms.\n";

    private static final String CREATING_TIME = "Creating time: %d min. %d sec. %d ms.\n";

    private static final String SEARCHING_TIME = "Searching time: %d min. %d sec. %d ms.\n\r\n";

    public void display(String template, Object... params) {

        System.out.printf(template, params);

    }

    public void displayStartSearching(String method) {

        display(START_SEARCHING, method);

    }

    public void displayFoundContacts(int foundContacts, int entries) {

        display(FOUND_ENTRIES, foundContacts, entries);

    }

    public void displayElapsedTime(int minutes, int seconds, int millis) {

        display(TIME_TAKEN, minutes, seconds, millis);

    }

    public void displaySortingTime(int minutes, int seconds, int millis) {

        display(SORTING_TIME, minutes, seconds, millis);

    }

    public void displayCreatingTime(int minutes, int seconds, int millis) {

        display(CREATING_TIME, minutes, seconds, millis);

    }

    public void displaySearchingTime(int minutes, int seconds, int millis) {

        display(SEARCHING_TIME, minutes, seconds, millis);

    }

}
