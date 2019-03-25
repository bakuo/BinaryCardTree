public class BinaryCountNode 
{
	String color;
	int count;
	
	BinaryCountNode leftChild;
	BinaryCountNode rightChild;
	
	public BinaryCountNode()
	{
		color = "";
		count = 0;
	}
	
	public BinaryCountNode(String s)
	{
		this.color = s;
		count = 1;
	}
	
	public void incrementCount()
	{
		count++;
	}
	
	public int compareTo(String s)
	{
		if(this.color.compareTo(s) == 0)
		{
			return 0;
		}
		else if(this.color.compareTo(s) > 0)
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
	
	public String toString() 
	{ 
		return color;
	}
}
