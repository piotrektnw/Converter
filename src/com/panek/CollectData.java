package com.panek;

import java.time.LocalDate;
import java.util.Scanner;

public class CollectData {

    Messages messages = new Messages();
    String goodbyeMessage = messages.goodbyeMessage;
    String usage = messages.usage;
    String usageYear = messages.usageYear;
    String usageMonth = messages.usageMonth;
    String usageDay = messages.usageDay;
    String chooseDate = messages.chooseDate;
    String startMessage = messages.startMessage;
    String warningMessage = messages.warningMessage;
    String chooseTemperature = messages.chooseTemperature;
    String absoluteCelsius = messages.absoluteCelsius;
    String absoluteFahrenheit = messages.absoluteFahrenheit;
    String absoluteKelvin = messages.absoluteKelvin;
    String formatError = messages.formatError;

    public LocalDate collectDate() {

        /*
        Collect validated date data and return it as a LocalDate
         */

        int year = InputValidator.validYear(goodbyeMessage, usageYear);
        int month = InputValidator.validMonth(goodbyeMessage, usageMonth);
        int day = InputValidator.validDay(goodbyeMessage, usageDay, month, year, InputValidator.leapYear(year));

        return LocalDate.of(year, month, day);

        }

    public int collectFormatToConvert() {

        /*
        Method collects and validates user input
         */

        String factorOne;
        int validFactorOne;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose value to be converted: ");
            System.out.println("1) Celsius");
            System.out.println("2) Fahrenheit");
            System.out.println("3) Kelvin");

            /*
            Extended input validation:
            - accept integer in range 1 - 3 (refer to: InputValidator.java)
            - accept 'q' as quit (refer to: userQuit.java)
             */

            factorOne = scanner.next();

            if (userQuit.confirmed(factorOne, goodbyeMessage)) {
                System.exit(0);
            }

            else {

                try {
                    validFactorOne = Integer.parseInt(factorOne);
                    if (InputValidator.validTemperature(validFactorOne, usage)) {
                        return validFactorOne;
                    }
                }
                catch (Exception e) {
                    System.out.println(usage);
                }
            }
        }
    }

    public int collectFormatToBeConverted() {

        /*
        Method collects and validates user input
         */
        String factorTwo;
        int validFactorTwo;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose value to be converted to: ");
            System.out.println("1) Celsius");
            System.out.println("2) Fahrenheit");
            System.out.println("3) Kelvin");

            /*
            Extended input validation:
            - accept integer in range 1 - 3 (refer to: InputValidator.java)
            - accept 'q' as quit (refer to: userQuit.java)
             */

            factorTwo = scanner.next();

            if (userQuit.confirmed(factorTwo, goodbyeMessage)) {
                System.exit(0);
            }

            else {

                try {
                    validFactorTwo = Integer.parseInt(factorTwo);
                    if (InputValidator.validTemperature(validFactorTwo, usage)) {
                        return validFactorTwo;
                    }
                }
                catch (Exception e) {
                    System.out.println(usage);
                }
            }
        }
    }

    public double collectTemperature(int validFactorTwo) {

        /*
        Method collects and validates user input
         */

        String temperature;
        double validTemperature;

        while (true) {

            if (validFactorTwo == 1) {
                System.out.println("Enter Celsius temperature: ");
            } else if (validFactorTwo == 2) {
                System.out.println("Enter Fahrenheit temperature:");
            } else {
                System.out.println("Enter Kelvin temperature: ");
            }


            Scanner scanner = new Scanner(System.in);

            /*
            Extended input validation:
            - accept double value only,
            - accept 'q' as quit (refer to: userQuit.java),
            - reject values lower than absolute zero.
             */

            temperature = scanner.next();

            if (userQuit.confirmed(temperature, goodbyeMessage)) {
                System.exit(0);
            }
            else {

                try {
                    validTemperature = Double.parseDouble(temperature);
                    if (validFactorTwo == 1 && validTemperature < -273.15) {
                        System.out.println(absoluteCelsius);
                    }
                    else if (validFactorTwo == 2 && validTemperature < -459.67) {
                        System.out.println(absoluteFahrenheit);
                    }
                    else if (validFactorTwo ==3 && validTemperature < 0) {
                        System.out.println(absoluteKelvin);
                    }
                    else {
                        return validTemperature;
                    }
                }

                catch (Exception e) {
                    System.out.println(usage);
                }
            }
        }
    }

    public void convert(int validFactorOne, int validFactorTwo, double validTemperature) {

        /*
        Count temperature
         */
        if (validFactorOne == 1 && validFactorTwo == 2) {
            System.out.printf("Celsius to Fahrenheit is %.2f \n", ((validTemperature * 9 / 5) + 32));
        } else if (validFactorOne == 2 && validFactorTwo == 1) {
            System.out.printf("Fahrenheit to Celsius is %.2f \n", ((validTemperature - 32) * 5 / 9));
        } else if (validFactorOne == 1 && validFactorTwo == 3) {
            System.out.printf("Celsius to Kelvin is %.2f \n", (validTemperature + 273.15));
        } else if (validFactorOne == 3 && validFactorTwo == 1) {
            System.out.printf("Kelvin to Celsius is %.2f \n", (validTemperature - 273.15));
        } else if (validFactorOne == 3 && validFactorTwo == 2) {
            System.out.printf("Kelvin to Fahrenheit is: %.2f \n", ((validTemperature - 273.15) * 9/5 + 32));
        } else if (validFactorOne == 2 && validFactorTwo == 3) {
            System.out.printf("Fahrenheit to Kelvin is: %.2f \n", ((validTemperature - 32) * 5/9 + 273.15));
        }

    }
}
