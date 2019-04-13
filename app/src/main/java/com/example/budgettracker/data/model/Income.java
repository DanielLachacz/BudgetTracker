package com.example.budgettracker.data.model;

import com.example.budgettracker.adapter.DailyAdapter;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "income_table")
public class Income {

    @PrimaryKey(autoGenerate = true)
    private int incomeId;
    private String note;
    private Double value;
    private String type;
    private Long dateLong = System.currentTimeMillis();
    private String date = new SimpleDateFormat("MM/yyyy").format(new Date(dateLong));
    private static Calendar cal = Calendar.getInstance();
    private int month = cal.get(Calendar.MONTH) + 1;
    private int day = cal.get(Calendar.DAY_OF_MONTH);
    private int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    private String weekDay = new DateFormatSymbols().getWeekdays()[dayOfWeek];

    public Income(Double value, String note, String type) {
        this.value = value;
        this.note = note;
        this.type = type;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int id) {
        this.incomeId = id;
    }

    public Long getDateLong() {
        return dateLong;
    }

    public void setDateLong(Long dateLong) {
        this.dateLong = dateLong;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Calendar getCal() {
        return cal;
    }

    public static void setCal(Calendar cal) {
        Income.cal = cal;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

}
