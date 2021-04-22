package com.panek;

public class userQuit {

    public static boolean confirmed(String choice, String goodbyeMessage) {

        /*
        Check if user wants to quit the program
         */

        if (choice.equals("q")) {
            System.out.println(goodbyeMessage);
           return true;
        }

        return false;
    }
}
