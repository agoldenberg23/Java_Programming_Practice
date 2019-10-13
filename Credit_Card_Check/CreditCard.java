import java.util.Scanner;
public class CreditCard
{
	public static void main(String[] args)
	{

		long num = 0;		//The credit card number

		//Create scanner
		Scanner sc = new Scanner(System.in);

		//Input credit card number
		System.out.print("Enter 15 or 16-digit credit card number: ");
		num = sc.nextLong();

		System.out.println();		//Extra space
		
		//Check if the number is between 15 or 16 digits long
		long minNum = (long) Math.pow(10,14);	//Minimum 15 digit number
		long maxNum = (long) Math.pow(10,16);	//Minimum 17 digit number
		if (num < minNum || num >= maxNum)
		{
			System.out.print("Not a 15 or 16-digit number");
			return;
		}

		//Save each digit separately and multiply every other by 2
		int d0 = (int) (num % 10);
		int d1 = ((int) (num % 100 / 10)) * 2;
		int d2 = (int) (num % 1000 / 100);
		int d3 = ((int) (num % 10000 / 1000)) * 2;
		int d4 = (int) (num % 100000 / 10000);
		int d5 = ((int) (num % 1000000 / 100000)) * 2;
		int d6 = (int) (num % 10000000 / 1000000);
		int d7 = ((int) (num % 100000000 / 10000000)) * 2;
		int d8 = (int) (num % 1000000000 / 100000000);
		int d9 = ((int) (num % Math.pow(10,10) / Math.pow(10,9))) * 2;
		int d10 = (int) (num % Math.pow(10,11) / Math.pow(10,10));
		int d11 = ((int) (num % Math.pow(10,12) / Math.pow(10,11))) * 2;
		int d12 = (int) (num % Math.pow(10,13) / Math.pow(10,12));
		int d13 = ((int) (num % Math.pow(10,14) / Math.pow(10,13))) * 2;
		int d14 = (int) (num % Math.pow(10,15) / Math.pow(10,14));
		int d15 = ((int) (num % Math.pow(10,16) / Math.pow(10,15))) * 2;

		//If multiplying above by 2 is larger then 9, subtract 9
		if (d1 > 9)
		{
			d1 = d1 - 9;
		}
		if (d3 > 9)
		{
			d3 = d3 - 9;
		}
		if (d5 > 9)
		{
			d5 = d5 - 9;
		}
		if (d7 > 9)
		{
			d7 = d7 - 9;
		}
		if (d9 > 9)
		{
			d9 = d9 - 9;
		}
		if (d11 > 9)
		{
			d11 = d11 - 9;
		}
		if (d13 > 9)
		{
			d13 = d13 - 9;
		}
		if (d15 > 9)
		{
			d15 = d15 - 9;
		}

		//Sum all the digits after modifications
		int sum = d0 + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10 + d11 + d12 + d13 + d14 + d15;
		
		//Remove the modifications on the last few digits
		d15 = (int) (num % Math.pow(10,16) / Math.pow(10,15));
		d13 = (int) (num % Math.pow(10,14) / Math.pow(10,13));
		d11 = (int) (num % Math.pow(10,12) / Math.pow(10,11));
		
		//Invalid cards
		if(sum % 10 != 0)
		{
			System.out.println("Invalid credit card number");
			return;
		}
		
		//Valid 16 digit cards
		if(sum % 10 == 0 && num >= (long) Math.pow(10,15))
		{
			String comp = "";	//Company name
			
			//Add company name if known
			if (d15 == 3 && (d14 == 4 || d14 == 7))
			{
				comp = "American Express ";
			}
			if (d15 == 6 && ((d14 == 0 && d13 == 1 && d12 == 1) || (d14 == 4 && d13 == 4) || (d14 == 5)))
			{
				comp = "Discover ";
			}
			if (d15 == 5 && d14 >= 0 && d14 <= 5)
			{
				comp = "MasterCard ";
			}
			if (d15 == 4)
			{
				comp = "Visa ";
			}
			System.out.println("Valid " + comp + "credit card number");
			return;
		}
		
		//Valid 15 digit cards
		if(sum % 10 == 0 && num < (long) Math.pow(10,15))
		{
			String comp = "";	//Company name
			
			//Add company name if known
			if (d14 == 3 && (d13 == 4 || d13 == 7))
			{
				comp = "American Express ";
			}
			if (d14 == 6 && ((d13 == 0 && d12 == 1 && d11 == 1) || (d13 == 4 && d12 == 4) || (d13 == 5)))
			{
				comp = "Discover ";
			}
			if (d14 == 5 && d13 >= 0 && d13 <= 5)
			{
				comp = "MasterCard ";
			}
			if (d14 == 4)
			{
				comp = "Visa ";
			}
			System.out.println("Valid " + comp + "credit card number");
			return;
		}
		
	}
}
