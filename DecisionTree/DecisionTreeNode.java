package DecisionTree;


	public class DecisionTreeNode {

		
		public DecisionTreeNode  left , right;
		String className;

		public DecisionTreeNode(String className, DecisionTreeNode rigthnode, DecisionTreeNode leftnode) {
			
		this.right = rigthnode;
		this.left = leftnode;
		this.className = className;


			
		}

		// empty constructor,easier for initialising the tree  
		public DecisionTreeNode() {
				
		}	
			
			
		public 	DecisionTreeNode getLeft() {
			
			return this.left;
			
		}
			
		public 	DecisionTreeNode getRight() {
			
			return this.right;
			
		}


		public 	String getAttribute() {
			
			return this.className;
			
		}


		 
		public String  toString() {
			
			return this.left + " " + this.right + " " + this.className;
		}
	}
		
			

