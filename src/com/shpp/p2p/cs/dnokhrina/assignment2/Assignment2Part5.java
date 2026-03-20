package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.awt.Color;

//  Task: Draw an optical illusion (squares)
public class Assignment2Part5 extends DrawShapes {
    // The number of rows and columns in the grid
    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 10;

    // The width and height of each box.
    private static final double BOX_SIZE = 40;

    // The horizontal and vertical spacing between the boxes.
    private static final double BOX_SPACING = 10;

    // The window's parameters
    public static final int APPLICATION_WIDTH = 550;
    public static final int APPLICATION_HEIGHT = 500;

    /* Offset so the whole picture is at center */
    public static double centerOffsetX = 0;
    public static double centerOffsetY = 0;

    private static final Color BOX_COLOR = new Color(57, 95, 45);

    /* Calculate offset so the whole picture is at center */
    public void calcCenterOffset() {
        //To find the area of the window, sum up the areas of all the squares (NUM_COLS*BOX_SIZE),
        // as well as the spaces between them((NUM_COLS-1)*BOX_SPACING).
        double boxAreaX = NUM_COLS * BOX_SIZE + (NUM_COLS - 1) * BOX_SPACING;
        double boxAreaY = NUM_ROWS * BOX_SIZE + (NUM_ROWS - 1) * BOX_SPACING;

        centerOffsetX = ((getWidth() - boxAreaX) / 2);
        centerOffsetY = ((getHeight() - boxAreaY) / 2);
    }

    public void run() {
        calcCenterOffset();
        drawBackground(); //Draw a background (looks nicer :D)

		/* Draw boxes from left to right, from top to bottom.
		   After each row, need to reset offset X, so it would be at the start of the row again
		   and add spacing between boxes to offset Y, so rows wouldn't smash together.	*/
        for (int i = 0; i < NUM_ROWS; i++) { //draw rows (aka ↓)
            for (int j = 0; j < NUM_COLS; j++) { //draw cols (aka →)

                /*  Draw box
                    coordinates = offset for image centering + sum of the areas of existing squares +
                    sum of the distances between them    */
                drawBox(centerOffsetX + BOX_SPACING * j + BOX_SIZE * j, centerOffsetY + BOX_SPACING * i + BOX_SIZE * i);
            }
        }
    }

    // Overriding the draw method
    public void drawBox(double x, double y) {
        drawBox(x, y, BOX_SIZE, BOX_COLOR);
    }
}
