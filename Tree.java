package huffman;

import java.util.ArrayList;

public class Tree {
	static Node root = new Node();
	ArrayList<String> shortcode = new ArrayList<String>();
	public Tree() {
		root.weight=0;
		root.count=0;
		root.charNode="";
		root.left=null;
		root.right=null;
		root.parent=null;
	}
	public static void update (Node mynode) {
		Node tmp1=new Node();
		Node tmp2=new Node();
		tmp1=mynode;
		tmp1=tmp1.parent;
		while (tmp1.parent.charNode!="") {
			tmp1=tmp1.parent;
			tmp1=tmp1.right;
			if (tmp1.count<=mynode.count) {
				tmp2=mynode.parent;
				tmp2.right=tmp1;
				tmp2=tmp2.parent;
				tmp2.right=mynode;
				mynode.parent=tmp2;
			}
		}
		
		
	}
	public static void addElement (String element) {
		Node temp = new Node();
		temp = root;
		for (int i = 0 ;i < element.length(); i++) {
			String mychar = "";
			mychar=element.substring(i, i+1);

		while (temp.left.charNode!="NYT") {
			if (temp.charNode=="") {  //root
				Node right = new Node();
				Node left = new Node();
				 right.charNode=mychar;
				 right.count++;
				 left.charNode="NYT";
				 left.count=0;
				 root.right=right;
				 root.left=left;
				 right.parent=root;
				 left.parent=root;
				 System.out.println(right.charNode + left.charNode);
				
		}
			
		
		
		else {
			temp=Search(mychar);
			if (temp.charNode==mychar) {
				update(temp);
				temp.count++;
				
			
			while (temp.parent.charNode=="" || temp.parent.charNode=="NYT")
			
			{
				temp=temp.parent;
				temp.count++;
			}
			}
			else if (temp.charNode=="NYT") {
				
				Node right = new Node();
				Node left = new Node();
				temp.right=right;
				temp.left=left;
				right.parent=temp;
				left.parent=temp;
				right.charNode=mychar;
			}
				
			}
		
		
		}
	}
		//Node.printTree(root);
		}

	public static Node Search (String myword) {
		Node temp = new Node();
		temp= root;
	
		while(temp.right!=null || temp.left!=null) {
			if (temp.right.charNode==myword) {
				temp=temp.right;
				break;	
			}
			else if (temp.left.charNode==myword) {
				temp=temp.left;
				break;	
			}
			else if (temp.right.right!=null && temp.right.left!= null) {
				temp=temp.right;
			}
			else {
				temp = temp.left;
			}
		
		
		
	}
		return temp;}

    public static void printTree()  {
    	Node n = new Node();
    	n=root;
        if (n.right != null) {
            n.right.printTree(n);
        }
        System.out.println(n.charNode + " ");
        if (n.left != null) {
            n.printTree(n);
        }
    }
}
