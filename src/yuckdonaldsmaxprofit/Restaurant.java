package yuckdonaldsmaxprofit;

/**
 * This class represents a restaurant for the Yuckdonalds problem
 * @author StephenGung
 */
public class Restaurant{
	private int miles = 0;			// This represents the distance from a starting point
									// This distance is only relative to a single global point; it's not relative to any other restaurant locations
	private int expectedProfit = 0;	// This represents the expected profit for this restaurant
	
	public Restaurant(){}	// Blank initializer
	// Initializer with values
	public Restaurant( int initMiles, int initExpectedProfit){
		miles = initMiles;
		expectedProfit = initExpectedProfit;
	}
	
	// Setter methods
	public void setMiles( int initMiles)					{	miles = initMiles;						}
	public void setExpectedProfit( int initExpectedProfit)	{	expectedProfit = initExpectedProfit;	}
	
	// Getter methods
	public int getMiles()			{	return miles;			}
	public int getExpectedProfit()	{	return expectedProfit;	}
}