package com.panek;

public class InputValidator {

    public static boolean inputIsValid(int choice) {
        /*
        Validate user input according to specified range
         */
        if (choice >= 1 && choice <= 3)
            return true;

        System.out.println("Please enter number: 1, 2 or 3.");
        return false;
    }
}
