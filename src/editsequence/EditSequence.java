package editsequence;

/**
 * NOT COMPLETED
 * @author StephenGung
 */
public class EditSequence{
	private String firstString;
	private String secondString;
	private int[][] stringMatrix;
	private int insert;
	private int delete;
	private int replace;
	
	public EditSequence(){}	// Blank initializer
	
	/*
	 * Compute the lowest cost for editing the firstString into the secondString
	 */
	public int compute( String initFirstStr, String initSecondStr){
		firstString = " " + initFirstStr;
		secondString = " " + initSecondStr;
		stringMatrix = new int[ firstString.length()][ secondString.length()];
		stringMatrix[0][0] = 0;	// Base case
		// Initialize base row and base column
		for( int i=1; i<firstString.length(); i++)	stringMatrix[i][0] = stringMatrix[i-1][0] +1;
		for( int i=1; i<secondString.length(); i++)	stringMatrix[0][i] = stringMatrix[0][i-1] +1;
		insert = 1;
		delete = 1;
		replace = 1;
		return computeAlgorithm();
	}
	
	private int computeAlgorithm(){
		
		for( int i=1; i<stringMatrix.length; i++){
			for( int j=1; j<stringMatrix[i].length; j++){
				int first = stringMatrix[i-1][j] + insert;
				int second = stringMatrix[i][j-1] + delete;
				int third = 0;
				if( firstString.charAt(i) != secondString.charAt( j))
					third = replace;
				stringMatrix[i][j] = findMin( first, second, third);
			}
		}
		System.out.print("\t");
		for( int i=0; i<secondString.length(); i++){
			System.out.print( secondString.charAt( i) + "\t");
		}
		System.out.println("");
		for( int i=0; i<stringMatrix.length; i++){
			System.out.print( firstString.charAt( i) + "\t");
			for( int j=0; j<stringMatrix[i].length; j++){
				System.out.print( stringMatrix[i][j] + "\t");
			}
			System.out.println("");
		}
		
		int lastRowIndex = stringMatrix.length;
		int lastColumnIndex = stringMatrix[0].length;
		return stringMatrix[lastRowIndex-1][lastColumnIndex-1];
	}
	
	private int findMin( int initFirst, int initSecond, int initThird){
		int min = -1;
		if( initFirst <= initSecond && initFirst <= initThird)			min = initFirst;
		else if( initSecond <= initFirst && initSecond <= initThird)	min = initSecond;
		else if( initThird <= initFirst && initThird <= initSecond)		min = initThird;
		return min;
	}
	
	
	public int getEditCostAt( int initI, int initJ)	{	return stringMatrix[initI+1][initJ+1];	}
	public int getCostOfInsert()	{	return insert;	}
	public int getCostOfDelete()	{	return delete;	}
	public int getCostOfReplace()	{	return replace;	}
}