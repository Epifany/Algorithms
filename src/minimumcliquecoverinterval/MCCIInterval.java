package minimumcliquecoverinterval;

/**
 *
 * @author StephenGung
 */
public class MCCIInterval{
	private String name;
	private int leftEndPoint;
	private int rightEndPoint;
	
	public MCCIInterval( String initName, int initStartNum, int initEndNum){
		name = initName;
		leftEndPoint = initStartNum;
		rightEndPoint = initEndNum;
	}
	
	public String getName()			{	return name;		}
	public int getLeftEndPoint()	{	return leftEndPoint;	}
	public int getRightEndPoint()	{	return rightEndPoint;		}
}