public class HuffmanTree
{
	static HuffmanNode root;	//Root of the tree
	
	/**
	 * Creates a new tree using huff as the root
	 */
	public void HuffmanTree(HuffmanNode huff)
	{
		this.root = huff;
	}
	
	/**
	 * Sets the root of the tree using Comparable huff as the root
	 */
	public static void setRoot(Comparable huff)
	{
		root = (HuffmanNode) huff;
	}
	
	/**
	 * Driver method for printLegend
	 */
	public static void printLegend()
	{
		printLegend(root, "");
	}
	
	/**
	 * Recursive method that prints out the legend of
	 * letters and frequencies from the huffman tree
	 */
	private static void printLegend(HuffmanNode t, String s)
	{
		if(t.letter.length() > 1)
		{
			printLegend(t.left, s + "0");
			printLegend(t.right, s + "1");
		}
		
		if(t.letter.length() == 1)
		{
			System.out.println(t.letter + "=" + s);
		}
	}
	
	/**
	 * Takes a string of letters and frequencies separated by
	 * spaces and creates and returns a BinaryHeap
	 */
	public static BinaryHeap legendToHeap(String legend)
	{
		String letter = "";		//The current letter
		Double freq = 0.0;		//The frequency of the letter
		BinaryHeap heap = new BinaryHeap();	//Heap to fill and return
		
		//Manually input the first letter (or edge problem)
		letter = legend.charAt(0) + "";
		
		//Move through the input string
		for(int c = 1; c < legend.length(); c++)
		{
			//If the next char is a letter, move previous to stack and set letter
			if(legend.charAt(c) != ' ' && isNum(legend.charAt(c)) == false)
			{
				//Move previous to stack
				HuffmanNode node = new HuffmanNode(letter, freq);	//Node made with the letter and frequency
				heap.insert(node);		//Insert the node into the heap
				
				//Set letter and reset freq
				letter = legend.charAt(c) + "";
				freq = 0.0;
			}
			
			//If the next char is a number, set the frequency
			if(isNum(legend.charAt(c)) == true)
			{
				freq = (double) Character.getNumericValue(legend.charAt(c)) + (freq * 10);
			}
		}
		
		//Manually move last letter to stack (or edge problem)
		HuffmanNode node = new HuffmanNode(letter, freq);
		heap.insert(node);
		
		return heap;
	}
	
	/**
	 * Checks if the char input is a number
	 */
	public static boolean isNum(char ch)
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
	
	/**
	 * Creates the huffman tree from the BinaryHeap and
	 * sets the root node
	 */
	public static void createFromHeap(BinaryHeap b)
	{
		while(b.getSize() > 1)
		{
			HuffmanNode comb = new HuffmanNode(b.deleteMin(), b.deleteMin());
			b.insert(comb);
		}
		
		setRoot(b.deleteMin());
	}

	/**
	 * The main method with the input string hard coded and creates the
	 * huffman tree
	 */
	public static void main(String[] args)
	{
		//The first char must be the first letter ****Not a space or number*****
		String input = "A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2";
		
		//Create the heap and fill the heap using the input string
		BinaryHeap heap = legendToHeap(input);
		
		//Output the heap (in order of array)
		System.out.println("Letters and frequencys (no order):");
		System.out.println(heap.toString());
		System.out.println();
		
		//Create the HuffmanTree from the heap
		createFromHeap(heap);
		
		//Print out the huffmanTree legend
		System.out.println("Huffman Tree Legend: ");
		printLegend();
	}
	
}