package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.awt.Color;

/*  Task:   Draw a caterpillar.
            I made it more fun with random colors and a face.   */
public class Assignment2Part6 extends DrawShapes {
    public static final int APPLICATION_WIDTH = 850;
    public static final int APPLICATION_HEIGHT = 400;

    /*              TEST ZONE
        =================================== */
    static final int amountOfCircles = 20;

    //sine is used for calculating the height of the current circle.
    static double sin = 0;
    /*	The step of the sine, which is responsible for changing the height of the circle.
		        The larger first number (2) => more "wavy" the line is 	*/
    static final double sinStep = (double) 2 / 10;

    /*	Circle diameter.
		        The higher number => the larger will be circles.
		        If you want to use > 90 => please increase window's height    */
    static final double circleDiameter = 60;

    /*	The horizontal offset of each succeeding circle.
		        The higher number => fewer circles.*/
    static final double xOffset = circleDiameter / 2;

    //How much to offset to the left before drawing the first circle
    static final double xStartingOffsetLeft = circleDiameter / 2;

    /*  ===================================
            END OF THE TEST ZONE            */
    public void run() {
        drawCircles_Specific(amountOfCircles);//  Draw circles (the specified amount)
    }

    //	Draw specific amount of circles
    public void drawCircles_Specific(int amountOfCircles) {
        int currentOffsetX = (int) xStartingOffsetLeft;
        for (int i = 0; i < amountOfCircles; i++, currentOffsetX += xOffset, sin += sinStep) {
            drawCircle(currentOffsetX, circleDiameter + xOffset * Math.sin(i));
        }
    }

    public void drawCircle(double x, double y) {
        drawCircleThick(x, y, circleDiameter, circleDiameter, Color.lightGray, Color.darkGray, 1);
    }
}
