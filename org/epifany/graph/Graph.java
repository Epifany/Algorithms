/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.graph;

/**
 *
 * @author Stephen Gung
 */
public class Graph {
	private int numVertices;
	private Vertex[] vertices;
	private int[][] matrix_adj;
	
	public Graph( String[] str_v, String[][] str_e ){
		numVertices = str_v.length;
		vertices = new Vertex[ numVertices];
		for( int i=0; i<numVertices; i++){
			Vertex newVertex = new Vertex( str_v[i], str_e[i]);
			vertices[i] = newVertex;
		}
		
		// Set up the adjacency matrix for this graph
		matrix_adj = new int[ numVertices][ numVertices];
		for( int i=0; i<matrix_adj.length; i++){
			int currentIndex = 0;
			for( int j=0; j<matrix_adj[i].length; j++){
				if( currentIndex >= vertices[i].getNumEdges())
					break;
				String vertex_dest = vertices[i].getEdgeAt( currentIndex).getDestinationVertexName();
				String vertex_curr = vertices[j].getName();
				if( vertex_dest.equals( vertex_curr)){
					matrix_adj[j][i] = 1;	// Code needs to be editted more nicely. Do when have time
					currentIndex++;
				}
				else{
					matrix_adj[j][i] = 0;	// Code needs to be editted more nicely. Do when have time
				}
			}
		}
	}
	
	public Vertex getVertexAt( int index){
		return vertices[index];
	}
	
	public int getNumVertices(){
		return numVertices;
	}
	
	public int[][] getAdjacencyMatrix(){
		return matrix_adj;
	}
}