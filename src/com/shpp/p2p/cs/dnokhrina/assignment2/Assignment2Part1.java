package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.util.Scanner;

/*
    Task: Write a console program that takes three double numbers (a, b, c) as input
            and outputs the roots of the quadratic equation.

            a*(x^2) + b*x + c = 0
 */
public class Assignment2Part1 {
    static Scanner myScan = new Scanner(System.in);

    static double a;
    static double b;
    static double c;

    public static void main(String[] args) {
        final double a = scanX("a");
        final double b = scanX("b");
        final double c = scanX("c");
        final double discriminant = getDiscriminant(a, b,c);            // 	Calculate D with received values
        myScan.close();

        //Print the equation
        //System.out.println("\n\n\n\n\n\n");
        System.out.println(a + " * (x^2) + " + b + " * x + " + c + " = 0\n");


        if (a == 0) {       //x1 and x2 can't be found if a == 0 (Math's rule)
            System.out.println("ERROR! Variable A can not be equal to 0");
        } else if (discriminant < 0) {   //if D < 0, no roots exist (Math's rule)
            System.out.println("There are no roots.");
        } else if (discriminant == 0) {    //if D == 0, only one root exists (Math's rule)
            System.out.println("There is one root: ");
    		/*	In mathematics, a different formula is used if there is only one root, 
    			but in fact, there is simply removed the addition/subtraction of zero, 
    			so we can reuse the old formula.	*/
            System.out.print("x = " + getSquareRoot(false, a, b, discriminant));

        } else if (discriminant > 0) {
            System.out.println("There are two roots: ");
            System.out.println("x1 = " + getSquareRoot(false, a, b, discriminant));
            System.out.println("x2 = " + getSquareRoot(true, a, b, discriminant));
        }
    }

    //	Reusable method for scanning values
    public static double scanX(String x) {
        System.out.print("Enter " + x + ": ");
        return myScan.nextDouble();
    }

    //Calculate D (Math's formula)
    public static double getDiscriminant(double a, double b, double c) {
        return (b * b - 4 * a * c);
    }

    /*
        Calculate x (x1 or x2 depends on minus)

        The formulas differ only in whether D is added or subtracted.
        Depending on the resulting boolean value, the method either performs addition (D is multiplied by 1) or subtraction (D is multiplied by -1)
    */
    public static double getSquareRoot(boolean minus, double a, double b, double discriminant) {
        double signChange = 1;
        if (minus) signChange = -1; //+D square or minus

        return (-b + signChange * Math.sqrt(discriminant)) / (2 * a);
    }
}