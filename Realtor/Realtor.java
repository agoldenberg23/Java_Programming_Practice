import java.util.*;
import java.io.*;

class House
{
	//Information on the house
	public Address address;
	public int area;			//In square feet
	public int bedRooms;		//Number of bedrooms
	public int bathRooms;		//Number of bathrooms
	public int garage;			//Number of cars that can fit in the garage
	public double price;
	
	//Default constructor (gives unknown)
	public House()
	{
		this.address = new Address();
		this.area = -1;
		this.bedRooms = -1;
		this.bathRooms = -1;
		this.garage = -1;
		this.price = -1;
	}
	
	//Non-Default constructor
	public House(Address address, int area, int bedRooms, int bathRooms, int garage, double price)
	{
		this.address = address;
		this.area = area;
		this.bedRooms = bedRooms;
		this.bathRooms = bathRooms;
		this.garage = garage;
		this.price = price;
	}
	
	//String representation
	public String toString()
	{
		String S = "Address," + System.lineSeparator()
		+ this.address.toString() + System.lineSeparator()
		+ "Area (square feet): " + this.area + System.lineSeparator()
		+ "Number of Bedrooms: " + this.bedRooms + System.lineSeparator()
		+ "Number of Bathrooms: " + this.bathRooms + System.lineSeparator()
		+ "Maximum cars in the Garage: " + this.garage + System.lineSeparator()
		+ "Price of the house: " + this.price;
		return S;
	}
	
	//Price per square feet
	public double priceSqft()
	{
		double B = this.area;
		return this.price / B;
	}
}



class Address
{
	//Information on the address of the house
	public String street;
	public String town;
	public String state;
	public String zip;
	
	//Default constructor 
	public Address()
	{
		this.street = "Street Unknown";
		this.town = "Town Unknown";
		this.state = "State Unknown";
		this.zip = "Zip Unknown";
	}
	
	//Non-Default constructor
	public Address(String street, String town, String state, String zip)
	{
		this.street = street;
		this.town = town;
		this.state = state;
		this.zip = zip;
	}
	
	//String representation
	public String toString()
	{
		String S = "Street: " + this.street + System.lineSeparator()
		+ "Town: " + this.town + System.lineSeparator()
		+ "State: " + this.state + System.lineSeparator()
		+ "Zip: " + this.zip;
		return S;
	}
}



class HouseList
{
	//List of all houses
	private House[] houseList;		//Array of house information
	private int numHouses = 0;		//Number of houses in the above array
	
	//Default constructor (no houses)
	public HouseList()
	{
		this.houseList = new House[0];
	}
	
	//Non-Default constructor
	public HouseList(int size)
	{
		this.houseList = new House[size];
		
		//Fill the house list with empty houses (default)
		for(int c = 0; c < size; c++)
		{
			this.houseList[c] = new House();
		}
	}
	
	//Get the number of houses
	public int getNumHouses()
	{
		return this.numHouses;
	}
	
	//Get a specified house in the array
	public House getHouse(int index)
	{
		if (index < this.houseList.length)
		{
			return this.houseList[index];
		}
		else
		{
			return new House();
		}
	}
	
