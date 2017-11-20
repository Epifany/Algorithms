/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.graph;

/**
 *
 * @author Stephen Gung
 */
public class Vertex {
	private String name;
	private int numEdges;
	private Edge[] edges;
	
	public Vertex( String name, String[] str_e){
		this.name = name;
		numEdges = str_e.length;
		if( numEdges > 0){
			edges = new Edge[ numEdges];
			for( int i=0; i<numEdges; i++){
				Edge newEdge = new Edge( name, str_e[i]);
				edges[i] = newEdge;
			}
		}
	}
	
	public Edge getEdgeAt( int index){
		return edges[ index];
	}
	
	public String getName(){
		return name;
	
	}
	public int getNumEdges(){
		return numEdges;
	}
	
}