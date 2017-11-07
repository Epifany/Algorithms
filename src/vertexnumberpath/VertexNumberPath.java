package vertexnumberpath;

/**
 * 
 * @author StephenGung
 */
public class VertexNumberPath{
	VNPGraph graph;
	Vertex startVertex;
	Vertex endVertex;
	int[] visited;
	public VertexNumberPath(){}	// Blank initializer
	
	public int compute( VNPGraph initG, String initStartVertex, String initEndVertex){
		graph = initG;
		for( int i=0; i<graph.getNumVertices(); i++){
			Vertex tempVertex = graph.getVertexAt( i);
			if( tempVertex.getName().equals( initStartVertex))	startVertex = tempVertex;
			if( tempVertex.getName().equals( initEndVertex))	endVertex = tempVertex;
		}
		visited = new int[ graph.getNumVertices()];
		for( int i=0; i<visited.length; i++){
			visited[i] = -1;
		}
		return computeAlgorithm();
	}
	
	private int computeAlgorithm(){
		return modifiedDepthFirstSearch( startVertex, endVertex);
	}
	
	private int modifiedDepthFirstSearch( Vertex sourceVertex, Vertex targetVertex){
		if( sourceVertex.getName().equals( targetVertex.getName())) return 1;
		int index = getVertexIndex( sourceVertex.getName());
		if( visited[ index] != -1)
			return visited[ index];
		int count = 0;
		int numEdges = sourceVertex.getNumEdges();
		for( int i=0; i<numEdges; i++){
			Vertex currentVertex = getVertex( sourceVertex.getEdgeAt( i).getDestinationVertexName());
			count += modifiedDepthFirstSearch( currentVertex, targetVertex);
		}
		visited[ index] = count;
		return count;
	}
	
	private Vertex getVertex( String initVertexName){
		Vertex tempVertex = null;
		for( int i=0; i<graph.getNumVertices(); i++){
			if( graph.getVertexAt( i).getName().equals( initVertexName)){
				tempVertex = graph.getVertexAt( i);
				break;
			}
		}
		return tempVertex;
	}
	
	private int getVertexIndex( String initVertexName){
		int temp = 0;
		for( int i=0; i<graph.getNumVertices(); i++){
			if( graph.getVertexAt( i).getName().equals( initVertexName)){
				temp = i;
				break;
			}
		}
		return temp;
	}
}