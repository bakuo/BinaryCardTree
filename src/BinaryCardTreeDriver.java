import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryCardTreeDriver 
{
	
	//static BinaryCardTree hand = new BinaryCardTree();
	
	public static void main(String args[])
	{
		BinaryCardTree hand = new BinaryCardTree();
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<Goal> goals = new ArrayList<Goal>();
		ArrayList <String> deck = new ArrayList<String>();
		/*
		Boolean loop = true;
		while(loop == true)
		{
			System.out.println("1. Insert cards into hand.");
			System.out.println("2. Get all cards in hand");
			System.out.println("3. Number of cards in hand.");
			System.out.println("4. Get cards of the most number.");
			System.out.println("5. Get cards of the least number.");
			System.out.println("6. Remove cards from hand.");
			System.out.println("7. Contains.");
			System.out.println("8. Exit.");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter selection: ");
			int input = sc.nextInt();
			System.out.println();
			
			switch(input)
			{
			case 1:
				System.out.println("Enter card to insert: ");
				String input2 = sc.next().toLowerCase();
				hand.insertCard(input2);
				System.out.println();
				break;
			case 2:
				System.out.println(hand.getAllCards());
				System.out.println();
				break;
			case 3:
				System.out.println("Cards in hand: " + hand.numCardsInHand());
			case 4:
				System.out.println("Most color card: " + hand.getMostColorCard());
				break;
			case 5:
				System.out.println("Least color card: " + hand.getLeastColorCard());
				break;
			case 6:
				System.out.println("Enter card to remove: ");
				input2 = sc.next().toLowerCase();
				System.out.println("Enter number of cards to remove: ");
				int numinput = sc.nextInt();
				System.out.println("Removed card(s): " + hand.removeCards(input2, numinput));
				System.out.println();
				break;
			case 7:
				System.out.println("Enter which card to check: ");
				input2 = sc.next().toLowerCase();
				System.out.println("Contains: " + hand.contains(input2));
				System.out.println();
				break;
			case 8: 
				loop = false;
				break;
			}
		} */
		
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
	    
	    
	    int handNum = Integer.parseInt(data.get(0));
	    int index = handNum + 1;
	    for(int i = 1; i < index; i++)
	    {
	    	
	    	hand.insertCard(data.get(i));
	    }
	    //System.out.println("Hand: " + hand);
	    
	    int goalNum = Integer.parseInt(data.get(index++));
	    for(int i = index++; i < index+goalNum-1; i++)
	    {
	    	String[] parsed = data.get(i).split("\\s+");
	    	goals.add(new Goal(parsed[0], parsed[1]));
	    }	
	    index += goalNum-1;
	    //System.out.print("Goals: [");
	    
	//    for(int i = 0; i < goals.size(); i++)
	//    {
	//    	System.out.print(goals.get(i).toString() + ", ");
	//   }
	//    System.out.println("]");

	    for(int i = index; i < data.size(); i++)
	    {
	    	deck.add(data.get(i));
	    }
	    //System.out.println("Deck: " + deck);
	    
	    System.out.println("hand size: " + hand.numCardsInHand());
	    System.out.print("hand --> " + hand.getAllCards());
	}
}
