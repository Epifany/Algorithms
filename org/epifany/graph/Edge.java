/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.graph;

/**
 *
 * @author Stephen Gung
 */
public class Edge {
	private String sourceVertex;
	private String destinationVertex;
	
	public Edge( String source, String destination){
		sourceVertex = source;
		destinationVertex = destination;
	}
	
	public String getSourceVertexName(){
		return sourceVertex;
	}
	
	public String getDestinationVertexName(){
		return destinationVertex;
	}
}