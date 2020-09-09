package DecisionTree;

import DecisionTree.Test;
public class Main {
	
	public static DecisionTreeNode root;
	static String filename1;
	static String filename2;
	
	
		
    //static String path = "src\\DecisionTree\\testing\\";
    
    
    public static void main (String [] args) {
    	
    	System.out.println("Please enter hepatitis-training-run and hepatitis-test-run as command line arguments");
    	
    	if(args.length < 2) {
    	
    		System.out.println("Please enter two files into the command line");
    	
    	}
    	else{
    	
    	 filename1 = args[0];
    	 filename2 = args[1];
    	}
    	
    	
    	/*String file1 = "hepatitis-training-run";
    	String file2 = "hepatitis-test-run";*/
    	
    	String file1 = args[0];
    	String file2 = args[1];
    	    	
    	double result = 0;
    	for(int i = 1; i < 11; i ++) {
    	filename1 = file1 + i +".dat";
    	filename2 = file2 + i +".dat";
    	
    	root = new DecisionTreeNode();					// initialises the root node
       	Parser.loadtraining(/*path +*/ filename1);              // loads training    	
    	root = BuildTree.buildTree(Parser.training, Parser.attributeslist);			// calls buildTree starting with the root
       	PrintTree.TreeTraversal("", root);		// prints the tree from the root
		Parser.loadtest(/*path +*/ filename2); 						// loads test 
		Test.compare();
		result = result +Test.accuracy;
		//System.out.println(result);
		Parser.attributeslist.clear();
    	Parser.testattributeslist.clear();
    	Parser.training.clear();
    	Parser.test.clear();
    	root = null;
    	}
    	
    	result = result/10;
    System.out.println("The average accuracy of the classifiers over the 10 trials is:" + result + "%");

    	
    
    }
   
    
}
