import java.util.*;
import java.io.*;

public class Consonant
{
	public static int maxAscending (String str)
	{
		//Return the maximum ascending run of consonants
		if (str.length() == 1)
		{
			return 1;
		}
		int maxTemp = 1;		//The length
		int max = 0;			//The max length
		for (int c = 1; c < str.length(); c++)
		{
			char ch1 = str.charAt(c - 1);
			char ch2 = str.charAt(c);
			if (ch1 >= ch2)
			{
				maxTemp++;
			}
			if (ch1 < ch2)
			{
				maxTemp = 1;
			}
			
			if(maxTemp > max)
			{
				max = maxTemp;
			}
		}
		return max;
	}
	
	public static int maxDescending (String str)
	{
		//Return the maximum descending run of consonants
		if (str.length() == 1)
		{
			return 1;
		}
		int maxTemp = 1;		//The length
		int max = 0;			//The max length
		for (int c = 1; c < str.length(); c++)
		{
			char ch1 = str.charAt(c - 1);
			char ch2 = str.charAt(c);
			if (ch1 <= ch2)
			{
				maxTemp++;
			}
			if (ch1 > ch2)
			{
				maxTemp = 1;
			}
			
			if(maxTemp > max)
			{

				max = maxTemp;
			}
		}
		return max;
	}
	  
	public static int maxRun (String str)
	{
		//Return the length of the longest run
		int maxAsc = maxAscending (str);
	    int maxDesc = maxDescending (str);
	    int maxRun = -1;
	    if (maxAsc > maxDesc)
	    {
	    	maxRun = maxAsc;
	    }
	    else
	    {
	    	maxRun = maxDesc;
	    }
	    return maxRun;
	}
	
	public static boolean isConsonant (char ch)
	{
		//Returns true if the character is a consonant and false if not
	    boolean result = false;
	    switch (ch)
	    {
	    	case 'b':
	    	case 'c': 
	    	case 'd':
	    	case 'f':
	    	case 'g':
	    	case 'h': 
	    	case 'j':
	    	case 'k':
	    	case 'l':
	    	case 'm':
	    	case 'n': 
	    	case 'p':
	    	case 'q':
	    	case 'r':
	    	case 's': 
	    	case 't':
	    	case 'v':
	    	case 'w':
	    	case 'x':
	    	case 'y':
	    	case 'z': result = true;
	    }
	    return result;
	}
	
	public static String filterString (String str)
	{
		//Turns the input string into consonants
	    String temp = ""; 				//Empty string to store consonants
	    for (int i = 0; i < str.length(); i++)
	    {
	    	char ch = str.charAt(i);	//Character at index i
	    	
	    	//If the character is a consonant, add to temp
	    	if (isConsonant (ch))
	    	{
	    		temp += ch;
	    	}
	    }
	    return temp;
	}

	public static void main (String[] args) throws IOException
	{
		// Open file
	    File inFile = new File ("./consonant.txt");

	    // Create Scanner
	    Scanner sc = new Scanner (inFile);

	    // Read the number of lines that need to be read
	    String numStr = sc.nextLine();				//Number of lines
	    int numLines = Integer.parseInt (numStr);

	    // Read all lines of input
	    for (int n = 0; n < numLines; n++)
	    {
	    	String line = sc.nextLine();		// The line being used
	    	line = line.toLowerCase();
	    	String Str2 = filterString (line);	//Filtered version of the string
	    	System.out.println (maxRun(Str2));	//Find the maximum run
	    }

	    // Close the file
	    sc.close();

	}
}
