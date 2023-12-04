package org.example;

import java.util.Objects;

public class Payment implements Cloneable {
    private String FIO;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return getPaymentSum() == payment.getPaymentSum() && day == payment.day && getMonth() == payment.getMonth() && getYear() == payment.getYear() && Objects.equals(getFIO(), payment.getFIO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFIO(), getPaymentSum(), day, getMonth(), getYear());
    }

    private int paymentSum;
    private int day, month, year;

    public Payment(String name, String lastName, String middleName,
                   int paymentSum, int paymentDay, int paymentMonth, int paymentYear){
        this.FIO = name + " " + lastName + " " + middleName;
        this.paymentSum = paymentSum;
        this.day = paymentDay;
        this.month = paymentMonth;
        this.year = paymentYear;
    }

    public Payment(String FIO, int paymentSum, int paymentDay, int paymentMonth, int paymentYear){
        this.FIO = FIO;
        this.paymentSum = paymentSum;
        this.day = paymentDay;
        this.month = paymentMonth;
        this.year = paymentYear;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setFIO(String name, String lastName, String middleName) {
        this.FIO = name + " " + lastName + " " + middleName;
    }

    public String getPaymentDate() {
        return String.format("%d.%d.%d", day, month, year);
    }

    public void setPaymentDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(int paymentSum) {
        this.paymentSum = paymentSum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    @Override
    public Payment clone() {
        return new Payment(this.FIO, this.paymentSum, this.day, this.month, this.year);
    }
}
