package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.util.Random;

public class ColorShiftCalculateRandom extends ColorShiftCalculate{
    public static final int RGB_LOWER_BOUND = 0;
    public static final int RGB_UPPER_BOUND = 255;

    public static final Random r = new Random();

    ColorShiftCalculateRandom(){
        super(r.nextInt(RGB_LOWER_BOUND, RGB_UPPER_BOUND),r.nextInt(RGB_LOWER_BOUND, RGB_UPPER_BOUND),r.nextInt(RGB_LOWER_BOUND, RGB_UPPER_BOUND),r.nextBoolean(),r.nextBoolean(),r.nextBoolean());
    }

}
