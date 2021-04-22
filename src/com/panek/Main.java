/*
    CLI 'Converter':
    - main goal: collect input and convert temperature value
    - additional functions:
        -  validate user input:
            - accept designated data types,
            - quit anytime user wants,
 */


package com.panek;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Prepare needed messages
         */

        CollectData collect = new CollectData();
        String startMessage = collect.startMessage;
        String warningMessage = collect.warningMessage;
        String goodbyeMessage = collect.goodbyeMessage;
        String chooseDate = collect.chooseDate;
        String chooseTemperature = collect.chooseTemperature;
        String formatError = collect.formatError;

        System.out.print("Hello. ");
        Scanner scanner = new Scanner(System.in);

        while (true) {

            /*
            Print start menu:
            - Option 1) for Date module,
            - Option 2) for Temperature module,
            - Option q) for quit.
             */

            System.out.println(startMessage);
            String input = scanner.next();
            if (userQuit.confirmed(input, goodbyeMessage)) {
                System.exit(0);
            }

            try {
                int convertedInput = Integer.parseInt(input);
                if (convertedInput == 1) {
                    System.out.println(chooseDate);

                    /*
                    Date module initialization, user is able to choose module
                    after each use
                     */

                    collect.collectDate();
                }

                else if (convertedInput == 2) {
                    System.out.println(chooseTemperature);

                    int factorOne = collect.collectFormatToConvert();
                    int factorTwo = collect.collectFormatToBeConverted();

                    while (factorOne == factorTwo) {

                        /*
                        Avoid choosing the same formats
                         */

                        System.out.println(formatError);
                        factorOne = collect.collectFormatToConvert();
                        factorTwo = collect.collectFormatToBeConverted();
                    }

                double validTemperature = collect.collectTemperature(factorOne);

                    /*
                    Proceed temperature conversion
                     */

                collect.convert(factorOne, factorTwo, validTemperature);
                }

            } catch (Exception e) {
                System.out.println(warningMessage);
            }
        }
    }
}
