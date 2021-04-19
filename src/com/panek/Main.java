/*
    CLI 'Converter':
    - main goal: collect input and convert temperature value
    - additional functions:
        -  validate user input:
            - accept designated data types,
            - quit anytime user wants,
 */


package com.panek;


public class Main {

    public static void main(String[] args) {

        CollectData collect = new CollectData();

        int factorOne = collect.collectFormatToConvert();
        int factorTwo = collect.collectFormatToBeConverted();

        double validTemperature = collect.collectTemperature(factorOne);

        collect.convert(factorOne, factorTwo, validTemperature);

    }
}
