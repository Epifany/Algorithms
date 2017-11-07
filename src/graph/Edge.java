package graph;

/**
 *
 * @author StephenGung
 */
public class Edge{
	private String sourceVertex;
	private String destinationVertex;
	
	public Edge( String initSource, String initDestination){
		sourceVertex = initSource;
		destinationVertex = initDestination;
	}
	
	public String getSourceVertexName()			{	return sourceVertex;		}
	public String getDestinationVertexName()	{	return destinationVertex;	}
}