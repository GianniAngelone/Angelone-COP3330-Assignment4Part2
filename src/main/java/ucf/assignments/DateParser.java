/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */
package ucf.assignments;
public class DateParser {
    public static boolean isDate(String date) {
        String[] splitDate = date.split("-");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);

        if (month >= 1 && month <= 12) {
            if (month == 2) { //February
                if (isLeapYear(year)) { //if leap year
                    return day <= 29;
                } else {
                    return day <= 28;
                }
            }
            //April = 4, June = 6, September = 9, or November = 11
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                return day <= 30;
            } else {
                return day <= 31;
            }
        } else {
            //Not correct information
            return false;
        }
    }
    private static boolean isLeapYear(int year) {
        //Checking if leap year
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            //it is a leap year
            return true;
        } else return year % 400 == 0;
    }
}
