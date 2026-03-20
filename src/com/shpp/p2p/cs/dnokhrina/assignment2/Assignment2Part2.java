package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.awt.Color;

/* Task: Copy the image
            (An optical illusion featuring a white rectangle on a white background, with black circles behind it
            at each of its corners)
 */
public class Assignment2Part2 extends DrawShapes {
    // The window's parameters
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;

    //  Two variables in case the window isn't square (i.e., the shapes will be ovals rather than circles)
    public static int circleDiameter;

    //  Main method
    public void run() {
        //  Get circles parameters based on the current window size
        circleDiameter = (Math.min(getWidth(), getHeight())) / 3;

        //  Calculate the distance to be moved before drawing the second circle
        int circleOffsetX = getWidth() - circleDiameter;
        int circleOffsetY = getHeight() - circleDiameter;

        //Draw circles
        drawCircle(0, 0); //[0,0]
        drawCircle(circleOffsetX, 0); //[0,1]
        drawCircle(0, circleOffsetY);//[1,0]
        drawCircle(circleOffsetX, circleOffsetY);//[1,1]

        drawRect(circleDiameter / 2, circleDiameter / 2); //Draw white rectangular
    }
    
    /*	Overridden methods of methods from DrawShapes.java

        I didn't want to have to write repetitive variables (such as circle width/height) every time
        the function to draw a circle is called. The same will be true for the next Assignment2PartX.java files
     */

    //Draw a circle
    public void drawCircle(int x, int y) {
        drawCircle(x, y, circleDiameter, circleDiameter, Color.black);
    }

    //Draw a rectangular
    public void drawRect(int x, int y) {
        //Rectangular is smaller by half-circle at each side. Two sides => 2 * half-circle = circle
        int width = getWidth() - circleDiameter;    // The program's width minus a half-cirle from the right and a half-cirle from the left
        int height = getHeight() - circleDiameter;    // The program's height minus a half-cirle from the top and a half-cirle from the left
        drawRect(x, y, width, height, Color.white);
    }
}
