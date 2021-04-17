package com.panek;

import java.sql.Time;

public class Main {

    public static void main(String[] args) {

    CollectData collect = new CollectData();

    int choice = collect.collectData();
    int choiceTo = collect.collectDataTo();
    double temperature = collect.collectTemperature(choice);

    collect.makeMath(choice, choiceTo, temperature);
    }





}
