import java.util.ArrayList;

public class BinaryCardTree 
{
	int numNodes = 0;
	BinaryCountNode root = new BinaryCountNode();
	ArrayList<String> cards = new ArrayList<String>();
	
	public static void main(String args[])
	{
		
	}
	
	public BinaryCountNode addNode(BinaryCountNode targetroot, String val) 
	{
		if(root == null) 
		{
			root = new BinaryCountNode();
			numNodes++;
			return root;
		} 
		else 
		{
			if(targetroot.compareTo(val) > 0) 
			{
				if(targetroot.leftChild == null) 
				{
					targetroot.leftChild = new BinaryCountNode(val);
					numNodes++;
					return targetroot;
				}
				else 
				{
					addNode(targetroot.leftChild, val);
				}
			}				
			else if(targetroot.compareTo(val) < 0) 
			{
				if(targetroot.rightChild == null) 
				{
					targetroot.rightChild = new BinaryCountNode(val);
					numNodes++;
					return targetroot;
				}
				else 
				{
					addNode(targetroot.rightChild, val);
				}
			}
			else if(targetroot.compareTo(val) == 0)
			{
				targetroot.incrementCount();
			}
		}
		return root;
	}	
	
	public ArrayList getAllCards()
	{
		return cards;
	}
	
	public int numCardsInHand()
	{
		return 0;
	}
	
	public ArrayList getMostColorCard()
	{
		return cards;
	}
	
	public ArrayList getLeastColorCard()
	{
		return cards;
	}
	
	public ArrayList removeCards()
	{
		return cards;
	}
	
	public int contains()
	{
		return 0;
	}
}
