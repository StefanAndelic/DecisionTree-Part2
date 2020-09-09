package DecisionTree;

public class RemovingElement {
	
	
	
			public static void removeElt( String [] array, int remIndex ){
			   for ( int i = remIndex ; i < array.length - 1 ; i++ ) {
			      array[ i ] = array[ i + 1 ] ; 
			   }
			      
			}

}
