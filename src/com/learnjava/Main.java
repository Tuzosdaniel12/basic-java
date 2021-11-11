package com.learnjava;

import java.util.Date;

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

        //Date type
        Date now = new Date();

        System.out.println(now);


    }
}
