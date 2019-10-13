import java.util.Scanner;

//Converts input to expression tree and tree to prefix, infix and postfix. Also contains main (user input)
public class ExpressionTreeConverter {
	
	public static void main(String[] args)
	{
		//Create scanner, infix to postfix converter and postfix to expression tree converter
		Scanner sc = new Scanner(System.in);
		InfixToPostfixCon inToPost = new InfixToPostfixCon();
		postfixToExpressionTreeCon postToTree = new postfixToExpressionTreeCon();
		
		while(true)
		{
			//Input Infix Expression
			System.out.print("Enter infix equation (or end to exit the program): ");
			String line = sc.nextLine();
			if(line.equals("end") || line.equals("End")){ break; }		//End the program if "end" or "End"
			
			//Convert input to postfix singly linked list (String)
			inToPost.toPostfix(line);
			
			//Convert postfix to expression tree
			postToTree.convert(inToPost.getOutput());
		
			System.out.print("Prefix: ");
			postToTree.getOutput().prefix();
			System.out.println();
			
			System.out.print("Infix: ");
			postToTree.getOutput().infix();
			System.out.println();
			
			System.out.print("Postfix: ");
			postToTree.getOutput().postfix();
			System.out.println();
			
			System.out.println();
		}
	}
}
