
//Takes in any String input and converts it to a postfix notation, removing unwanted elements
public class InfixToPostfixCon {
		
		//Stack used in the conversion to postfix
		private static SinglyLinkedList<String> converter = new SinglyLinkedList<String>();
		
		//The input from the user that will be altered
		private static String input = "";
		
		//The output string
		public static SinglyLinkedList<String> output = new SinglyLinkedList<String>();
		
		//Set the input string
		private void setInput(String in)
		{
			input = in;
		}
		
		//Remove all elements from the converter stack
		private void emptyConverter()
		{
			while(converter.isEmpty() == false)
			{
				converter.removeFirst();
			}
		}
		
		//Remove the first element of the input string
		private void removeFirst()
		{
			input = input.substring(1);
		}
		
		//Remove all elements from the output string
		private void emptyOutput()
		{
			while(output.isEmpty() == false)
			{
				output.removeFirst();
			}
		}
		
		//Get the last output
		public SinglyLinkedList getOutput()
		{
			return output;
		}
		
		//Gives a numerical representation of an operators importance, 10 if not an operator
		private int operatorImport(String c)
	    {
			if(c.equals(")"))
			{
				return 1;
			}
			
			if(c.equals("+") || c.equals("-"))
			{
				return 2;
			}
			
			if(c.equals("*") || c.equals("/"))
			{
				return 3;
			}
			
			if(c.equals("^"))
			{
				return 4;
			}
			
			if(c.equals("("))
			{
				return 0;
			}
			
	        return 10;
	    }
		
		//Checks if a character is a number
		public boolean isNum(char ch)
		{
			boolean result = false;
		    switch (ch)
		    {
		    	case '1':
		    	case '2': 
		    	case '3':
		    	case '4':
		    	case '5':
		    	case '6': 
		    	case '7':
		    	case '8':
		    	case '9':
		    	case '0':result = true;
		    }
		    return result;
		}
		
		//Checks if a character is valid
		public boolean isValid(char ch)
		{
			boolean result = false;
		    switch (ch)
		    {
		    	case '1':
		    	case '2': 
		    	case '3':
		    	case '4':
		    	case '5':
		    	case '6': 
		    	case '7':
		    	case '8':
		    	case '9':
		    	case '0':
		    	case '+': 
		    	case '-':
		    	case '*':
		    	case '/': 
		    	case '^':
		    	case '(':
		    	case ')': result = true;
		    }
		    return result;
		}
		
		//Remove any spaces and invalid characters from a given string
		public String removeInvalid(String input)
		{
			String output = "";
			
			for(int c = 0; c <= input.length()-1; c++)
			{
				if(input.charAt(c) != ' ' && isValid(input.charAt(c)))
				{
					output += input.charAt(c);
				}
			}
			return output;
		}
		
		//Converts a string into a singly linked list <String> postfix notation
		public SinglyLinkedList<String> toPostfix(String in)
		{
			setInput(removeInvalid(in));		//Sets the input string and removes the unwanted elements
			emptyConverter();					//Empty from any previous uses
			emptyOutput();
			
			int count = 1;					//Counter used later in the code
			
			//Go through the input string each char
			while(input.length() > 0)
			{
				//If a numeric char, add to output
				if(isNum(input.charAt(0)))
				{
					//If the number is more then one digit
					while(input.length() > count && isNum(input.charAt(count)))
					{
						count++;
					}
					output.addLast(input.substring(0,count));
					while(count != 1)
					{
						removeFirst();
						count--;
					}
				}
				
				//If an operator
				else
				{
					//Nothing in converter or next operator is of higher importance then top of converter stack
					if(converter.isEmpty() || (operatorImport(input.substring(0,1)) > operatorImport(converter.first())))
					{
						converter.addFirst(input.substring(0,1));
					}
					
					//Next character is a (
					else if(converter.isEmpty() == false && operatorImport(input.substring(0,1)) == 0)
					{
						converter.addFirst(input.substring(0,1));
					}
					
					//Next operator is of lower or equal importance then top of converter stack (not '(')
					else if(converter.isEmpty() == false && operatorImport(input.substring(0,1)) <= operatorImport(converter.first()) && operatorImport(input.substring(0,1)) != 0)
					{
						int importance = operatorImport(converter.first());
						
						if(operatorImport(input.substring(0,1)) == 1) //If next is a ')', push all until a '('
						{
							importance = 10;
						}
						
						//Push from stack onto output until higher importance or a (
						while(converter.size() != 0 && importance >= operatorImport(converter.first()) && operatorImport(converter.first()) != 0)
						{
							output.addLast(converter.removeFirst());
						}
						if(converter.isEmpty() == false && operatorImport(converter.first()) == 0 && importance == 10)			//Remove '(' after a use of ')'
						{
							converter.removeFirst();
						}
						converter.addFirst(input.substring(0,1));
						if(operatorImport(converter.first()) == 1)		//Do not ad ')' to stack
						{
							converter.removeFirst();
						}
					}
				}
			removeFirst();
			}
			
			while(converter.isEmpty() == false)
			{
				output.addLast(converter.removeFirst());
			}
			
			return output;
		}
		
}
