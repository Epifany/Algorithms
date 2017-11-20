/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.vertexnumberpath;

/**
 *
 * @author Stephen Gung
 */
public class VertexNumberPath {
	VNPGraph graph;
	Vertex start;
	Vertex end;
	int[] visited;
	public VertexNumberPath(){}	// Blank initializer
	
	public int compute( VNPGraph g, String vertex_start, String vertex_end){
		graph = g;
		for( int i=0; i<graph.getNumVertices(); i++){
			Vertex temp = graph.getVertexAt( i);
			if( temp.getName().equals( vertex_start))
				start = temp;
			if( temp.getName().equals( vertex_end))
				end = temp;
		}
		visited = new int[ graph.getNumVertices()];
		for( int i=0; i<visited.length; i++){
			visited[i] = -1;
		}
		return computeAlgorithm();
	}
	
	private int computeAlgorithm(){
		return modifiedDepthFirstSearch( start, end);
	}
	
	private int modifiedDepthFirstSearch( Vertex source, Vertex target){
		if( source.getName().equals( target.getName())) return 1;
		int index = getVertexIndex( source.getName());
		if( visited[ index] != -1)
			return visited[ index];
		int count = 0;
		int numEdges = source.getNumEdges();
		for( int i=0; i<numEdges; i++){
			Vertex current = getVertex( source.getEdgeAt( i).getDestinationVertexName());
			count += modifiedDepthFirstSearch( current, target);
		}
		visited[ index] = count;
		return count;
	}
	
	private Vertex getVertex( String name){
		Vertex temp = null;
		for( int i=0; i<graph.getNumVertices(); i++){
			if( graph.getVertexAt( i).getName().equals( name)){
				temp = graph.getVertexAt( i);
				break;
			}
		}
		return temp;
	}
	
	private int getVertexIndex( String name){
		int temp = 0;
		for( int i=0; i<graph.getNumVertices(); i++){
			if( graph.getVertexAt( i).getName().equals( name)){
				temp = i;
				break;
			}
		}
		return temp;
	}
}