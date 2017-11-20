/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.combinatorialsearch;

import java.util.ArrayList;

/**
 * This class represents the universal set, containing integer values from 1 to n
 * Where n denotes the highest integer
 * 
 * ex) If the universal set = { 1, 2, 3, 4, 5}
 * Then n == 5
 * 
 * This class is intended for visual clarity on the Combinatorial Search problem
 * @author Stephen Gung
 */
public class UniversalSet {
	private ArrayList<Integer> set;	// Our set of integers
	
	/** Default constructor */
	public UniversalSet(){
		set = new ArrayList<>();
	}
	
	public UniversalSet( int n){
		set = new ArrayList<>();
		for( int i=0; i<n; i++){
			set.add( i+1);
		}
	}
	
	/**
	 * Initialize our elements based on parameter
	 * @param n 
	 */
	public void initializeElements( int n){
		set.clear();
		for( int i=0; i<n; i++){
			set.add( i+1);
		}
	}
	
	/** this method clears out the universal set */
	public void clearSet(){
		set.clear();
	}
	
	/** This method returns an array of booleans with size equal to the number of elements
	 * in the universal set */
	public boolean[] getBooleanFlags(){
		boolean[] universalCheck = new boolean[ set.size()];
		return universalCheck;
	}
	
	public int get( int n){
		return set.get( n);
	}
	
	public int size(){
		return set.size();
	}
}