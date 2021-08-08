package by.valvik.phonebook.view;

public class Console {

    private static final String START_SEARCHING = "Start searching (%s)...\n";

    public void display(String template, Object... params) {

        System.out.printf(template, params);

    }

    public void displayStartSearching(String method) {

        display(START_SEARCHING, method);

    }

}