	//Check if the house at the specified index is Unknown
	public boolean isEmpty(int index)
	{
		if(this.numHouses == 0)
		{
			return true;
		}
		else if(this.houseList[index].area == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Replace a house at a specified index
	public void changeHouse(int index, House house)
	{
		if(this.houseList[index].area != -1)
		{
			this.houseList[index] = house;
		}
	}
	
	//Add a house if the list is not full
	public void addHouse(House house)
	{
		out: if(this.houseList.length != 0)
		{
			for(int c = 0; c < this.houseList.length; c++)
			{
				if(this.houseList[c].area == -1)
				{
					this.houseList[c] = house;
					this.numHouses++;
					break out;
				}
			}
		}
	}

	
	//Search the array by zip and print out results
	public void searchByZip(String zip)
	{
		for(int c = 0; c < this.numHouses; c++)
		{
			if(this.houseList[c].address.zip.equals(zip))
			{
				System.out.println(this.houseList[c].toString());
				System.out.println();
			}
		}
	}
	
	//Search the array by price and print out results
	public void searchByPrice(double low, double high)
	{
		for(int c = 0; c < this.numHouses; c++)
		{
			if(this.houseList[c].price + 1e-10 > low && this.houseList[c].price - 1e-10 < high)
			{
				System.out.println(this.houseList[c].toString());
				System.out.println();
			}
		}
	}
	
	//Search the array by area and print out results
	public void searchByArea(int low, int high)
	{
		for(int c = 0; c < this.numHouses; c++)
		{
			if(this.houseList[c].area >= low && this.houseList[c].area <= high)
			{
				System.out.println(this.houseList[c].toString());
				System.out.println();
			}
		}
	}
	
	//Search the array by rooms and print out results
	public void searchByRooms(int rooms)
	{
		for(int c = 0; c < this.numHouses; c++)
		{
			if(this.houseList[c].bedRooms == rooms)
			{
				System.out.println(this.houseList[c].toString());
				System.out.println();
			}
		}
	}
	
}



public class Realtor
{
  public static void main ( String[] args ) throws IOException
  {
    // Create a HouseList object that can hold a hundred houses
	  HouseList List = new HouseList(100);
	  
	  //Create file reader
	  File inFile = new File ("realtor.txt");    
	  Scanner sc = new Scanner (inFile);

    // Populate the array with 10 houses with data from realtor.txt
	  String tempStreet;		//Temporary variables to hold data from txt
	  String tempTown;
	  String tempState;
	  String tempZip;
	  int tempArea;
	  int tempBedRooms;
	  int tempBathRooms;
	  int tempGarage;
	  double tempPrice;
	  
	  for(int c = 1; c <= 10; c++)
	  {
		  // Create an Address object for each house
		  String line = sc.nextLine ();
		  tempStreet = line.trim();
		  line = sc.nextLine ();
		  tempTown = line.trim();
		  line = sc.nextLine ();
		  tempState = line.trim();
		  line = sc.nextLine ();
		  tempZip = line.trim();
		  Address tempAddress = new Address(tempStreet, tempTown, tempState, tempZip);
		  
		  // Create a House object for each house and add the Address object
		  line = sc.nextLine ();
		  tempArea = Integer.parseInt(line.trim());
		  line = sc.nextLine ();
		  tempBedRooms = Integer.parseInt(line.trim());
		  line = sc.nextLine ();
		  tempBathRooms = Integer.parseInt(line.trim());
		  line = sc.nextLine ();
		  tempGarage = Integer.parseInt(line.trim());
		  line = sc.nextLine ();
		  tempPrice = Double.parseDouble(line.trim());
		  House tempHouse = new House(tempAddress, tempArea, tempBedRooms, tempBathRooms, tempGarage, tempPrice);
		  
		  // Add the House object to the HouseList
		  List.addHouse(tempHouse);
		  
		  if(c < 10)
			  line = sc.nextLine();		//The extra line between houses in the txt
	  }
	  
    // Write out the number of houses in your list
	  System.out.println("Number of houses: " + List.getNumHouses());
	  System.out.println();

    // Write out the houses in a certain zip code
	  System.out.println("Houses with the zip code 78712.");
	  List.searchByZip("78712");

    // Write out the houses in a certain price range
	  System.out.println("Houses within the price range of 100000$ to 200000$.");
	  List.searchByPrice(100000, 200000);
	  
    // Write out the houses in a certain square foot range
	  System.out.println("Houses within the square foot range of 3000 to 4000.");
	  List.searchByArea(3000, 4000);

    // Write out the houses that have a certain number of bedrooms
	  System.out.println("Houses with 6 bedrooms.");
	  List.searchByRooms(6);
  }
}
