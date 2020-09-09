package DecisionTree;

public class Test {
public static DecisionTreeNode n = Main.root;
//static DecisionTreeNode n = Report.root;
static double accuracy = 0;
	
	public static void compare() {
		
		int position = 74;
		int correct = 0;
		String rezultat = null;
		
			
		for(int t = 0; t < Parser.test.size(); t++) {
			DecisionTreeNode node = new DecisionTreeNode();
			node = n;
			String[] temp = Parser.test.get(t);
					
			while(node != null) {
				
				for(int b = 0; b < Parser.testattributeslist.size(); b++) {
					if(Parser.testattributeslist.get(b).equals(node.className)) {
						
						 position = b;
						
					}
				}
				
				rezultat = node.className;
				//System.out.println(position);
				if(temp[position+1].equals("true")) {
					
					
					node = node.right;
					
				}
				else {
				
					node = node.left;
					
					
				}
				
			}//while
		
			
			
			if(temp[0].equals(rezultat)) {
				correct++;
				
			}
			
			
		}
		
		
		accuracy =((double)correct/Parser.test.size()*100);
		//System.out.println("Accuracy of the DecisionTree based on input files is :" + " " + accuracy + "%"));
		
		//System.out.println("number of correct answers is:" + correct);
	}
}
