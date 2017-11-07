package combinatorialsearch;

import java.io.BufferedReader;
import java.io.*;

/**
 *
 * @author StephenGung
 */
public final class CombinatorialSearch{
	
	/*
	The compute method takes the name of a text file
	This text file must use the following structure for it to successfully be used:
		The first line denotes the integers in our Universal Set
		Each line afterwards denotes the elements for a set
			This line will have an integer followed by a single space (assume all integers in increasing order)
	ex)
		-----------------
		20
		1 2 3 6 8
		2 4 5
		1 4 7 9
		2 5 9
		-----------------
		In the above example,
		Universal Set = { 1, 2, 3, ....., 20}
		There are 4 sets
		First Set = { 1, 2, 3, 6, 8}
		...
		...
		Last Set = { 2, 5, 9}
	*/
	
	public static int compute( String initTextFile){
		try{
			// Load file
			File file = new File( initTextFile);
			FileReader fileReader = new FileReader( file);
			BufferedReader bufferedReader = new BufferedReader( fileReader);
			
			UniversalSet universalSet = new UniversalSet();
			GroupSet minSetCover = new GroupSet();
			GroupSet setS = new GroupSet();
			
			// First line read denotes the integers in our Universal Set
			universalSet.initializeElements( Integer.parseInt( bufferedReader.readLine()));
			
			String line = null;
			// Read each line until the EOL has been reached
			for( int n=1; (line = bufferedReader.readLine()) != null; n++){
				String[] parsedLine = line.split( "\\s+");
				/*	If an empty subset is found, then it can be ignored
					Since this subset will never be part of the minimum set cover
					This helps improve optimization
				*/
				if( parsedLine.length == 1 && parsedLine[0].equals("")){
					continue;	// Skip to next iteration
				}
				Set tempSet = new Set();
				for ( String tempWord : parsedLine){
					tempSet.add( Integer.parseInt( tempWord));
				}
				/*
				for( int i=0; i<parsedLine.length; i++){
					tempSet.add( Integer.parseInt( parsedLine[i]));
				}
				*/
				tempSet.setID( n);
				setS.add( tempSet);
			}
			fileReader.close();
			bufferedReader.close();
			/*
			System.out.print( "Universal Set: ");
			for( int i=0; i<universalSet.size(); i++){
				System.out.print( universalSet.get( i) + " ");
			}
			System.out.println("");
			
			for( int i=0; i<setS.size(); i++){
				Set tempSet = setS.getSetAt( i);
				for( int j=0; j<tempSet.size(); j++){
					System.out.print( tempSet.get(j) + " ");
				}
				System.out.println("");
			}
			*/
		}
		//catch( Exception e)				{	e.printStackTrace();	}
		catch( FileNotFoundException e)	{	e.printStackTrace();	}
		catch( IOException e)			{	e.printStackTrace();	}
		
		/*
		Ideas for optimization:
			Remove all sets that are subsets of some other
			Automatically add sets that have a unique element; thus these sets must belong in the min set cover
			
		*/
		
		
		
		
		return 1;
	}
	
}