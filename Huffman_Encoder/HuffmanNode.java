public class HuffmanNode implements Comparable
{
	public String letter;
	public Double frequency;
	public HuffmanNode left;
	public HuffmanNode right;
	
	/**
	 * Create a new node with the letter, frequency of the letter,
	 * and both (right and left) children being set manually
	 */
	public HuffmanNode(String letter, Double frequency, HuffmanNode left, HuffmanNode right)
	{
		this.letter = letter;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Creates a new node with the letter equal to the value 
	 * and frequency equal to the number of letters.
	 * The left and right nodes are set to null
	 */
	public HuffmanNode(String letter, Double frequency)
	{
		this.letter = letter;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Create a new node from two children nodes.
	 * The letter is the concatenation of the children letters.
	 * The frequency is the addition of the children frequencies.
	 */
	public HuffmanNode(HuffmanNode left, HuffmanNode right)
	{
		this.left = left;
		this.right = right;
		this.letter = left.letter + right.letter;
		this.frequency = left.frequency + right.frequency;
	}
	
	/**
	 * Create a new node from two children nodes.
	 * The letter is the concatenation of the children letters.
	 * The frequency is the addition of the children frequencies.
	 * This uses Comparable instead of HuffmanNodes
	*/ 
	public HuffmanNode(Comparable left, Comparable right)
	{
		if(left instanceof HuffmanNode && right instanceof HuffmanNode)
		{
			this.left = (HuffmanNode) left;
			this.right = (HuffmanNode) right;
			this.letter = ((HuffmanNode) left).letter + ((HuffmanNode) right).letter;
			this.frequency = ((HuffmanNode) left).frequency + ((HuffmanNode) right).frequency;
		}
	}
	
	/**
	 * Compares this node's frequency to another's frequency
	 * 1 = this > input
	 * 0 = equal frequency
	 * -1 = this < input
	 */
	public int compareTo(HuffmanNode huff)
	{
		if(this.frequency > huff.frequency)
			return 1;
			
		if(this.frequency == huff.frequency)
			return 0;
			
		if(this.frequency < huff.frequency)
			return -1;
			
		return 2;
	}
	
	/**
	 * Compares the frequency of the nodes
	 */
	public int compareTo(Object o)
	{
		if(o instanceof HuffmanNode)
			return this.frequency.compareTo(((HuffmanNode) o).frequency);
		return 1000;
	}
	
	/**
	 * Creates a string representation of the node
	 * <letter, frequency>
	 */
	public String toString()
	{
		return "<" + letter + ", " + frequency + ">";
	}
	
}