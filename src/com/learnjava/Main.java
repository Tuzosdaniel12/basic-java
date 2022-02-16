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

        //Primitive types, byte 1, short 2, int 2, long 8, float 4, double 8, char 2, boolean True/False
        byte myAge = 30;
        long viewCount = 3_123_456_789L; //add sufix L to declare Long
        float price = 10.99F;//add sufix to declare as float
        char letter = 'A';//Single quotes for char
        boolean isEligible = false;

        //Reference  type
        Date now = new Date();
        System.out.println(now);

        //reference type point to the address of that object, so it can overwrite memory
        Point point = new Point(1,1);
        Point point2 = point;
        point.x = 2;
        System.out.println(point2);

        int [] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;

        System.out.println( Arrays.toString( numbers ) );

        //casting
        //Implicit casting
        //  byte > short > int . long > float > double
        short x = 1;
        int y = x + 2;


        System.out.println("******************* MORTGAGE CALCULATOR ***********************");

        double principal = (double)readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annual = (float)readNumber("Annual: ", 1, 30);
        byte years = (byte)readNumber("Years: ", 1, 30);

        displayMortgage(annual, principal, years);
        displayBalance( annual, principal, years);

        System.out.println("************************** FIZZBUZZ ***************************");
        final String FIZZ = "Fizz";
        final String BUZZ = "Buzz";//
        String fizzBuzz;

        //ask for the number
        Scanner scanner = new Scanner(System.in);
        System.out.print(("Number: "));
        int number = scanner.nextInt();


        if(number % 5 == 0 && number % 3 == 0)
            fizzBuzz = FIZZ+BUZZ;
        else if(number % 5 == 0)
            fizzBuzz = FIZZ;
        else if(number % 3 == 0)
            fizzBuzz = BUZZ;
        else
            fizzBuzz = Integer.toString(number);

        System.out.println("Results: " +  fizzBuzz );

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
