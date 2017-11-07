package vertexnumberpath;

/**
 *
 * @author StephenGung
 */
public class VNPGraph{
	private int numVertices;
	private Vertex[] vertices;
	private int[][] adjacencyMatrix;
	
	public VNPGraph( String[] initVertices, String[][] initEdges ){
		numVertices = initVertices.length;
		vertices = new Vertex[ numVertices];
		for( int i=0; i<numVertices; i++){
			Vertex newVertex = new Vertex( initVertices[i], initEdges[i]);
			vertices[i] = newVertex;
		}
		
		// Set up the adjacency matrix for this graph
		adjacencyMatrix = new int[ numVertices][ numVertices];
		for( int i=0; i<adjacencyMatrix.length; i++){
			int currentIndex = 0;
			for( int j=0; j<adjacencyMatrix[i].length; j++){
				if( currentIndex >= vertices[i].getNumEdges())
					break;
				String destinationVertex = vertices[i].getEdgeAt( currentIndex).getDestinationVertexName();
				String currentVertex = vertices[j].getName();
				if( destinationVertex.equals( currentVertex)){
					adjacencyMatrix[j][i] = 1;	// Code needs to be editted more nicely. Do when have time
					currentIndex++;
				}
				else{
					adjacencyMatrix[j][i] = 0;	// Code needs to be editted more nicely. Do when have time
				}
			}
		}
	}
	
	public Vertex getVertexAt( int initIndex)	{	return vertices[ initIndex];	}
	public int getNumVertices()					{	return numVertices;				}
	public int[][] getAdjacencyMatrix()			{	return adjacencyMatrix;			}
}