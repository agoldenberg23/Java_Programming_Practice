import java.util.Scanner;
public class Day 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	
		//Ask for and take in the year
		int year = 0;
		do
		{
			System.out.print("Enter year: ");
			year = sc.nextInt();
		} while((year < 1900) || (year > 2100));
		
		
		//Ask for and take in the month
		int month = 0;
		do
		{
			System.out.print("Enter month: ");
			month = sc.nextInt();
		} while((month < 1) || (month > 12));
		
		//Ask for and take in the day
		int day = 0;
		int lastDay = 0;
		do
		{
			System.out.print("Enter day: ");
			day = sc.nextInt();
			
			//set the last day of the month
			switch (month)
			{
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12: lastDay = 31;
						 break;
				case 4:
				case 6:
				case 9:
				case 11: lastDay = 30;
						 break;
				
				//February, check for leap year
				case 2: if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0)))
				{
					lastDay = 29;
				}
				else
				{
					lastDay = 28;
				}
				
			}
		} while ((day < 1) || (day > lastDay));
		
		//Calculate the day of the week
		//Calculation variables
		int a = 0;
		int b = day;
		int y = year;
		
		//Adjusting for start of the year
		if (month > 2)
		{
			a = month - 2;
		}
		else
		{
			a = month + 10;
			y = year - 1;
		}
		
		int c = y % 100;
		int d = y / 100;
		
		//Computation
		int w = (13 * a - 1) / 5;
		int x = c / 4;
		y = d / 4;
		int z = w + x + y + b + c - 2 * d;
		int r = z % 7;
		r = (r + 7) % 7;
		//(r=0)Sunday, (r=1)Monday ...
		
		//Print out results 
		System.out.println();
		
		switch (r)
		{
			case 0: System.out.println("The day is Sunday");
					break;
			case 1: System.out.println("The day is Monday");
					break;
			case 2: System.out.println("The day is Tuesday");
					break;
			case 3: System.out.println("The day is Wednesday");
					break;
			case 4: System.out.println("The day is Thursday");
					break;
			case 5: System.out.println("The day is Friday");
					break;
			case 6: System.out.println("The day is Saturday");
					break;
		}
		
	}

}
