/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */
package w1830958.CourseWork;

import java.util.Scanner;

public class Date {

    Scanner in = new Scanner(System.in);
    private int day;
    private int month;
    private int year;
//first constractor designed to initialisa date and allow user input for date
    Date() {

        this.day = 0;
        this.month = 0;
        this.year = 0;
//second constructor designed to retireve date data from csv file and pass it again in date using the constractor.
    } Date(int day,int month,int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }



    public void setDay() {
        boolean a = false;
        while (!a) {
            try {
                int days = Integer.parseInt(in.nextLine());
                if ((days > 0 && days < 32)) {
                    this.day = days;
                    a = true;
                }  else {
                    System.out.println("out of range. try again. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input. Try again.");
            }
        }
    }

    public void setMonth() {
        boolean a = false;

        while (!a) {
            try {
                int months = Integer.parseInt(in.nextLine());

                if (months > 0 && months < 13) {
                    this.month = months;
                    a = true;
                } else {
                    System.out.println("out of range for Month. try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input. Try again.");
            }
        }
    }

    public void setYear() {

        boolean a = false;

        while (!a) {
            try {
                int y = Integer.parseInt(in.nextLine());
                if (y >= 1905 && y<=2024) {
                    this.year = y;
                    a = true;
                } else {

                    System.out.println("out of range. try again. For date of birth no less then 1905 and for booking no further then 2024 can be set as date. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input. Try again.");
            }
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        if (day < 10) {
            return "0" + day + "/" + month + "/" + year;
        }

        return day + "/" + month + "/" + year;
    }

}
