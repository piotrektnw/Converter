package com.panek;

public class Date {
    int year;
    int month;
    int day;


    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Date add(Date d1, Date d2) {
        Date sum = new Date(2 ,3 ,5);
        sum.day = d1.day - d2.day;
        sum.month = d1.month - d2.month;
        sum.year = d1.year - d2.year;
        return sum;

    }


}
