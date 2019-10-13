//Input singly linked list <String> postfix expression is converted to an expressionTree
//Expected input created by InfixToPostfixCon.java
public class postfixToExpressionTreeCon {
	
	//Stack used in the conversion
	private static LinkedStack<ExpressionTree> stack = new LinkedStack<ExpressionTree>();
	
	//The input singly linked list
	private static SinglyLinkedList<String> input = new SinglyLinkedList<String>();
	
	//The output tree
	public static ExpressionTree output = new ExpressionTree();
	
	//Set the input string
	private void setInput(SinglyLinkedList<String> in)
	{
		input = in;
	}
	
	//Remove all elements from the stack
	private void emptyStack()
	{
		while(stack.isEmpty() == false)
		{
			stack.pop();
		}
	}
	
	//Remove output tree
	private void emptyOutput()
	{
		if(output.getRoot().element != null)
		{
			output.getRoot().left = null;
			output.getRoot().right = null;
			output.setRoot(null);
		}
	}
	
	//Get the last output
	public ExpressionTree getOutput()
	{
		return output;
	}

	//Checks if a character is a number
	public boolean isNum(String s)
	{
		boolean result = true;
	    switch (s)
	    {
	    	case "+":
	    	case "-": 
	    	case "*":
	    	case "/":
	    	case "^":
	    	case "(": 
	    	case ")": result = false;
	    }
	    return result;
	}
	
	//Make a new tree and push it onto the stack
	private void numAdd(String s)
	{
		ExpressionTree newest = new ExpressionTree(s);
		stack.push(newest);
	}
	
	//Create a new tree with the operator as the root, set operands and then push onto stack
	private void opAdd(String s)
	{
		ExpressionTree newest = new ExpressionTree(s);
		newest.getRoot().right = stack.pop().getRoot();
		newest.getRoot().left = stack.pop().getRoot();
		stack.push(newest);
	}
	
	//Converts the input to the output tree
	public ExpressionTree convert(SinglyLinkedList<String> in)
	{
		//Set the input
		setInput(in);
		
		//Empty stack and output from any previous uses
		emptyStack();
		emptyOutput();
		
		String element;		//String to hold currently looked at element
		
		//Go through every element of the input list
		while(input.isEmpty() != true)
		{
			element = input.removeFirst();
			
			if(isNum(element) == false)
			{
				//For operators, create a tree with the operator and two numbers from stack
				opAdd(element);
			}
			else
			{
				//For numbers, create a new node and add it to the stack
				numAdd(element);
			}
		}
		
		//Push finished tree of the stack and set the output
		output = stack.pop();
		
		return output;
	}
}
