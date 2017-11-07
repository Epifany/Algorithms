package algorithms;

import editsequence.EditSequence;
import minimumcliquecoverinterval.MCCIInterval;
import minimumcliquecoverinterval.MinimumCliqueCoverInterval;
import universalsink.UniversalSinkOld;
import vertexnumberpath.VNPGraph;
import vertexnumberpath.VertexNumberPath;
import yuckdonaldsmaxprofit.YuckdonaldsMaxProfit;
import combinatorialsearch.CombinatorialSearch;

/**
 * This class is contains the main method and is used to run the various algorithms
 * @author StephenGung
 */
public class Algorithms{

	// Main method
	public static void main( String[] args){
		int result = -1;
		
		
		CombinatorialSearch.compute( "testFiles/combinatorialSearchTestFile1.txt");
		
		
		
		//EditSequence editSequence = new EditSequence();
		//result = editSequence.compute( "algorithm", "altruistic");
		
		/*
		String[] vertices = { "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[][] edges = {	{ "Q", "R", "X"},
								{ "O", "Q", "U"},
								{ "R", "S", "V"},
								{ "O", "S", "Z"},
								{ "T"},
								{ "U", "Y"},
								{ "R"},
								{ },
								{ "T"},
								{ "W"},
								{ "Z"},
								{ },
								{ "V"},
								{ },
						};
		VNPGraph g = new VNPGraph( vertices, edges);
		VertexNumberPath vertexNumberPath = new VertexNumberPath();
		result = vertexNumberPath.compute( g, "P", "V");
		*/
		
		/*
		MCCIInterval[] intervals = new MCCIInterval[ 8];
		intervals[0] = new MCCIInterval( "11", 0, 3);
		intervals[1] = new MCCIInterval( "14", 0, 2);
		intervals[2] = new MCCIInterval( "17", 1, 10);
		intervals[3] = new MCCIInterval( "15", 4, 9);
		intervals[4] = new MCCIInterval( "12", 5, 12);
		intervals[5] = new MCCIInterval( "18", 11, 15);
		intervals[6] = new MCCIInterval( "16", 11, 14);
		intervals[7] = new MCCIInterval( "13", 13, 15);
		
		int numRow = intervals.length;
		int numColumns = intervals[7].getRightEndPoint();
		String[][] table = new String[ numRow][ numColumns+1];
		for( int i=0; i<table.length; i++){
			int startNum = intervals[i].getLeftEndPoint();
			int endNum = intervals[i].getRightEndPoint();
			for( int j=0; j<table[i].length; j++){
				if( startNum <= j && j <= endNum)	table[i][j] = "-";
				else								table[i][j] = " ";
			}		
		}
		for( int i=0; i<table.length; i++){
			System.out.print( "Interval " + intervals[i].getName() + "\t");
			for( int j=0; j<table[i].length; j++){
				System.out.print( table[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		MinimumCliqueCoverInterval minClique = new MinimumCliqueCoverInterval();
		result = minClique.compute( intervals);
		*/
		
		
		/*
		UniversalSinkOld universalSink = new UniversalSinkOld();
		result = universalSink.compute( g.getAdjacencyMatrix());
		*/
		/*
		YuckdonaldsMaxProfit yuckDonalds = new YuckdonaldsMaxProfit();
		int[] m = { 0, 5, 48, 49, 50, 56, 59, 200};
		int[] p = { 1, 5, 7, 15, 8, 30, 20, 22};
		int k = 50;
		result = yuckDonalds.compute( m, p, k);
		*/
		
		System.out.println( "Result: " + result);
	}
}