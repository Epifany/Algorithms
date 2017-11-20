/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.combinatorialsearch;

import java.util.ArrayList;

/**
 * This class represents a group of Sets,
 * While the Set class contains integer values, this class will contain a set of Sets
 * This class is intended for visual clarity on the Combinatorial Search problem
 * @author Stephen Gung
 */
public class GroupSet {
	private ArrayList<Set> groupSet;	// Our set of Sets
	private int numElements;	// Denotes the combined number of elements from all sets
	
	/** Default constructor */
	public GroupSet(){
		groupSet = new ArrayList<>();
		numElements = 0;
	}
	
	public void clearSets(){
		groupSet.clear();
	}
	public void removeSetAt( int n){
		groupSet.remove( n);
	}
	
	public void add( Set set){
		groupSet.add( set);
		numElements += set.size();
	}
	
	/** This method returns a copy of this instance */
	public GroupSet getCopy(){
		GroupSet copyGroupSet = new GroupSet();
		for( int i=0; i<groupSet.size(); i++){
			Set tempSet = groupSet.get( i);
			copyGroupSet.add( tempSet);
		}
		return copyGroupSet;
	}
	
	public Set getFirstSet(){
		return groupSet.get(0);
	}
	
	public Set getLastSet(){
		return groupSet.get( groupSet.size()-1);
	}
	
	public Set getSetAt( int n){
		return groupSet.get( n);
	}
	
	public int size(){
		return groupSet.size();
	}
	
	public int getNumElements(){
		return numElements;
	}
}