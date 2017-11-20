/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.yuckdonaldsmaxprofit;

/**
 * This class represents a restaurant for the Yuckdonalds problem
 * @author Stephen Gung
 */
public class Restaurant {
	private int miles = 0;			// This represents the distance from a starting point
									// This distance is only relative to a single global point; it's not relative to any other restaurant locations
	private int expectedProfit = 0;	// This represents the expected profit for this restaurant
	
	public Restaurant(){}	// Blank initializer
	// Initializer with values
	public Restaurant( int miles, int expectedProfit){
		this.miles = miles;
		this.expectedProfit = expectedProfit;
	}
	
	// Setter methods
	public void setMiles( int miles){
		this.miles = miles;
	}
	
	public void setExpectedProfit( int expectedProfit){
		this.expectedProfit = expectedProfit;
	}
	
	// Getter methods
	public int getMiles(){
		return miles;
	}
	
	public int getExpectedProfit(){
		return expectedProfit;
	}
}