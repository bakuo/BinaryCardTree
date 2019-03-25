import java.util.ArrayList;
import java.util.Scanner;

public class BinaryCardTree 
{
	int numNodes = 0;
	BinaryCountNode root = new BinaryCountNode();
	ArrayList<String> cards = new ArrayList<String>();
	
	public void insertCard(String s)
	{
		addNode(root, s);
	}
	
	public BinaryCountNode addNode(BinaryCountNode targetroot, String val) 
	{
		if(root == null) 
		{
			root = new BinaryCountNode(val);
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
				numNodes++;
			}
		}
		return root;
	}	
	
	public ArrayList<String> getAllCards()
	{
		cards.clear();
		getAllCardsRec(root);
		return cards;
	}
	
	public void getAllCardsRec(BinaryCountNode targetroot)
	{
		if(targetroot != null) 
		{
			getAllCardsRec(targetroot.leftChild);
			if(targetroot.count > 1)
			{
				for(int i = 0; i < targetroot.count; i++)
				{
					cards.add(targetroot.toString());
				}
			}
			else
			{
				cards.add(targetroot.toString());
			}
			getAllCardsRec(targetroot.rightChild);
		}
	}
	
	public int numCardsInHand()
	{
		return numNodes;
	}
	
	public ArrayList getMostColorCard()
	{
		return cards;
	}
	
	public ArrayList getLeastColorCard()
	{
		return cards;
	}
	
	public ArrayList removeCards(String s)
	{
		return cards;
	}
	
	public int contains()
	{
		return 0;
	}
}
