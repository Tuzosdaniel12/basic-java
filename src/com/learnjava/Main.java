package com.learnjava;

public class Main {

    public static void main(String[] args) {

        double principal = (double)Console.readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annual = (float)Console.readNumber("Annual: ", 1, 30);
        byte years = (byte)Console.readNumber("Years: ", 1, 30);


        var mortgageCalculaor = new MortgageCalculaor(annual, principal, years);

        var mortgageReport = new MortgageReport(mortgageCalculaor);
        mortgageReport.displayMortgageAndBalance();

        var checkbox = new Checkbox();
        var textBox = new TextBox();

        show( checkbox );
        show( textBox );

        var point1 = new Point(1,2);
        var point = new Point(1,2);

        UIControl [] controls = {new TextBox(), new Checkbox()};

        for(var control : controls)
            control.render();

        var calculator = new TaxCalculator2018( 75000 );
        var report = new TaxReport(calculator);

        report.show();

        report.setCalculator( new TaxCalculator2019(  75000 ) );

        report.show();

    }
    public static void show(UIControl control){
        if(control instanceof TextBox){
            var textBox = (TextBox)control;
            textBox.setText("Hello World");
        }
        System.out.println(control);
    }
}