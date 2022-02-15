package com.learnjava;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("hello world");

        //integer declaration
        int age = 30;
        System.out.println(age);


        //Primitive types, byte 1, short 2, int 2, long 8, float 4, double 8, char 2, boolean True/False
        byte myAge = 30;
        long viewCount = 3_123_456_789L; //add sufix L to declare Long
        float price = 10.99F;//add sufix to declare as float
        char letter = 'A';//Single quotes for char
        boolean isEligible = false;

        //Reference  type
        Date now = new Date();

        System.out.println(now);

        //reference type point to the address of that object, so it can over write memory
        Point point = new Point(1,1);
        Point point2 = point;
        point.x = 2;
        System.out.println(point2);

        //String
        String message = "Hello World" + "!!";
        System.out.println(message);

        System.out.println( message.endsWith("!!") );
        System.out.println( message.indexOf("sky"));

        int [] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;

        System.out.println( Arrays.toString( numbers ) );

        //constant use final key word
        final float pi = 3.14F;

        //casting
        //Implicit casting
        //  byte > short > int . long > float > double
        short x = 1;
        int y = x + 2;

        int round = Math.round(1.1F);
        System.out.println(round);

        int ceil = (int)Math.ceil(1.1F);
        System.out.println(ceil);

        int floor = (int)Math.floor(1.1F);
        System.out.println(floor);

        int random = (int)(Math.random() * 100);
        System.out.println(random);

        //format currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        String result = currency.format(13546315.1212);
        System.out.println(result);

        String percent = NumberFormat.getCurrencyInstance().format(10.1);
        System.out.println(percent);

        System.out.println("******************************************");
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float annual;
        int principal;
        int years;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(("Enter a number between 1,000 and 1,000,000): "));
            System.out.print(("Principal ($1K - $1M): "));
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1000000)
                break;
        }


        while(true){
            System.out.println(("Enter a number greater then 0 or equal to 30: "));
            System.out.print(("Annual: "));
            annual = scanner.nextFloat();
            if(annual > 0 && annual <= 30)
                break;
        }

        while(true){
            System.out.println(("Enter a number between 1 and 30: "));
            System.out.print(("Years: "));
            years = scanner.nextInt();

            if(years > 0 && years <= 30)
                break;
        }



        float monthlyInterest = annual / PERCENT / MONTHS_IN_YEAR;
        int monthsInContract = years * 12;
        float powerOfRPlusOneToN = (float)Math.pow( (1 + monthlyInterest), monthsInContract ) ;

        String  mortgage =  currency.format( (double)principal * ( monthlyInterest * ( powerOfRPlusOneToN )  / ( ( powerOfRPlusOneToN ) - 1 ) )  );
        System.out.println("Mortgage: " +  mortgage );

        System.out.println("******************************************");

        final String FIZZ = "Fizz";
        final String BUZZ = "Buzz";//
        String fizzBuzz;
        //ask for the number
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
}
