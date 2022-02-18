package com.learnjava;

public class Main {

    public static void main(String[] args) {

        double principal = (double)Console.readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annual = (float)Console.readNumber("Annual: ", 1, 30);
        byte years = (byte)Console.readNumber("Years: ", 1, 30);


        var mortgageCalculaor = new MortgageCalculaor(annual, principal, years);

        var mortgageReport = new MortgageReport(mortgageCalculaor);
        mortgageReport.displayMortgageAndBalance();
    }
}