package travelingsalesmanbitonictours;

/**
 * This class represents a point in the euclidean plane
 * @author StephenGung
 */
public class Point{
	private int x;	// This is the x coordinate
	private int y;	// This is the y coordinate
	
	public Point(){}
	public Point( int initX, int initY){
		x = initX;
		y = initY;
	}
	
	public void setX( int initX)	{	x = initX;	}
	public void setY( int initY)	{	y = initY;	}
	
	public int getX()				{	return x;	}
	public int getY()				{	return y;	}
}