package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.awt.Color;

//  This class manages color gradients for the caterpillar.
public class ColorShiftCalculate {
    int[] RGB = new int[3]; //the amount of red, green, and blue, respectively
	boolean[] RGB_decreases = new boolean[3]; //Determines whether the amount of the corresponding color (red / green / blue) should be increased or decreased

    static int colorShift = 5; //"Step" of each color => how much it changes from the previous
	ColorShiftCalculate(int rValue, int gValue, int bValue, boolean rDecrease, boolean gDecrease, boolean bDecrease) {
		RGB[0] = rValue;
		RGB[1] = gValue;
		RGB[2] = bValue;
	
		RGB_decreases[0] = rDecrease;
		RGB_decreases[1] = gDecrease;
		RGB_decreases[2] = bDecrease;
	}

    public static void setColorShift (int value) {
        colorShift = value;
    }

	/*
        Goal: shift gradually each value of RGB from 0 to 255 and then from 255 to 0
            RGB_decreases determines if we are shifting from 0 to 255 (false) or from 255 to 0 (true)

            if RGB_decreases = false => multiply step by 1 => it will add step to value => we are going from 0 to 255
            if RGB_decreases = true => multiply step by -1 => it will subtract step from value => we are going from 255 to 0
	 */
	public int shiftColor(int indexColor) {
        /* if you've never seen ( ?  :) — this means:
            "if the part before the '?' is true, then use the part between the ‘?’ and the ‘:’;
            if false, use the part after ':'") */
		RGB[indexColor] += colorShift * (RGB_decreases[indexColor] ? -1 : 1 ); //calculate new RGB value
		if (RGB[indexColor] > 0 && RGB[indexColor] < 255){ 	//if it is in range from 0 to 255 => everything is okay, just return value
			return RGB[indexColor];
		}

		else if (RGB[indexColor] < 0) RGB[indexColor] = 0; 		// if value < 0 => reset to 0
		else if (RGB[indexColor] > 0) RGB[indexColor] = 255; 	// if value > 255 => reset to 255
		
		RGB_decreases[indexColor] = !RGB_decreases[indexColor]; //in both cases we need to switch are we subtracting or not.
		return RGB[indexColor]; //return value
	}
	
	//shift RGB and turn values into Color
	public Color getColorShift() {
		return new Color(shiftColor(0), shiftColor(1), shiftColor(2));
	}

    public Color getColor() {
        return new Color(RGB[0], RGB[1], RGB[2]);
    }
}
