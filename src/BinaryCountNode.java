public class BinaryCountNode 
{
	String color;
	int count;
	public BinaryCountNode()
	{
		color = "";
		count = 0;
	}
	
	public BinaryCountNode(String s)
	{
		this.color = s;
		count = 0;
	}
	
	public void add()
	{
		count++;
	}
	
	public int compareTo(String s)
	{
		if(this.color == s)
		{
			return 0;
		}
		else if()
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
}
