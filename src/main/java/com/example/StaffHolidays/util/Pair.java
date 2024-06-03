package com.example.StaffHolidays.util;

public class Pair<U,T> {
    private U value1;
    private T value2;

    public Pair(U beginHour, T endHour) {
        this.value1 = beginHour;
        this.value2 = endHour;
    }

    public Pair(){

    }

    public void setValue1(U value1) {
        this.value1 = value1;
    }


    public void setValue2(T value2) {
        this.value2 = value2;
    }

    public U getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }
}
