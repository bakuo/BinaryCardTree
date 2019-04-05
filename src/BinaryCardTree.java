import java.util.ArrayList;
import java.util.Scanner;

public class BinaryCardTree 
{
	int numNodes = 0, largest, smallest, contains;
	BinaryCountNode root = new BinaryCountNode();
	ArrayList<String> colorLargest = new ArrayList<String>();
	ArrayList<String> colorSmallest = new ArrayList<String>();
	static ArrayList<String> removecards = new ArrayList<String>();
	
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
				targetroot.count++;
				numNodes++;
			}
		}
		return root;
	}	
	
	public void getAllCards()
	{
		getAllCardsRec(root);
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
					System.out.print(targetroot.toString() + " ");
				}
			}
			else if(targetroot.count == 1)
			{
				System.out.print(targetroot.toString() + " ");
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
	
	public ArrayList<String> removeCards(int n, String s, int goalsindex)
	{
		removecards.clear();
		removeCardsRec(root, n, s, goalsindex);
		return removecards;
	}
	
	
	public void removeCardsRec(BinaryCountNode targetroot, int goaln, String goals, int goalsindex)
	{
		int numWild = contains("wild");
		if(targetroot.color.compareTo(goals) == 0) 
		{
			if(targetroot.count >= goaln)
			{
				System.out.println("test");
				for(int i = 0 ; i < goaln; i++)
				{
					targetroot.count--;
					numNodes--;
				}
				removecards.add(goals);
				BinaryCardTreeDriver.goals.get(goalsindex).completed = true;
			}
			else if(targetroot.count + numWild >= goaln)
			{
				goaln -= targetroot.count;
				for(int i = 0; i < targetroot.count; i++)
				{
					targetroot.count--;
					numNodes--;
				}
				removecards.add(goals);
				removeWilds(root, goaln);
				BinaryCardTreeDriver.goals.get(goalsindex).completed = true;
			}
			else
			{
				BinaryCardTreeDriver.goals.get(goalsindex).completed = false;
			}
		}
		if(targetroot.color.compareTo(goals) > 0) 
		{
			removeCardsRec(targetroot.leftChild, goaln, goals, goalsindex);
		}
		else if(targetroot.color.compareTo(goals) < 0) 
		{ 
			removeCardsRec(targetroot.rightChild, goaln, goals, goalsindex);
		}
	}
	
	public void removeWilds(BinaryCountNode targetroot, int n)
	{
		if(targetroot.compareTo("wild") == 0) 
		{
			for(int i = 0; i < n; i++)
			{
				targetroot.count--;
				numNodes--;
			}
			removecards.add("wild");
		}
		if(targetroot.compareTo("wild") > 0) 
		{
			removeWilds(targetroot.leftChild, n);
		}
		else if(targetroot.compareTo("wild") < 0) 
		{ 
			removeWilds(targetroot.rightChild, n);
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
