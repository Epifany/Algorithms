/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.minimumcliquecoverinterval;

/**
 *
 * @author Stephen Gung
 */
public class MCCIInterval {
	private String name;
	private int leftEndPoint;
	private int rightEndPoint;
	
	public MCCIInterval( String name, int numStart, int numEnd){
		this.name = name;
		leftEndPoint = numStart;
		rightEndPoint = numEnd;
	}
	
	public String getName(){
		return name;
	}
	
	public int getLeftEndPoint(){
		return leftEndPoint;
	}
	
	public int getRightEndPoint(){
		return rightEndPoint;
	}
}