package universalsink;

/**
 * Universal Sink Problem
 * Given a directed graph G = ( V, E)
 * Where V is the number of vertices, and E is the number of edges
 * The universal sink problem attempts to solve whether there exists a vertex in G that has an
 * In-degree of |V-1|, and an out-degree of 0
 * @author StephenGung
 */
public final class UniversalSink{
	
	/**
	 * This class takes in the Adjacency Matrix representation of G
	 * Where initAdjacencyMatrix[i][j] denotes whether the vertex at i has an edge directed towards vertex at j
	 * If initAdjacencyMatrix[i][j] == 1 then vertex i has a directed edge towards vertex j
	 * If initAdjacencyMatrix[i][j] == 0 then vertex i does NOT have a directed edge towards vertex j
	 * Returns the index that contains the universal sink
	 * Returns -1 otherwise
	 */
	public static int compute( int[][] initAdjacencyMatrix){
		int index = -1;
		int i = 1;	// i represents rows
		int j = 0;	// j represents columns
		int numVertices = initAdjacencyMatrix.length;	// The number of vertices
		int[] flags = new int[ numVertices];	// Used as a flag, let 0 denote a possible candidate, and -1 denote NOT a possible candidate
		// Initialize all flags to true
		
		
		while( i<numVertices && j<numVertices){
			/* If vertex i does NOT have an edge to vertex j */
			if( initAdjacencyMatrix[i][j] == 0){
				if( i == j)
					{/*Do Nothing*/}	// Does not provide enough information
				/* initAdjacencyMatrix[i][j] == 0 for when i != j, Implies that vertex at j does NOt have an in-degree from vertex at i */
				else
					flags[j] = -1;	// So vertex at j would not have a universal sink
				j++;				// Iterate to next column
			}
			/* If vertex i has an edge to vertex j (an out-degree)*/
			else{ /* if initAdjacencyMatrix[i][j] == 1 */
				if( i == j){
					flags[i] = -1;
					//flags[j] = -1;	// Same as flags[i] for this case
					i++;			// Iterate to next row (vertex)
				}
				/* initAdjacencyMatrix[i][j] == 1 for when i != j, Implies that vertex at i has an out-degree to vertex at j */
				else{
					flags[i] = -1;	// So vertex at i can't be a universal sink, as it shouldn't have an out-degree
					// If we consider cycles
					if( initAdjacencyMatrix[j][i] == 1)
						flags[j] = -1;
				}
				j++;				// Iterate to next column
			}
		}
		// The worst case for the algorithm above is 2n
		// Thus this algorithm takes O(n)
		
		// flags should now be completed with 0s or -1s
		// Where 0 denotes a possible candidate, -1 otherwise
		
		int count = 0;
		for( i=0; i<flags.length; i++){
			if( flags[i] == 0){
				index = i;
				count++;
			}
		}
		
		// Just a precaution
		if( count > 1)	return -1;
		int numInDegree = 0;
		int numOutDegree = 0;
		for( i=0; i<initAdjacencyMatrix[ index].length; i++){
			if( initAdjacencyMatrix[ index][ i] == 1)	numOutDegree++;
			if( initAdjacencyMatrix[ i][ index] == 1)	numInDegree++;
		}
		if( numOutDegree == 0 && numInDegree == (numVertices-1))	return index;
		else														return -1;
	}
	
	// Two way directed edges?
}