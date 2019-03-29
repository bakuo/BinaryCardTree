import java.util.ArrayList;
import java.util.Scanner;

public class BinaryCardTree 
{
	int numNodes = 0, largest, smallest, contains;
	BinaryCountNode root = new BinaryCountNode();
	ArrayList<String> cards = new ArrayList<String>();
	ArrayList<String> colorLargest = new ArrayList<String>();
	ArrayList<String> colorSmallest = new ArrayList<String>();
	ArrayList<String> removecards = new ArrayList<String>();
	
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
	
	public ArrayList<String> getMostColorCard()
	{
		largest = 0;
		colorLargest.clear();
		getMostColorCardRec(root);
		return colorLargest;
	}
	
	public void getMostColorCardRec(BinaryCountNode targetroot)
	{
		if(targetroot == null) 
		{
		}
		else 
		{
			if(targetroot.count > largest) 
			{
				largest = targetroot.count;
				colorLargest.clear();
				for(int i=0;i<targetroot.count;i++)
				{
					colorLargest.add(targetroot.toString());
				}
			}
			getMostColorCardRec(targetroot.leftChild);
			getMostColorCardRec(targetroot.rightChild);
		}
	}
	
	public ArrayList<String> getLeastColorCard()
	{
		smallest = root.count;
		colorSmallest.clear();
		getLeastColorCardRec(root);
		return colorSmallest;
	}
	
	public void getLeastColorCardRec(BinaryCountNode targetroot)
	{
		if(targetroot == null) 
		{
		}
		else 
		{
			if(targetroot.count < smallest) 
			{
				smallest = targetroot.count;
				colorSmallest.clear();
				for(int i=0;i<targetroot.count;i++)
				{
					colorSmallest.add(targetroot.toString());
				}
			}
			getMostColorCardRec(targetroot.leftChild);
			getMostColorCardRec(targetroot.rightChild);
		}
	}
	
	public ArrayList<String> removeCards(String s, int n)
	{
		removecards.clear();
		removeCardsRec(root, s, n);
		return removecards;
	}
	
	public void removeCardsRec(BinaryCountNode targetroot, String s, int n)
	{
		if(targetroot.compareTo(s) == 0) 
		{
			for(int i=0;i<n;i++)
			{
				targetroot.count--;
				numNodes--;
				cards.remove(s);
				removecards.add(s);
			}
		}
		if(targetroot.compareTo(s) > 0) 
		{
			removeCardsRec(targetroot.leftChild, s, n);
		}
		else if(targetroot.compareTo(s) < 0) 
		{ 
			removeCardsRec(targetroot.rightChild, s, n);
		}
	}
	
	public int contains(String s)
	{
		containsRec(root, s);
		return contains;
	}
	
	public void containsRec(BinaryCountNode targetroot, String s)
	{
		if(targetroot.compareTo(s) == 0) 
		{
			contains = targetroot.count;
		}
		if(targetroot.compareTo(s) > 0) 
		{
			containsRec(targetroot.leftChild, s);
		}
		else if(targetroot.compareTo(s) < 0) 
		{ 
			containsRec(targetroot.rightChild, s);
		}
	}
}
