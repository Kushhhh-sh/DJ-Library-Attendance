package com.raven.datechooser;

public class SelectedDate {

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SelectedDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SelectedDate() {
    }

    @Override
    public String toString() {
        String strMonth = String.valueOf(month);
        if(month < 10)
            strMonth = "0" + month;
        return day + "/" + strMonth + "/" + year;
    }
    
    

    private int day;
    private int month;
    private int year;
}
