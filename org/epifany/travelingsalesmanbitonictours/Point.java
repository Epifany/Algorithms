/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.travelingsalesmanbitonictours;

/**
 * This class represents a point in the Euclidean plane
 * @author Stephen Gung
 */
public class Point {
	private int x;	// This is the x coordinate
	private int y;	// This is the y coordinate
	
	public Point(){}
	public Point( int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX( int x){
		this.x = x;
	}
	
	public void setY( int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}