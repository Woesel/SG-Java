package com.tenzin.dvd.ui;

/**
 *
 * @author Tenzin Woesel May 17, 2020
 * 
 */
public interface UserIO {

    /**
     *
     * A very simple method that takes in a message to display on the console
     * and then waits for a integer answer from the user to return.
     *
     * @param msg - String of information to display to the user.
     *
     */
    void print(String msg);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    String readString(String prompt);

    public String pressEnterToContinue(String msgPrompt);
}
