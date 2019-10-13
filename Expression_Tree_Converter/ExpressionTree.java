//An expression tree made to take strings as elements
//Includes the methods infix, prefix and postfix
//Cannot remove elements from the list
public class ExpressionTree
{
	//The node class used by the tree
	class Node
	{
		String element;		//Holds the element
		Node left;			//The left child
		Node right;			//The right child
    
		//Create a node without a left or right child
		public Node (String s)
		{
			this (s, null, null);
		}

		//Create a node with a left and right child
		public Node (String s, Node l, Node r)
		{
			element = s;
			left = l;
			right = r;
		}

		//Return the element
		public String toString()
		{
			return element;
		}
	}
	

		//The root node starting the tree
		private Node root = new Node(null);
		
		//Create a default tree
		public ExpressionTree() { }
		
		//Create a new tree and set the root equal to a node
		public ExpressionTree(Node n)
		{
			root = n;
		}
		
		//Create a new tree and set the roots element
		public ExpressionTree(String n)
		{
			root.element = n;
		}
		
		//Get the root node
		public Node getRoot()
		{
			return root;
		}
		
		//Set the element of the root
		public void setRoot(String s)
		{
			root.element = s;
		}
		
		//Add a left child with element s at node n
		public void setLeft(Node n, String s)
		{
			n.left =  new Node(s);
		}
    
		//Add a right child with element s at node n
		public void setRight(Node n, String s)
		{
			n.right =  new Node(s);
		}
		
		//Set the right child of node n to node add
		private void setRight(Node n, Node add)
		{
			n.right = add;
		}
		
		//Set the left child of node n to node add
		private void setLeft(Node n, Node add)
		{
			n.left = add;
		}
    
		//Driver for the infix method
		public void infix()
		{
			if(root.element != null)
				infix(root);
			else
				System.out.print("[Empty Tree]");
		}
    
		//Infix representation of the expression tree by use of recursive inorder traversal
		private void infix(Node n)  
		{
			//Go down left most nodes till end first
			if(n.left != null)
			{
				System.out.print("( "); 		//Needed for infix notation
				infix(n.left);
			}
			
			//Visits root in the middle
			System.out.print(n + " ");
			
			//Then visit right most nodes
			if(n.left != null)
			{
				infix(n.right);
				System.out.print(") ");		//Needed for infix notation
			}
		}

		//Driver for postfix method
		public void postfix()
		{
			if(root.element != null)
				postfix(root);
			else
				System.out.print("[Empty Tree]");
		}
    
		//Postfix representation of the expression tree by use of recursive postorder traversal
		private void postfix(Node n)
		{
			if(n != null)
			{
				if(n.left != null)
					postfix(n.left);
				
				if(n.right != null)
					postfix(n.right);
				
				System.out.print(n + " ");
			}
		}
		
		//Driver for prefix method
		public void prefix()
		{
			if(root.element != null)
				prefix(root);
			else
				System.out.print("[Empty Tree]");
		}
		
		//Prefix representation of the expression tree by use of recursive preorder traversal
		private void prefix(Node n)
		{
			if(n != null)
			{
				System.out.print(n + " ");
				
				if(n.left != null)
					prefix(n.left);
				
				if(n.right != null)
					prefix(n.right);
			}
		}
}