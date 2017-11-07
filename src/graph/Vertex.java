package graph;

/**
 *
 * @author StephenGung
 */
public class Vertex{
	private String name;
	private int numEdges;
	private Edge[] edges;
	
	public Vertex( String initName, String[] initEdges){
		name = initName;
		numEdges = initEdges.length;
		if( numEdges > 0){
			edges = new Edge[ numEdges];
			for( int i=0; i<numEdges; i++){
				Edge newEdge = new Edge( name, initEdges[i]);
				edges[i] = newEdge;
			}
		}
	}
	
	public Edge getEdgeAt( int initIndex)	{	return edges[ initIndex];	}
	public String getName()					{	return name;				}
	public int getNumEdges()				{	return numEdges;			}
	
}