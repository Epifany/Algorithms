package minimumcliquecoverinterval;

import java.util.ArrayList;

/**
 *
 * @author StephenGung
 */
public class Subset{
	ArrayList<MCCIInterval> intervals;
	private int mutualLeftEndPoint;
	private int mutualRightEndPoint;
	
	public Subset(){
		intervals = new ArrayList<MCCIInterval>();
	}
	
	public void addInterval( MCCIInterval initInterval){
		intervals.add( initInterval);
	}
	
	public void setMutualLeftEndPoint( int initLeft)	{	mutualLeftEndPoint = initLeft;		}
	public void setMutualRightEndPoint( int initRight)	{	mutualRightEndPoint = initRight;	}
	
	public MCCIInterval getIntervalAt( int index)	{	return intervals.get( index);	}	
	public int getNumIntervals()					{	return intervals.size();		}
	public int getMutualLeftEndPoint()				{	return mutualLeftEndPoint;		}
	public int getMutualRightEndPoint()				{	return mutualRightEndPoint;		}
}