package com.learnjava;

import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        System.out.println("******************* MORTGAGE CALCULATOR ***********************");

        double principal = (double)readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annual = (float)readNumber("Annual: ", 1, 30);
        byte years = (byte)readNumber("Years: ", 1, 30);

        displayMortgage(annual, principal, years);
        displayBalance( annual, principal, years);



    }

    public static double calculateMortgage( float annual, double principal, int years){

        float monthlyInterest = annual / PERCENT / MONTHS_IN_YEAR;
        int monthsInContract = years * MONTHS_IN_YEAR;
        float powerOfRPlusOneToN = (float)Math.pow( (1 + monthlyInterest), monthsInContract ) ;

        return  (double)principal * ( monthlyInterest * ( powerOfRPlusOneToN )  / ( ( powerOfRPlusOneToN ) - 1 ) ) ;
    }
    public static  double calculateBalance(float annual, double principal, int years, short numberOfPaymentsMade){
        float monthlyInterest = annual / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        return principal * ( Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade) )
                         / ( Math.pow(1 + monthlyInterest, numberOfPayments) - 1) ;
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print((prompt));
            value = scanner.nextDouble();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return value;
    }

    public static void displayMortgage(float annual, double principal, byte years){

        double mortgage = calculateMortgage( annual, principal, years);

        System.out.println("MORTGAGE: ");
        System.out.println("******************************************");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    private static void displayBalance( float annual, double principal, byte years ) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("******************************************");
        for ( short month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance( annual, principal, years, month );
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
