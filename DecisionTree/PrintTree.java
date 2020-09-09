package DecisionTree;

public class PrintTree {

	/**
	 * 
	 * 
	 * @param DecisionTreeNode
	 * performs the recursive printing of the decision tree 
	 *traverses the left and right side 
	 */
	public static void TreeTraversal(String indent, DecisionTreeNode node) {
	
		
	    if (node.left == null && node.right == null) {
	    	if(node.className == null) {
	    		node.className = Parser.classnames[0];
	    		
	    	}
	    	indent = indent + " ";
	    //System.out.println(indent + "Category:" + node.className);  
	    
	      return;
	    }
	    indent = indent + " ";
	    
	    //System.out.println(indent + node.className + " = False" );
	    TreeTraversal(indent , node.left);
	    //indent = indent + " ";
	    
	    
	    //System.out.println(indent + node.className + " = True");
	    TreeTraversal(indent, node.right);
 	   indent = indent + " ";
 
	   
	  }
}
