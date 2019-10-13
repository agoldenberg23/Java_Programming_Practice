import java.util.*;
public class CalculatePI 
{

	public static boolean isInside (double x, double y)
	{
		//Returns if the x and y coordinate is inside a unit circle
		return Math.sqrt(x * x + y * y) <= 1;
	}
	
	public static double computePI (double thr)
	{
		//Computes the number for PI
		
		//Create the random number generator 
		Random randomGen = new Random ( System.currentTimeMillis() );
		
		int in = 0;		//Count of the numbers inside the circle
		
		//Calculate random points and checks if they are in the circle
		for (int c = 0; c <= thr; c++)
		{
			double x = (randomGen.nextDouble()) * 2 - 1.0;
			double y = (randomGen.nextDouble()) * 2 - 1.0;
			if (isInside(x,y))
			{
				in++;
			}
		}
		return (in / thr) * 4;
	}

	public static void main(String[] args)
	{
		double piC = 0;
		double diff = 0;
		
		//Repeat the code for 100, 1,000, 10,000 and 100,000
		for (int thr = 100; thr <= 100000; thr = thr*10)
		{
			piC = computePI(thr);
			diff = piC - Math.PI;
			System.out.println("Number of throws = " + thr + ", Computed PI = " + piC + ", Difference = " + diff);
		}
	}

}
