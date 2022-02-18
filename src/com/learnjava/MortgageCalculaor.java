package com.learnjava;

import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MortgageCalculaor {
    private byte MONTHS_IN_YEAR = 12;
    private byte PERCENT = 100;

    private double principal;
    private float annual;
    private byte years;
    private float monthlyInterest;
    private int monthsInContract;

    MortgageCalculaor(float annual, double principal, byte years){
        setPrincipal(principal);
        setAnnual(annual);
        setYears(years);
        setMonthsInterest();
        setMonthsInContract();
    }
    //---------------------calculateMortgage-------------------------//
    public double calculateMortgage(){
        float powerOfRPlusOneToN = (float)Math.pow( (1 + getMonthlyInterest()), getMonthsInContract() ) ;
        return  (double)this.principal * ( monthlyInterest * ( powerOfRPlusOneToN )  / ( ( powerOfRPlusOneToN ) - 1 ) ) ;
    }

    public double calculateBalance(short numberOfPaymentsMade){
        return this.principal * ( Math.pow(1 + getMonthlyInterest(), getMonthsInContract()) - Math.pow(1 + getMonthlyInterest(), numberOfPaymentsMade) )
                              / ( Math.pow(1 + getMonthlyInterest(), getMonthsInContract()) - 1) ;
    }

    public double[] getRemainingBalance(){
        var balance = new double[getMonthsInContract()];

        for ( short month = 1; month <= balance.length; month++)
            balance[month - 1] = calculateBalance(month);


        return balance;
    }

    //--------------monthlyInterest---------------------//
    private void setMonthsInterest(){
        this.monthlyInterest = getAnnual() / PERCENT / MONTHS_IN_YEAR;
    }
    private float getMonthlyInterest(){
        return this.monthlyInterest;
    }

    //--------------MonthsInContract---------------------//
    private void setMonthsInContract(){
        this.monthsInContract = getYears() * MONTHS_IN_YEAR;
    }
    private int getMonthsInContract(){
        return this.monthsInContract;
    }

    //---------------------Years-------------------------//
    private void setYears(byte years) {
        this.years =  years;
    }
    public byte getYears(){
        return this.years;
    }
    //---------------------Annual-------------------------//
    private void setAnnual(float annual) {
        this.annual = annual;
    }

    private float getAnnual(){
        return this.annual;
    }

    //---------------------Principal-------------------------//
    private void setPrincipal(double principal){
        this.principal = principal;
    }

    private double getPrincipal() {
        return this.principal;
    }


}
