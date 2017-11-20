/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.combinatorialsearch;

import java.util.ArrayList;

/**
 * This class represents a set, containing some integer values
 * This class is intended for visual clarity on the Combinatorial Search problem
 * @author Stephen Gung
 */
public class Set {
	private ArrayList<Integer> set;	// Our set of integers
	private int id;					// The id of this set; in the event there are multiple sets that needs to be distinguished
	
	/** Default constructor */
	public Set(){
		set = new ArrayList<>();
		id = 0;
	}
	
	public void setID( int id){
		this.id = id;
	}
	
	public void add( int num){
		set.add( num);
	}
	
	/**
	 * This method determines whether set is a subset of this instance
	 * @param set
	 * @return 
	 */
	public boolean containsSubset( Set set){
		if( set.size() > set.size()){
			return false;
		}
		for( int i=0; i<set.size(); i++){
			int elementToCompare = set.get(i);	// Get the ith element
			boolean containsElement = false;
			// Compare the ith element to every element in our set
			for( int j=0; j<set.size(); j++){
				if( elementToCompare == set.get( j)){
					containsElement = true;		// Element found
					break;						// Continue to next elementToCompare
				}
			}
			// If set did not contain elementToCompare then 
			if( containsElement == false){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method returns a copy of this instance
	 * @return 
	 */
	public ArrayList<Integer> getCopy(){
		ArrayList<Integer> copySet = new ArrayList<>();
		for( int i=0; i<set.size(); i++){
			copySet.add( set.get(i));
		}
		return copySet;
	}
	
	public int size(){
		return set.size();
	}
	
	public int get( int n){
		return set.get( n);
	}
	
	public int getID(){
		return id;
	}
}