package com.learnjava;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private final MortgageCalculaor calculator;

    public MortgageReport(MortgageCalculaor calculator){
        this.calculator = calculator;
        this.currency = NumberFormat.getCurrencyInstance();
    }

    public void displayMortgageAndBalance(){
        displayMortgage();
        displayBalance();
    }

    private void displayMortgage(){

        double mortgage = calculator.calculateMortgage();

        System.out.println("MORTGAGE: ");
        System.out.println("******************************************");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }

    private void displayBalance() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("******************************************");
        for (double balance : calculator.getRemainingBalance())
            System.out.println(currency.format(balance));

    }
}
