package com.panek;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Bio {

    public static void bio(LocalDate birthday) {

        LocalDate currentDate = LocalDate.now();

        Period difference = Period.between(birthday, currentDate);
        int years = difference.getYears();
        int months = difference.getMonths();
        int days = difference.getDays();
        long daysLived = ChronoUnit.DAYS.between(birthday, currentDate);
        long hoursLived = daysLived*24;
        long minutesLived = hoursLived*60;
        long secondsLived = minutesLived*60;
        System.out.printf("You are %2d years, %d month and %d days old. \n" +
                "Which is:\n" +
                " - %d days,\n" +
                " - %d hours,\n" +
                " - %d minutes,\n" +
                " - %d seconds.\n", years, months, days, daysLived, hoursLived, minutesLived, secondsLived);


    }
}
