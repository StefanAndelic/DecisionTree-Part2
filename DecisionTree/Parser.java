package DecisionTree;


	
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;

	
	public class Parser {

	public static ArrayList <String[]> test = new ArrayList<String[]>();    
	public static ArrayList <String[]> training = new ArrayList<String[]>();               // list of all the instances 
	public static ArrayList <String> attributeslist = new ArrayList<String>();					// list of all 16 attributes 
	public static ArrayList <String> testattributeslist = new ArrayList<String>();	
	public static String [] temp;
	public static int outcomecounterpositive = 0;
	public static int outcomecounternegative = 0;
	public static String mostprobable;
	public static String[] classnames;
	public static int testnumber = 0;


	
	public static void loadtraining(String filename) {
		
		String line;
		String header;
		String attributes;
		
		try {
		
			BufferedReader br = new BufferedReader(new FileReader(filename));

		// reads the header classes 
		header = br.readLine();
		classnames = header.split("\t");
			
		// reads in the attributes line and adds to the list  
		attributes = br.readLine();
		String[] att = attributes.split("\t");
		
		for(int l = 0; l < att.length; l++) {
		
			attributeslist.add(att[l]);
		}
		
			
		while ((line = br.readLine()) != null) {
			// reads each instance line and adds to the list 
			String[] values = line.split("\t");		
			if(values[0].equals("live")) {
				outcomecounterpositive++;
				
			}
			else {
				
				outcomecounternegative++;
			}
			
							
			
			training.add(values); // adds the instances to the list 
					
		}
		
		
		br.close();
	}
		catch(IOException e) {
			
			
		e.printStackTrace();
		
		
		}

		 
		 if(outcomecounterpositive > outcomecounternegative ) {
			 
			 mostprobable = classnames[0];
			 
		 }
		 else {
			 
			 mostprobable = classnames[1];
		 }
		 

	}


	public static void loadtest(String filename) {
		
		String line;
		String header;
		String attributes;
		
		try {
		
			BufferedReader br = new BufferedReader(new FileReader(filename));

		// reads the header classes 
		header = br.readLine();
		classnames = header.split("\t");
		
		
		attributes = br.readLine();
		String[] att = attributes.split("\t");
		
		for(int l = 0; l < att.length; l++) {
		
			testattributeslist.add(att[l]);
		}
		
		
			
		while ((line = br.readLine()) != null) {
			// reads each instance line and adds to the list 
			String[] values = line.split("\t");	
					
			
			test.add(values); // adds the instances to the list 
			
			
		}
		
		
		
		
		br.close();
	}
		catch(IOException e) {
			
			
		e.printStackTrace();
		
		
		}
		
		
	}


}
