package phonebook.view;

public class Console {

    private static final String START_SEARCHING = "Start searching (%s)...";

    private static final String FOUND_ENTRIES = "Found %d / %d entries. ";

    private static final String TIME_TAKEN = "Time taken: %d min. %d sec. %d ms.";

    private static final String SORTING_TIME = "Sorting time: %d min. %d sec. %d ms.";

    private static final String SEARCHING_TIME = "Searching time: %d min. %d sec. %d ms.";

    private static final String CREATING_TIME = "Creating time: %d min. %d sec. %d ms.";

    public void displayMessage(String template, Object... params) {

        System.out.printf(template, params);



    }

    public void displayStartSearching(String method) {

        displayMessage(START_SEARCHING, method);

    }

    public void displayFoundEntries(int foundEntries, int entries) {

        newLine();

        displayMessage(FOUND_ENTRIES, foundEntries, entries);

    }

    public void displayElapsedTime(int minutes, int seconds, int millis) {

        displayMessage(TIME_TAKEN, minutes, seconds, millis);

    }

    public void displaySortingTime(int minutes, int seconds, int millis) {

        newLine();

        displayMessage(SORTING_TIME, minutes, seconds, millis);

    }

    public void displayCreatingTime(int minutes, int seconds, int millis) {

        newLine();

        displayMessage(CREATING_TIME, minutes, seconds, millis);

    }

    public void displaySearchingTime(int minutes, int seconds, int millis) {

        newLine();

        displayMessage(SEARCHING_TIME, minutes, seconds, millis);



    }

    public void displayEmptyLine() {

        newLine();

        System.out.println();

    }

    private void newLine() {

        displayMessage("\n");

    }

}
