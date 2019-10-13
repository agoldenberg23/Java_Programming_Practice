import java.util.Scanner;
public class Hailstone
{
	public static void main(String[] args)
	{
		//Create the scanner and integers
		Scanner sc = new Scanner(System.in);
		int start = 0;		//start of range
		int end = 0;		//end of range
		int cyclen = -1;	//the number with the largest number of cycles
		int cyclel = -1;	//the number of cycles of the above number
		
		do
		{
			//Take in the starting and ending ranges
			System.out.print("Enter starting and ending number of the range: ");
			start = sc.nextInt();
			System.out.print(" ");
			end = sc.nextInt();
		} while (start < 0 || end <= 0 || start >= end);
		
		//Go through the given range
		for (int num = start; num <= end; num++)
		{
			int seq = num;			//Editable version of the number
			int newcycle = 0;		//Count of the number of cycles
			
			//Go through the series until the number = 1
			while (seq != 1)
			{
				if (seq % 2 == 0)			//even number
				{
					seq = seq/2;
				}
				else if (seq % 2 != 0)		//odd numbers
				{
					seq = (3 * seq + 1);
				}
				newcycle++;
			}
			
			//Change the highest number of cycles if the computed one took more cycles
			if (newcycle > cyclel)
			{
				cyclel = newcycle;
				cyclen = num;
			}
		}
		
		//Print results
		System.out.println();
		System.out.println("The number " + cyclen + " has the longest cycle length of " + cyclel + ".");

	}
}
