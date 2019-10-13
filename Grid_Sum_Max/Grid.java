import java.util.*;
import java.io.*;

public class Grid
{
  public static void main (String[] args) throws IOException
  {
	// Create file reader
    File inFile = new File ("grid.txt");    
    Scanner sc = new Scanner (inFile);
 
    //Read in the first line and trim excess
    String line = sc.nextLine ();
    line = line.trim();

    int dim = Integer.parseInt (line);	//The dimensions of the grid

    int[][] grid = new int [dim][dim];	//3D array to store the grid

    //Input all numbers and put them into the grid
    for (int i = 0; i < dim; i++)
    {
    	//Take in the line and trim
    	line = sc.nextLine();
    	line = line.trim();

    	//Split the string into integers 
    	String[] data = line.split ("\\s+");

    	//Save each integer into the array
    	for (int j = 0; j < dim; j++)
    	{
    		grid[i][j] = Integer.parseInt (data[j]);
    	}
    }
    
    //Close the file
    sc.close();

    int maxProd = 0;		//Maximum product of all 4x4 grids
    int prod = 0;			//The maximum product of the 4x4 grid
    int[][] gridSeg = new int [4][4];	//4x4 segment of the grid
    
    //Create and find the maximum product of 4x4 grids
    //Move the 4x4 grid
    for (int i = 0; i < dim -3; i++)
    {
    	for (int c = 0; c < dim -3; c++)
    	{
    		//Fill in the 4x4 grid
    		for(int a = 0; a < 4; a++)
    		{
    			for(int b = 0; b < 4; b++)
    			{
    				gridSeg[a][b] = grid[i + a][c + b];
    			}
    		}
    		//Find the maximum product of the 4x4 grid
    		prod = arrProd(gridSeg);
    		//Find which grid has the largest product
    		if (prod > maxProd)
    		{
    			maxProd = prod;
    		}
    		prod = 0;
    	}
    }
    
    //Output the largest product
    System.out.print("The greatest product is " + maxProd + ".");
    
  }
  
  public static int arrProd (int[][] grid)
  {
	  int maxProd = 0;		//The maximum product
	  int prod = 1;			//The product being calculated

	  //Product of the columns
	  for(int c = 0; c < grid.length; c++)
	  {
		  for(int i = 0; i < grid.length; i++)
		  {
			  prod = prod * grid[i][c];
		  }
		  if (prod > maxProd)
		  {
			  maxProd = prod;
		  }
		  prod = 1;
	  }
	  
	  //Product of the rows
	  for(int c = 0; c < grid.length; c++)
	  {
		  for(int i = 0; i < grid.length; i++)
		  {
			  prod = prod * grid[c][i];
		  }
		  if (prod > maxProd)
		  {
			  maxProd = prod;
		  }
		  prod = 1;
	  }
	  
	  //Product of the diagonal (/)
	  for(int c = 0; c < grid.length; c++)
	  {
		  prod = prod * grid[grid.length - 1 - c][c];
	  }
	  if (prod > maxProd)
	  {
		  maxProd = prod;
	  }
	  prod = 1;

	  //Product of the diagonal (\)
	  for(int c = 0; c < grid.length; c++)
	  {
		  prod = prod * grid[c][c];
	  }
	  if (prod > maxProd)
	  {
		  maxProd = prod;
	  }
	  
	  //Output the largest product in the grid
	  return maxProd;
  }
  
}
