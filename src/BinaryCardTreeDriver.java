import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryCardTreeDriver 
{	
	static ArrayList<Goal> goals = new ArrayList<Goal>();
	public static void main(String args[])
	{
		BinaryCardTree hand = new BinaryCardTree();
		ArrayList<String> data = new ArrayList<String>();
		ArrayList <String> deck = new ArrayList<String>();
		
		//reading in stuff from file
		File file = new File("src/resource/Input File.txt");
	    try
	    {
	        Scanner sc = new Scanner(file);
	        while(sc.hasNextLine())
	        {
	        	String s = sc.nextLine();
	        	data.add(s);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    
	    //sorting the stuff read in
	    int handNum = Integer.parseInt(data.get(0));
	    int index = handNum + 1;
	    for(int i = 1; i < index; i++)
	    {
	    	
	    	hand.insertCard(data.get(i));
	    }
	    
	    int goalNum = Integer.parseInt(data.get(index++));
	    for(int i = index++; i < index+goalNum-1; i++)
	    {
	    	String[] parsed = data.get(i).split("\\s+");
	    	goals.add(new Goal(parsed[0], parsed[1]));
	    }	
	    index += goalNum-1;
	    for(int i = index; i < data.size(); i++)
	    {
	    	deck.add(data.get(i));
	    }	    
	    
	    System.out.println("hand size: " + hand.numCardsInHand());
	    System.out.print("hand --> ");
	    hand.getAllCards();
	    System.out.println();
	    for(int i = 0; i < goals.size(); i++)
	    {
	    	hand.removeCards(goals.get(i).getnumber(), goals.get(i).getString(), i);
	    	if(goals.get(i).completed == true)
	    	{
	    		System.out.println(goals.get(i).getnumber() + "-" + goals.get(i).getString() + " is completed: " + BinaryCardTree.removecards);
	    	}
	    	else
	    	{
	    		System.out.println("Uncompleted Goals:");
	    		System.out.println(goals.get(i).getnumber() + "-" + goals.get(i).getString());
	    	}
	    }
	    System.out.println("hand size: " + hand.numCardsInHand());
	    System.out.print("hand --> ");
	    hand.getAllCards();
	    System.out.println();
	    for(int i = 0; i < deck.size(); i++)
	    {
	    	hand.insertCard(deck.get(i));
	    }
	   //System.out.println("hand size: " + hand.numCardsInHand());
	   //System.out.print("hand --> ");
	   //hand.getAllCards();
	}
}
