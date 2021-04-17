package com.panek;

import java.util.Scanner;

public class CollectData {

    public int collectData() {

        /*
        Method collects and validates user input
         */
        int choice;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose value to be converted: ");
            System.out.println("1) Celsius");
            System.out.println("2) Fahrenheit");
            System.out.println("3) Kelvin");

            /*
            Validate input
             */

            try {
                choice = scanner.nextInt();
                if(InputValidator.inputIsValid(choice))
                    return choice;
            }
            catch (Exception e) {
                System.out.println("Please enter number: 1, 2 or 3.");
            }

        }
    }

    public int collectDataTo() {

        /*
        Method collects and validates user input
         */
        int choiceTo;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose value to be converted to: ");
            System.out.println("1) Celsius");
            System.out.println("2) Fahrenheit");
            System.out.println("3) Kelvin");

            /*
            Validate input
            */

            try {
                choiceTo = scanner.nextInt();
                if(InputValidator.inputIsValid(choiceTo))
                    return choiceTo;
            }
            catch (Exception e) {
                System.out.println("Please enter number: 1, 2 or 3.");
            }

        }
    }

    public double collectTemperature(int choice) {

        /*
        Method collects and validates user input
         */

        double temperature;

        if (choice == 1) {
            System.out.println("Enter Celsius temperature: ");
        } else if (choice == 2) {
            System.out.println("Enter Fahrenheit temperature:");
        } else {
            System.out.println("Enter Kelvin temperature: ");

        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            /*
            Check input validity
             */
            if (!scanner.hasNextDouble()) {
                System.err.println("Your input must be an integer.");
            } else {
                temperature = scanner.nextDouble();
                break;
            }
        }
        return temperature;
    }

    public void makeMath(int choice, int choiceTo, double temperature) {

        /*
        Count temperature
         */
        if (choice == 1 && choiceTo == 2) {
            System.out.printf("Celsius to Fahrenheit is %.2f", ((temperature * 9 / 5) + 32));
        } else if (choice == 2 && choiceTo == 1) {
            System.out.printf("Fahrenheit to Celsius is %.2f", ((temperature - 32) * 5 / 9));
        } else if (choice == 1 && choiceTo == 3) {
            System.out.printf("Celsius to Kelvin is %.2f", (temperature + 273.15));
        } else if (choice == 3 && choiceTo == 1) {
            System.out.printf("Kelvin to Celsius is %.2f", (temperature - 273.15));
        } else if (choice == 3 && choiceTo == 2) {
            System.out.printf("Kelvin to Fahrenheit is: %.2f", ((temperature - 273.15) * 9/5 + 32));
        } else if (choice == 2 && choiceTo == 3) {
            System.out.printf("Fahrenheit to Kelvin is: %.2f", ((temperature - 32) * 5/9 + 273.15));
        }

    }
}
