package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.awt.*;

/*  Task:   Draw a caterpillar.
            I made it more fun with random colors and a face.   */
public class Assignment2Part6ext extends DrawShapes {
    //Technical declarations
    public static final int APPLICATION_WIDTH = 850;
    public static final int APPLICATION_HEIGHT = 400;

    //Custom class for shifting colors. More information at ColorShiftCalculate.java
    public ColorShiftCalculate colorShiftCalculate1;
    public ColorShiftCalculate colorShiftCalculate2;

    //Color of border if only one color is used
    public Color previousColor;

    public enum ColorMode {
        ONE_COLOR,
        ONE_COLOR_COLORED_DARKER_BORDER,
        TWO_COLORS;
    }

    /*  ===================================
            TEST ZONE
    */
    static final boolean dynamicAmountOfCircles = true;
    static final int amountOfCircles = 30; //Will be used only if dynamicAmountOfCircles == false

    static final boolean randomColors = true;
    static final ColorMode currentColorMode = ColorMode.TWO_COLORS;
    static final boolean drawSillyFace = true;

    /*	Circle diameter.
		        The higher number => the larger will be circles.
		        If you want to use > 90 => please increase window's height    */
    public static double circleDiameter = 60;

    /*	The horizontal offset of each succeeding circle.
		        The higher number => fewer circles.*/
    static final double xOffset = circleDiameter / 6;

    //How much to offset to the left before drawing the first circle
    static final double xStartingOffsetLeft = circleDiameter / 2;

    //sine is used for calculating the height of the current circle.
    static double sin = 0;
    static final double sinStep = (double) 2 / 10;

    /*  ===================================
        END OF THE TEST ZONE
    */
    //Assigns random colors for the color of the circle's center and the color of the circle's outline
    public void setupStandard() {
        colorShiftCalculate1 = new ColorShiftCalculate(111, 20, 242, false, true, false);
        colorShiftCalculate2 = new ColorShiftCalculate(100, 0, 220, true, false, true);
    }

    //Assigns specific colors for the color of the circle's center and the color of the circle's outline
    public void setupRandom() {
        colorShiftCalculate1 = new ColorShiftCalculateRandom(); // fill
        colorShiftCalculate2 = new ColorShiftCalculateRandom(); // outline
    }

    public void run() {
        if (randomColors) setupRandom();        //Assigns random values
        else setupStandard();    //Assigns specified values (honestly, I just rolled random number for them too)

        //previousColor requires some value, which won't be the same as main Color, so just do first shift;
        previousColor = colorShiftCalculate1.getColorShift();

        if (dynamicAmountOfCircles)
            drawCircles_Dynamic();  //  Draw circles (the amount of circle is calculated dynamically)
        else drawCircles_Specific(amountOfCircles);//  Draw circles (the specified amount)
    }

    //	Draw as many circles as there can be
    public void drawCircles_Dynamic() {
        double currentOffsetX = xStartingOffsetLeft; //The first circle is located at a distance equal to half the diameter from the edge of the screen
        while (currentOffsetX < getWidth() - circleDiameter - xStartingOffsetLeft) { //As long as the caterpillar doesn't escape the screen (the circle will be drawn within the visible area)
            currentOffsetX += xOffset;
            sin += sinStep;
            /* Draw circle
			    x = offset from the last circle (or the edge of the screen if it is the first one)
			    y = offset to center the picture (didn't calculate the exact center, but cDiameter*2 looks good enough)
			        + diameter multiply by sin value to determine how high or low to draw the circle.

			        Math is brutal, but helpful.
			        Sine.txt file is located next to the me.txt file and contains additional information about how it works from a mathematical perspective.
			 */
            dCircle(currentOffsetX, (circleDiameter * 2 + circleDiameter * Math.sin(sin))); //Draw a circle
        }
        if (drawSillyFace) drawFace(currentOffsetX, circleDiameter * 2 + circleDiameter * Math.sin(sin));
    }

    //	Draw specific amount of circles
    public void drawCircles_Specific(int amountOfCircles) {
        double currentOffsetX = (double) xStartingOffsetLeft;
        for (int i = 0; i < amountOfCircles; i++, currentOffsetX += xOffset) {
            dCircle(currentOffsetX, 2 * circleDiameter + circleDiameter * Math.sin(i));
        }

        if (drawSillyFace) {
            //Reset to the last circle before drawing face
            currentOffsetX -= xOffset;
            drawFace(currentOffsetX, 2 * circleDiameter + circleDiameter * Math.sin(amountOfCircles - 1));
        }
    }

    // This is not part of the task and was done as a joke, so I will not write too much comments on the code, sorry :'
    public void drawFace(double x, double y) {
        //Circle sizes / distances
        double eyeSize = circleDiameter / 4;
        double eyePupilSize = eyeSize / 3 * 2;
        double betweenEyes = eyeSize / 2;

        //Draw the left eye
        drawEyes(x + betweenEyes, y, eyeSize, eyePupilSize);
        //Draw the right eye
        drawEyes(x + eyeSize + betweenEyes * 2, y, eyeSize, eyePupilSize);
    }

    //Draw eyes at the specified coordinates, using the given sizes for the sclera (the white part) and the pupil (the black part)
    public void drawEyes(double x, double y, double eyeSize, double eyePupilSize) {
        double offsetXofTheFace = circleDiameter / 2 - eyeSize * 1.5;
        double offsetYofTheFace = circleDiameter / 2 - eyeSize * 1;
        drawEye(x + offsetXofTheFace, y + offsetYofTheFace, eyeSize, eyePupilSize);
    }

    //Draw an eye: a white circle and a black circle
    public void drawEye(double x, double y, double eyeSize, double eyePupilSize) {
        drawCircle(x, y, eyeSize, eyeSize, Color.white);
        drawCircle(x + (eyeSize - eyePupilSize), y + (eyeSize - eyePupilSize) / 2, eyePupilSize, eyePupilSize, Color.black);
    }

    public void dCircle(double x, double y) {
        //Black border, light grey fill
        if (currentColorMode.equals(ColorMode.ONE_COLOR)) {
            drawCircleThick(x, y, circleDiameter, circleDiameter, Color.lightGray, Color.darkGray, 1);
        }
        /*  Uses one color for filling and for border uses darker version of it.
        Uses previous color (not current) just for better look. If use the same value, it will look flat.    */
        else if (currentColorMode.equals(ColorMode.ONE_COLOR_COLORED_DARKER_BORDER)) {
            Color color = colorShiftCalculate1.getColorShift();
            drawCircleThick(x, y, circleDiameter, circleDiameter, color, previousColor.darker(), 1);
            previousColor = color;
        } else if (currentColorMode.equals(ColorMode.TWO_COLORS)) {
            Color color1 = colorShiftCalculate1.getColorShift();
            Color color2 = colorShiftCalculate2.getColorShift();
            drawCircleThick(x, y, circleDiameter, circleDiameter, color1, color2, 1);
        }
    }
}
