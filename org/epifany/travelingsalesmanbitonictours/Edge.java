/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.travelingsalesmanbitonictours;

/**
 *
 * @author Stephen Gung
 */
public class Edge {
	private Point pointOne;
	private Point pointTwo;
	private double length;
	
	public Edge(){}
	public Edge( Point p1, Point p2){
		pointOne = p1;
		pointTwo = p2;
		
		double tempX = pointTwo.getX() - pointOne.getX();
		tempX = tempX * tempX;
		double tempY = pointTwo.getY() - pointOne.getY();
		tempY = tempY * tempY;
		length = Math.sqrt( tempX + tempY);
	}
	
	public void setPointOne( Point p1){
		pointOne = p1;
	}
	
	public void setPointTwo( Point p2){
		pointTwo = p2;
	}
	
	public void computeLength(){
		double tempX = pointTwo.getX() - pointOne.getX();
		tempX = tempX * tempX;
		double tempY = pointTwo.getY() - pointOne.getY();
		tempY = tempY * tempY;
		length = Math.sqrt( tempX + tempY);
	}
	
	public Point getPointOne(){
		return pointOne;
	}
	
	public Point getPointTwo(){
		return pointTwo;
	}
	
	public double getLength(){
		return length;
	}
}