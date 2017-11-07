package universalsink;

/**
 * Given a directed graph G = ( V, E)
 * Where V is the number of vertices, and E is the number of edges
 * The universal sink problem attempts to solve whether there exists a vertex in G that has an in-degree of |V-1|
 * and an out-degree of 0, given an Adjacency Matrix for G
 * @author StephenGung
 */
public class UniversalSinkOld{
	int[][] adjacencyMatrix;
	
	public UniversalSinkOld(){}	// Blank initializer

	public int compute( int[][] initAdjacencyMatrix){
		adjacencyMatrix = initAdjacencyMatrix;
		return computeAlgorithm();
	}
	
	private int computeAlgorithm(){
		int index = -1;
		int i = 1;
		int j = 0;
		int numVertices = adjacencyMatrix.length;
		int[] flags = new int[ numVertices];	// Used as a flag. Let 0 denote as a possible candidate for universal sink. Let -1 denote as NOT a possible candidate
		while( i<numVertices && j<numVertices){
			/* Vertex I has an In-Degree edge from Vertex J OR
			 * There is a directed edge from Vertex J to Vertex I
			 * So Vertex J cannot be a universal sink, because for a vertex to be a universal sink
			 * It needs to have no directed edges going away from Vertex J */
			if( adjacencyMatrix[i][j] == 1){
				if( i == j){
					flags[j] = -1;
					flags[i] = -1;
					i++;
				}
				else{
					flags[j] = -1;	// Mark vertex as not a candidate for universal sink
					if( adjacencyMatrix[j][i] == 1)	// Only needed if graph allows cycles
						flags[i] = -1;
				}
				j++;			// Iterate to next column
			}
			else if( adjacencyMatrix[i][j] == 0){
				if( i == j)		{/*Do Nothing*/}	// matrix at [i][j] == 0 does not provide enough information, so do nothing
				else			flags[i] = -1;
				i++;			// Iterate to next row
			}
		}
		
		int count = 0;
		for( i=0; i<flags.length; i++){
			if( flags[i] == 0){
				index = i;
				count++;
			}
		}
		if( count > 1)	return -1;
		int numColumnDegree = 0;
		int numRowDegree = 0;
		for( i=0; i<adjacencyMatrix[ index].length; i++){
			if( adjacencyMatrix[ index][i] == 1)	numRowDegree++;
			if( adjacencyMatrix[ i][ index] == 1)	numColumnDegree++;
		}
		if( numRowDegree == adjacencyMatrix.length-1 && numColumnDegree == 0)	return index;
		else																	return -1;
	}
}