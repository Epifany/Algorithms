package travelingsalesmanbitonictours;

/**
 *
 * @author StephenGung
 */
public class Edge{
	private Point pointOne;
	private Point pointTwo;
	private double length;
	
	public Edge(){}
	public Edge( Point initPointOne, Point initPointTwo){
		pointOne = initPointOne;
		pointTwo = initPointTwo;
		
		double tempX = pointTwo.getX() - pointOne.getX();
		tempX = tempX * tempX;
		double tempY = pointTwo.getY() - pointOne.getY();
		tempY = tempY * tempY;
		length = Math.sqrt( tempX + tempY);
	}
	
	public void setPointOne( Point initPointOne)	{	pointOne = initPointOne;	}
	public void setPointTwo( Point initPointTwo)	{	pointTwo = initPointTwo;	}
	public void computeLength(){
		double tempX = pointTwo.getX() - pointOne.getX();
		tempX = tempX * tempX;
		double tempY = pointTwo.getY() - pointOne.getY();
		tempY = tempY * tempY;
		length = Math.sqrt( tempX + tempY);
	}
	
	public Point getPointOne()	{	return pointOne;	}
	public Point getPointTwo()	{	return pointTwo;	}
	public double getLength()	{	return length;		}
}