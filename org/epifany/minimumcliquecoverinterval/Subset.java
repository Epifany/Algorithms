/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.minimumcliquecoverinterval;

import java.util.ArrayList;

/**
 *
 * @author Stephen Gung
 */
public class Subset {
	ArrayList<MCCIInterval> intervals;
	private int mutualLeftEndPoint;
	private int mutualRightEndPoint;
	
	public Subset(){
		intervals = new ArrayList<>();
	}
	
	public void addInterval( MCCIInterval interval){
		intervals.add( interval);
	}
	
	public void setMutualLeftEndPoint( int left){
		mutualLeftEndPoint = left;
	}
	
	public void setMutualRightEndPoint( int right){
		mutualRightEndPoint = right;
	}
	
	public MCCIInterval getIntervalAt( int index){
		return intervals.get( index);
	}
	
	public int getNumIntervals(){
		return intervals.size();
	}
	
	public int getMutualLeftEndPoint(){
		return mutualLeftEndPoint;
	}
	
	public int getMutualRightEndPoint(){
		return mutualRightEndPoint;
	}
}