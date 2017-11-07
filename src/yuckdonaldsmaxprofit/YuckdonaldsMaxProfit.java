package yuckdonaldsmaxprofit;

/**
 * This class is used to solve the Yuckdonalds Max Expected Total Profit problem
 * @author StephenGung
 */
public class YuckdonaldsMaxProfit{
	private Restaurant[] restaurants;				// The restaurant locations and profits used
	private int[] maxExpectedTotalProfit;			// The max expected total profit for n locations
	private int[] maxExpectedTotalProfitLocation;	// Keep track of which location was used for finding the max expected total
	private int k;									// The distance used. Any two restaurants should be at least k distance apart
	
	public YuckdonaldsMaxProfit(){} // Blank initializer
	
	/*
	 * Computes the max expected total profit for some number of "restaurants". The number of "restaurants" is determined by the size of
	 * the initDistances array and initProfits array. For example, if the size of array initDistances and array initProfits is 1 then there is only one restaurant.
	 * That being said, the size of the initDistances array and initProfits array should be equal, denoting that for every "restaurant" created
	 * a distance and expected profit is given for that restaurant
	 * Note that this method expects the values of array initDistances be in increasing order
	 * initK represents the distance apart you want for any two restaurants
	 * For example, if initK is 5 and the distance between two restaurants is less than 5,
	 * then you can only open one of these restaurants not both
	 */
	public int compute(  int[] initDistances, int[] initProfits, int initK){
		if( initDistances.length != initProfits.length)
			return -1;
		k = initK;
		restaurants = new Restaurant[ initDistances.length+1];
		restaurants[0] = new Restaurant( 0, 0);		// This is the base case, we can say that all miles are calculated base on this restaurant
		for( int i=1; i<restaurants.length; i++){
			restaurants[i] = new Restaurant( initDistances[i-1], initProfits[i-1]);
		}
		maxExpectedTotalProfit = new int[ restaurants.length];
		maxExpectedTotalProfitLocation = new int[ restaurants.length];
		return computeAlgorithm();
	}
	
	private int computeAlgorithm(){
		int closestLocationIndex;	// This int is used to find the location closest to the ith location
		for( int i=1; i<restaurants.length; i++){
			closestLocationIndex = 0;	// Reset value to the base case
			for( int j=1; j<restaurants.length; j++){
				if( j > i){/* Do Nothing */}	// Currently, we're only concerned with locations up to ith iteration
				else{
					// If the distance between these two locations are far enough apart
					if( (restaurants[i].getMiles() - restaurants[j].getMiles()) >= k)
						closestLocationIndex = j;
				}
			}
			// This int represents the max expected total profit if the ith location was not open
			int tempMaxProfitWithoutI = maxExpectedTotalProfit[ i-1];
			// This int represents the max expected total profit if the ith location was to be opened
			int tempMaxProfitWithI = restaurants[i].getExpectedProfit() + maxExpectedTotalProfit[ closestLocationIndex];
			if( tempMaxProfitWithI >= tempMaxProfitWithoutI){
				maxExpectedTotalProfit[i] = tempMaxProfitWithI;
				if( closestLocationIndex == 0)	maxExpectedTotalProfitLocation[i] = 0;
				else							maxExpectedTotalProfitLocation[i] = closestLocationIndex;
			}
			else{
				maxExpectedTotalProfit[i] = tempMaxProfitWithoutI;
				maxExpectedTotalProfitLocation[i] = -1;
			}
		}// The complexity for this algorithm is O(n^2)
		return maxExpectedTotalProfit[ maxExpectedTotalProfit.length-1];	// return the max expected total profit for the n locations
	}
	
	public int getExpectedProfitOfRestaurantAt( int initIndex)				{	return restaurants[ initIndex+1].getExpectedProfit();	}
	public int getMilesOfRestaurantAt( int initIndex)						{	return restaurants[ initIndex+1].getMiles();			}
	public int getMaxExpectedTotalProfitAt( int initIndex)					{	return maxExpectedTotalProfit[ initIndex+1];			}
	public int getMaxExpectedTotalProfitParentLocationAt( int initIndex)	{	return maxExpectedTotalProfitLocation[ initIndex+1];	}
	public int getDistanceK()												{	return k;											}
}