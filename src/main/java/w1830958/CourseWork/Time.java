/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package w1830958.CourseWork;

import java.util.Scanner;

/**
 *
 * @author Mym19
 */
public class Time {

    Scanner in = new Scanner(System.in);
    private int Minute;
    private int Hour;

    Time() {
        Minute = 0;
        Hour = 0;

    }
 Time(int hour,int minute) {
        Minute = hour;
        Hour = minute;

    }
    public void setHour(int hour) {

                    Hour = hour;

    }

    public void setMinute(int minute) {
      Minute=minute;

    }

    public int getHour() {
        return Hour;
    }

    public int getMinute() {
        return Minute;
    }

    @Override
    public String toString() {
        if (getMinute() < 10) {
            return "Time Booked:" + getHour() + ":0" + getMinute();
        }
        return "Time Booked:" + getHour() + ":" + getMinute();
    }
    
}
