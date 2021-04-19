package com.panek;

public class InputValidator {

    public static boolean inputIsValid(int choice, String usage) {

        /*
        Validate user input according to specified range
         */

        if (choice >= 1 && choice <= 3)
            return true;

        System.out.println(usage);
        return false;
    }
}
