package DecisionTree;

import java.util.ArrayList;

import DecisionTree.Parser;
import DecisionTree.DecisionTreeNode;
import DecisionTree.RemovingElement; 


	public class BuildTree {

		
	   
		public static DecisionTreeNode buildTree(ArrayList<String[]> instance,  ArrayList <String> attributes) {
			 DecisionTreeNode n = new DecisionTreeNode();
			 ArrayList <String[]> bestAttributeTrue = new ArrayList<String[]>();
			 ArrayList <String[]> bestAttributeFalse = new ArrayList<String[]>();
			 String bestatt;
			 double bestargument = 999999999.0;
			 int purity = 0;
			 double calculation1;
			 int cancelledattributes = -1;
			 int numberoftrue = 0;
			 int numberoffalse = 0;
			 int numberofpostrue = 0;
			 int numberofnegtrue = 0;
			 int numberofposfalse = 0;
			 int numberofnegfalse = 0;
			 int majority1 = 0;
			 int majority2 = 0;
			 String majorityclass;
		     double calculation = 99999;
		     DecisionTreeNode left = new DecisionTreeNode();
		     DecisionTreeNode right = new DecisionTreeNode();
		     DecisionTreeNode node = new DecisionTreeNode();
			
			
			
			for(int l = 0;  l < instance.size(); l++) {
				Parser.temp = instance.get(l);
				
				if(Parser.temp[0].equals(Parser.classnames[0])) {
				
					purity ++;


				}
		}
			
		if(instance.isEmpty()) {
				
				n.left = null;
				n.right = null;
				n.className = Parser.mostprobable;
				return n;
			
			}
			
				
		else if(purity == instance.size() || purity == 0) {
			
			if(purity == instance.size()) {
			n.left = null;
			n.right = null;
			n.className = Parser.classnames[0];
			return n;
			}
			else {
				n.left = null;
				n.right = null;
				n.className = Parser.classnames[1];
				return n;
			}
		}
			
			
			

		else if(attributes.isEmpty()) {
			
			for(int k = 0;  k < instance.size(); k++) {
				Parser.temp = instance.get(k);
				
				if(Parser.temp[0].equals(Parser.classnames[0])) {
					
					majority1 ++;
					
				}
				else {
					
					
					majority2++;
				}
					
			
		}


			if(majority1 > majority2) {
				
				majorityclass = Parser.classnames[0];
				
			}
			else {
				
				majorityclass = Parser.classnames[1];
			}
			
			n.left = null;
			n.right = null;
			n.className = majorityclass;
			
			

		}

		else {
			
			
			
			for(int at = 0; at < attributes.size(); at++) {
				
				//System.out.println(attributes.size());
				numberoftrue = 0;
				numberoffalse = 0;
				numberofpostrue = 0;
				numberofposfalse = 0;
				numberofnegfalse = 0;
				numberofnegtrue = 0;
				
				
				for(int inst = 0; inst < instance.size(); inst++) {
					Parser.temp = instance.get(inst);
					//System.out.println(temp[at+1]);
					if(Parser.temp[at+1].equals("true")) {
						numberoftrue++;
						
						if(Parser.temp[0].equals(Parser.classnames[0])) {
							
								numberofpostrue++;
								/*System.out.println(numberofpostrue);
								System.out.println(temp[0]);*/
															
						}
						else {
							
							numberofposfalse++;
							
							/*System.out.println(numberofposfalse);
							System.out.println(temp[0]);*/
							
						}
						
					}
					
				else if(Parser.temp[at+1].equals("false")){
					
					numberoffalse++;
					
					if(Parser.temp[0].equals(Parser.classnames[1])) {
						
						numberofnegfalse++;
					}
					else {
						
						numberofnegtrue++;
					}
					
				
					}
					
					
					
					
					
					
				} 
				
						
			if(numberoftrue > 0) {
			
			calculation= 2*(numberoftrue/instance.size())*(numberofpostrue/numberoftrue)*(numberofposfalse/numberoftrue);
		
			}
				
			//System.out.println(calculation);
				
				
			if(numberoffalse > 0) {
			calculation1 = 2*(numberoffalse/instance.size())*(numberofnegfalse/numberoffalse)*(numberofnegtrue/numberoffalse);
			
			calculation += calculation1;

				
			}
			/*System.out.println(calculation);
			System.out.println(attributes.get(at));*/
				
			if(calculation < bestargument ) {
			bestargument = calculation;
			//System.out.println(bestargument);
			cancelledattributes = at;
			
			}
			//System.out.println(instance.size());
						
		}
			
			/*System.out.println(cancelledattributes);
			System.out.println(attributes.size());
			*/
			bestatt = attributes.get(cancelledattributes);
			
			attributes.remove(cancelledattributes);
			//System.out.println(bestatt);
			
			for(int inst = 0; inst < instance.size(); inst++) {
				Parser.temp = instance.get(inst);
				
			if(Parser.temp[cancelledattributes+1].equals("true")) {

				RemovingElement.removeElt(Parser.temp, cancelledattributes+1);
				
				bestAttributeTrue.add(Parser.temp);
					
					
			}

			else if(Parser.temp[cancelledattributes+1].equals("false")){

			RemovingElement.removeElt(Parser.temp, cancelledattributes+1);
				
			bestAttributeFalse.add(Parser.temp);

			}


			}

			
			left = buildTree(bestAttributeFalse,attributes);
			right = buildTree(bestAttributeTrue,attributes);
			
			
			
			node.className = bestatt;
			node.left = left;
			node.right = right;
			
		} 


		return node;


		}
}
