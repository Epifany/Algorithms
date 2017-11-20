/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.travelingsalesmanbitonictours;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * NOT COMPLETED
 * @author Stephen Gung
 */
public class TravelingSalesmanBitonicTours {
	
	public TravelingSalesmanBitonicTours(){}
	
	public void run(){
		ArrayList<Point> somePoints = new ArrayList<>();
		somePoints.add( new Point( 1, 7));
		somePoints.add( new Point( 2, 1));
		somePoints.add( new Point( 3, 4));
		somePoints.add( new Point( 6, 5));
		somePoints.add( new Point( 7, 2));
		somePoints.add( new Point( 8, 6));
		somePoints.add( new Point( 9, 3));
		Point[] points = new Point[ somePoints.size()];
		for( int i=0; i<points.length; i++){
			points[i] = somePoints.get(i);
		}
		/*
		ArrayList<Edge> someEdges = new ArrayList<Edge>();
		someEdges.add( new Edge( points[0], points[1]));
		someEdges.add( new Edge( points[1], points[4]));
		someEdges.add( new Edge( points[4], points[6]));
		someEdges.add( new Edge( points[0], points[2]));
		someEdges.add( new Edge( points[2], points[3]));
		someEdges.add( new Edge( points[3], points[5]));
		someEdges.add( new Edge( points[6], points[5]));
		double someDouble = 0;
		for( int i=0; i<someEdges.size(); i++)
			someDouble += someEdges.get(i).getLength();
		System.out.println( someDouble);
		*/
		Edge e = new Edge( new Point( 1, 7), new Point( 2, 1));
		System.out.println( e.getLength());
		double[][] bitonicLength = new double[ points.length][ points.length];
		
		for( int i=0; i<bitonicLength.length; i++){
			for( int j=0; j<bitonicLength[i].length; j++){
				if( i >= j)
					bitonicLength[i][j] = -1;
				else if( i < j){
					if( i == j-1){
						Edge tempEdge = new Edge( points[0], points[j]);
						double min_current = bitonicLength[0][i] + tempEdge.getLength();
						double min_temp = 0;
						for( int num=1; num<i; num++){
							tempEdge = new Edge( points[num], points[j]);
							min_temp = bitonicLength[num][i] + tempEdge.getLength();
							if( min_temp < min_current)
								min_current = min_temp;
						}
						bitonicLength[i][j] = min_current;
					}
					else{
						Edge tempEdge = new Edge( points[j-1], points[j]);
						bitonicLength[i][j] = bitonicLength[i][j-1] + tempEdge.getLength();
					}
				}
			}
		}// The complexity of this algorithm is O(n^2)
		displayTable( bitonicLength);
	}
	
	public void displayTable( double[][] table){
		double row = table.length;
		double column;
		for( int i=0; i<row; i++){
			column = table[i].length;
			for( int j=0; j<column; j++){
				DecimalFormat df = new DecimalFormat( "#.00");
				System.out.print( df.format( table[i][j]) + "\t\t");
			}
			System.out.println("");	// New line
		}
	}
}