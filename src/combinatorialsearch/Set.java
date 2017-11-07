package combinatorialsearch;

import java.util.ArrayList;

/**
 * This class represents a set, containing some integer values
 * This class is intended for visual clarity on the Combinatorial Search problem
 * @author StephenGung
 */
public class Set{
	private ArrayList<Integer> set;	// Our set of integers
	private int id;					// The id of this set; in the event there are multiple sets that needs to be distinguished
	
	/** Default constructor */
	public Set(){
		set = new ArrayList<>();
		id = 0;
	}
	
	public void setID( int initID)	{	id = initID;		}
	public void add( int initNum)	{	set.add( initNum);	}
	
	/** This method determines whether initSet is a subset of this instance */
	public boolean containsSubset( Set initSet){
		if( initSet.size() > set.size()){
			return false;
		}
		for( int i=0; i<initSet.size(); i++){
			int elementToCompare = initSet.get(i);	// Get the ith element
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
	
	/** This method returns a copy of this instance */
	public ArrayList<Integer> getCopy(){
		ArrayList<Integer> copySet = new ArrayList<>();
		for( int i=0; i<set.size(); i++){
			copySet.add( set.get(i));
		}
		return copySet;
	}
	
	public int size()			{	return set.size();		}
	public int get( int initN)	{	return set.get( initN);	}
	public int getID()			{	return id;				}
}