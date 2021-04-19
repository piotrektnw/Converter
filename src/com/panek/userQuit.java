package com.panek;

public class userQuit {

    public static boolean confirmed(String choice) {

        /*
        Check if user wants to quit the program
         */

        if (choice.equals("q")) {
           return true;
        }

        return false;
    }
}
