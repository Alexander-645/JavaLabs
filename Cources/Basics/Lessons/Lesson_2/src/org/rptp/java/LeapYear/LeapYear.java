package org.rptp.java.LeapYear;

public class LeapYear {
    public static int leapYearCount(int year) {
        year = year/4 - year/100 + year/400;
        return year;
    }
}
