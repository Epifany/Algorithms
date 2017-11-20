/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.minimumcliquecoverinterval;

import java.util.ArrayList;

/**
 *
 * @author Stephen Gung
 */
public class MinimumCliqueCoverInterval {
	MCCIInterval[] intervals;
	ArrayList<Subset> subsets;
	
	public MinimumCliqueCoverInterval(){}	// Blank initializer
	
	public int compute( MCCIInterval[] intervals){
		this.intervals = intervals;
		subsets = new ArrayList<>();
		// For now assume sorted by increasing start number
		return computeAlgorithm();
	}
	
	private int computeAlgorithm(){
		subsets.add( new Subset());					// This is the base case, we'll have at least one subset
		subsets.get(0).addInterval( intervals[0]);	// At the first interval to this base case
		subsets.get(0).setMutualLeftEndPoint( intervals[0].getLeftEndPoint());
		subsets.get(0).setMutualRightEndPoint( intervals[0].getRightEndPoint());
		// At this point, the intervals are assumed to be sorted in increasing  Left End Point, so Right End Point should not matter
		for( int i=1; i<intervals.length; i++){
			Subset subset_curr = subsets.get( subsets.size()-1);
			MCCIInterval interval_curr = intervals[i];
			int mutualLeftEndPoint_new = interval_curr.getLeftEndPoint();
			int mutualRightEndPoint_new;
			if( subset_curr.getMutualRightEndPoint() <= interval_curr.getLeftEndPoint()){
				subsets.add( new Subset());						// Create a new subset
				subset_curr = subsets.get( subsets.size()-1);	// Retrieve the newly added subset
				mutualRightEndPoint_new = interval_curr.getRightEndPoint();
			}
			else{
				mutualRightEndPoint_new =
						(interval_curr.getRightEndPoint() <= subset_curr.getMutualRightEndPoint()) ?
						interval_curr.getRightEndPoint() : subset_curr.getMutualRightEndPoint();
			}
			// Add this interval to our current subset
			subset_curr.addInterval( interval_curr);
			// Set our new left end point
			subset_curr.setMutualLeftEndPoint( mutualLeftEndPoint_new);
			// Set our new right end point
			subset_curr.setMutualRightEndPoint( mutualRightEndPoint_new);
		}// This algorithm takes O(n)
		// But sorting takes O( n * log(n))!
		
		/*
		for( int i=1; i<intervals.length; i++){
			Subset currentSubset = subsets.get( indexOfLastSubset);
			MCCIInterval currentInterval = intervals[i];
			// Because intervals are sorted in increasing Left End Points
			// This means that this interval's left end point is past the subset's mutual right end point
			// Meaning that this interval does not overlap with all the other intervals within this subset
			if( currentSubset.getMutualRightEndPoint() <= currentInterval.getLeftEndPoint()){
				subsets.add( new Subset());				// Create a new subset
				indexOfLastSubset = subsets.size()-1;	// get the index of this subset for easy access
				subsets.get( indexOfLastSubset).addInterval( currentInterval);		// Add the current interval to this set
				// Set the mutual left and right end points
				subsets.get( indexOfLastSubset).setMutualLeftEndPoint( currentInterval.getLeftEndPoint());
				subsets.get( indexOfLastSubset).setMutualRightEndPoint( currentInterval.getRightEndPoint());
			}
			else{
				// currentIntervals leftEndPoint should always be past the mutual leftEndPoint. Otherwise the sorting is wrong
				// So the currentInterval's leftEndPoint will be used for the new mutual leftEndPoint
				int newMutualLeftEndPoint = currentInterval.getLeftEndPoint();
				int newMutualRightEndPoint;	// Need to determine where the new mutual right end point should be
				if( currentInterval.getRightEndPoint() <= currentSubset.getMutualRightEndPoint())	newMutualRightEndPoint = currentInterval.getRightEndPoint();
				else																				newMutualRightEndPoint = currentSubset.getMutualRightEndPoint();
				// Add this interval to our current subset
				currentSubset.addInterval( currentInterval);
				currentSubset.setMutualLeftEndPoint( newMutualLeftEndPoint);
				currentSubset.setMutualRightEndPoint( newMutualRightEndPoint);
			}
		}// This algorithm takes O(n)
		*/
		
		System.out.println("");
		for( int i=0; i<subsets.size(); i++){
			System.out.print( "Subset " + (i+1) + ", Intervals: ");
			Subset temp = subsets.get(i);
			for( int j=0; j<temp.getNumIntervals(); j++){
				MCCIInterval tempInterval = temp.getIntervalAt( j);
				System.out.print( tempInterval.getName() + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		return subsets.size();	// Return the number of subsets we had to create
	}
	
}