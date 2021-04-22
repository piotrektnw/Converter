package com.panek;

import java.awt.image.MultiPixelPackedSampleModel;
import java.time.LocalDate;
import java.util.*;

public class InputValidator {

    public static boolean validTemperature(int choice, String usage) {

        /*
        Validate user input according to specified range
         */

        if (choice >= 1 && choice <= 3)
            return true;

        System.out.println(usage);
        return false;

    }

    public static int validYear(String goodbyeMessage, String usageYear) {

        /*
        Validate user 'year' input. Conditions:
        - accept user quit decision,
        - reject strings,
         */

        Scanner scanner = new Scanner(System.in);
        int year;

        while (true) {
            System.out.println("Enter a year (q for quit): ");
            String initialInput = scanner.next();
            if (userQuit.confirmed(initialInput, goodbyeMessage)) {
                System.exit(0);
            }

            else {
                try {
                    return year = Integer.parseInt(initialInput);
                } catch (Exception e) {
                    System.out.println(usageYear);
                }
            }
        }
    }

    public static boolean leapYear(int year) {

        /*
        Leap year verification
         */

        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public static int validMonth(String goodbyeMessage, String usageMonth) {

        /*
        Validate user 'month' input. Conditions:
        - accept user quit decision,
        - reject strings - TO BE CHANGED (ACCEPT STRINGS AND RECOGNIZE TYPOS)
        - reject values greater than quantity of months in a year,
         */

        String[] monthsNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String recognizedMonth;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month: ");
        int months;

        while (true) {

            System.out.print("Enter a month (q for quit): ");
            String month = scanner.next();
            if (userQuit.confirmed(month, goodbyeMessage)) {
                System.exit(0);
            }

            else {
                try {
                    months = Integer.parseInt(month);
                    if (months > 12) {
                        System.out.println("A year has 12 months. Please enter proper month number.");
                    } else {
                        return months;
                    }
                } catch (Exception e) {

                    /*
                    Use month recognition on given input
                    return month if user agree with recognized month
                    else print information and collect month again
                     */

                    recognizedMonth = monthRecognition(month);
                    System.out.println("Did you mean " + recognizedMonth + " (y/n)?");
                    String confirmation = scanner.next();
                    if (confirmation.equals("y")) {
                        months = Arrays.asList(monthsNames).indexOf(recognizedMonth);
                        return months+1;
                    }
                    System.out.println(usageMonth);
                }
            }
        }
    }

    public static int validDay(String goodbyeMessage, String usageDay, int month, int year, boolean leapYear) {

        /*
        Validate user 'day' input. Conditions:
        - accept user quit decision,
        - reject strings,
        - reject values greater than month length (include leap years)
         */

        Scanner scanner = new Scanner(System.in);
        int day;
        int[] yearLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        /*
        Adjust February length if year is a leap year
         */

        if (leapYear) {
            yearLength[1] = 29;
        }

        while (true) {
            System.out.println("Enter a day (q for quit): ");
            String initialInput = scanner.next();

            if (userQuit.confirmed(initialInput ,goodbyeMessage)) {
                System.exit(0);
            }
            try {
                day = Integer.parseInt(initialInput);
                if (day > yearLength[month-1])
                {
                    System.out.printf("In %d.%d there were %d days. Please enter proper day number:" +
                            " ", month, year, yearLength[month - 1]);
                }
                return day;
            }
            catch (Exception e) {
                System.out.println(usageDay);
            }
        }
    }

    public static String monthRecognition (String month) {

        /*
        Month recognition method:
        - takes string as input
        - compares it with predefined list of months
        - returns index of month with most similarities with given input
         */

        int max = 0;
        int similarities = 0;
        int index = 0;
        String recognizedMonth;
        List<Integer> similaritiesValues = new ArrayList<>();
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int i = 0; i < months.length; i++) {
            char[] monthToChar = month.toLowerCase().toCharArray();
            char[] monthsArrayToChar = months[i].toLowerCase().toCharArray();

            for (int c = 0; c < months[i].length(); c++) {

                for (int b = 0; b < month.length(); b++) {

                    if (monthsArrayToChar[c] == monthToChar[b]) {
                        similarities++;

                        /*
                        Remove matched character to avoid result distortion
                         */

                        monthsArrayToChar[c] = ' ';
                        monthToChar[b] = ' ';
                        break;
                    }
                }
            }

            /*
            Add similarities values to similaritiesValues list and reset
            similarities count before next month comparison
             */

            similaritiesValues.add(similarities);
            similarities = 0;

        }

        /*
        Find index of month with biggest number of similarities
         */

        for (int i = 0; i < similaritiesValues.size(); i++)
        {
            if (max < similaritiesValues.get(i)) {
                max = similaritiesValues.get(i);
                index = i;
            }

        }
        recognizedMonth = months[index];
        return recognizedMonth;
    }
}