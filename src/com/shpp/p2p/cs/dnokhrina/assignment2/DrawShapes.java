package com.shpp.p2p.cs.dnokhrina.assignment2;

import java.awt.Color;

import com.shpp.cs.a.graphics.WindowProgram;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;

public class DrawShapes extends WindowProgram{
	// Could add APPLICATION_WIDTH/APPLICATION_HEIGHT here, but still need to change value in each program, so no sense in doing this ??
	// Let me know, if u know
	
	private static final Color BACKGROUND_COLOR = new Color(180, 195, 140);
	
	//draw a circle (not filled, black outline)
	public GOval drawCircle(double x, double y, double width, double height) {
    	GOval circle = new GOval(x, y, width, height);
    	add(circle);
    	return circle;
    }
	
	//draw a circle (filled with color, but black outline)
    public GOval drawCircle(double x, double y, double width, double height, Color c) {
    	GOval circle = drawCircle(x, y, width, height);
    	circle.setFilled(true);
    	circle.setFillColor(c); 
    	return circle;
    }
    
    //draw a circle (filled with color, colored outline)
    public GOval drawCircle(double x, double y, double width, double height, Color mainColor, Color borderColor) {
    	GOval circle = drawCircle(x, y, width, height, mainColor);
    	circle.setColor(borderColor);
    	return circle;
    }
    
    //Didn't found method to set up border's width, so this method is implementing this
    //by drawing a slightly larger circle filled with border color before drawing the main one.
    public void drawCircleThick(double x, double y, double width, double height, int offset) {
    	drawCircle(x-offset, y-offset, width+offset*2, height+offset*2);
    	drawCircle(x, y, width, height);
    }

    public void drawCircleThick(double x, double y, double width, double height, Color mainColor, Color borderColor, int offset) {
        drawCircle(x-offset, y-offset, width+offset*2, height+offset*2, borderColor, borderColor);
        drawCircle(x, y, width, height, mainColor, borderColor);
    }
    
    //Draw an outline of rect (not filled, black border)
    //Name is the same, but one less argument (no color)
    public GRect drawRect(double x, double y, double  w, double h) {
    	GRect rect = new GRect(x, y, w, h);
    	add(rect);
    	return rect;
    }
    
    //Draw a rect filled with color
    public GRect drawRect(double x, double y, double  w, double h, Color c) {
    	GRect rect = drawRect(x, y, w, h);
    	rect.setColor(c);
    	rect.setFilled(true);
    	rect.setFillColor(c); 
    	return rect;
    }
    
    //Draw a text label at bottom right corner
    public void drawTextLabelRBCorner(String text) {
    	GLabel label = drawTextLabel(text, 0, 0); //create new label at 0,0
    	label.move(getWidth()-label.getWidth(), getHeight()-label.getDescent()); //move it to bottom right corner (need to subtract label's width from the frame's width and the label's descent from the frame's height)
    }
    
    //Create a label with given text at given coordinates.
    public GLabel drawTextLabel(String text, double x, double y) {
		GLabel label = new GLabel(text);
		label.setFont("Comic Sans-20");
		add(label);
		return label;
	}
    
    //Draw a box
	public void drawBox(double x, double y, double side, Color color) {
		drawRect(x, y, side, side, color);
    }
	
	//Draw a background. Just for looks.
	public void drawBackground(Color c) {
		drawRect(0, 0, getWidth(), getHeight(), c);
	}
	
	//Uses a standard color
	public void drawBackground() {
		drawBackground(BACKGROUND_COLOR);
	}
}
