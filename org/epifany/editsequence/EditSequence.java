/**
 * Copyright 2013, Stephen Gung, All rights reserved
 */

package org.epifany.editsequence;

/**
 * NOT COMPLETED
 * @author Stephen Gung
 */
public class EditSequence {
	private String str1;
	private String str2;
	private int[][] strMatrix;
	private int insert;
	private int delete;
	private int replace;
	
	public EditSequence(){}	// Blank initializer
	
	/*
	 * Compute the lowest cost for editing the firstString into the secondString
	 */
	public int compute( String string1, String string2){
		str1 = " " + string1;
		str2 = " " + string2;
		strMatrix = new int[ str1.length()][ str2.length()];
		strMatrix[0][0] = 0;	// Base case
		// Initialize base row and base column
		for( int i=1; i<str1.length(); i++)
			strMatrix[i][0] = strMatrix[i-1][0] +1;
		for( int i=1; i<str2.length(); i++)
			strMatrix[0][i] = strMatrix[0][i-1] +1;
		insert = 1;
		delete = 1;
		replace = 1;
		return computeAlgorithm();
	}
	
	private int computeAlgorithm(){
		for( int i=1; i<strMatrix.length; i++){
			for( int j=1; j<strMatrix[i].length; j++){
				int first = strMatrix[i-1][j] + insert;
				int second = strMatrix[i][j-1] + delete;
				int third = 0;
				if( str1.charAt(i) != str2.charAt( j))
					third = replace;
				strMatrix[i][j] = findMin( first, second, third);
			}
		}
		System.out.print("\t");
		for( int i=0; i<str2.length(); i++){
			System.out.print( str2.charAt( i) + "\t");
		}
		System.out.println("");
		for( int i=0; i<strMatrix.length; i++){
			System.out.print( str1.charAt( i) + "\t");
			for( int j=0; j<strMatrix[i].length; j++){
				System.out.print( strMatrix[i][j] + "\t");
			}
			System.out.println("");
		}
		
		int lastRowIndex = strMatrix.length;
		int lastColumnIndex = strMatrix[0].length;
		return strMatrix[lastRowIndex-1][lastColumnIndex-1];
	}
	
	private int findMin( int num1, int num2, int num3){
		int min = -1;
		if( num1 <= num2 && num1 <= num3)
			min = num1;
		else if( num2 <= num1 && num2 <= num3)
			min = num2;
		else if( num3 <= num1 && num3 <= num2)
			min = num3;
		return min;
	}
	
	public int getEditCostAt( int i, int j){
		return strMatrix[i+1][j+1];
	}
	
	public int getInsertCost(){
		return insert;
	}
	
	public int getDeleteCost(){
		return delete;
	}
	
	public int getReplaceCost(){
		return replace;
	}
}