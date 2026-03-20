package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.awt.Color;

// Task: Draw a flag made of three stripes (France).
public class Assignment2Part4 extends DrawShapes {
    // The window's parameters
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 400;

    //Flag's size
    public static final int FLAG_WIDTH = 225;
    public static final int FLAG_HEIGHT = 150;

    //Flag's colors
    private static final Color FRANCE_BLUE = new Color(0, 38, 84);
    private static final Color FRANCE_RED = new Color(206, 17, 38);
    private static final String TEXT_FRANCE = "Flag of France ";

    public void run() {
        dFlag();
        drawTextLabelRBCorner(TEXT_FRANCE);
    }

    //Draw a flag
    public void dFlag() {
        //offset to center the flag
        int centerOffsetX = (getWidth() - FLAG_WIDTH) / 2;
        int centerOffsetY = (getHeight() - FLAG_HEIGHT) / 2;

        //The strips are vertical => calculate the width of each strip (the height will be equal to the height of the flag)
        int stripeWidth = FLAG_WIDTH / 3;

        /*Flag of France
            To find the coordinates where the stripe should be drawn: offset from the start of the flag +
            the width of the existing stripes.
         */
        drawRect(centerOffsetX, centerOffsetY, stripeWidth, FLAG_HEIGHT, FRANCE_BLUE);
        drawRect(centerOffsetX + stripeWidth, centerOffsetY, stripeWidth, FLAG_HEIGHT, Color.white);
        drawRect(centerOffsetX + stripeWidth * 2, centerOffsetY, stripeWidth, FLAG_HEIGHT, FRANCE_RED);

        //Black border above flag
        drawRect(centerOffsetX, centerOffsetY, FLAG_WIDTH, FLAG_HEIGHT);
    }
}
