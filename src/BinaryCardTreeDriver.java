import java.util.Scanner;

public class BinaryCardTreeDriver 
{
	
	static BinaryCardTree hand = new BinaryCardTree();
	public static void main(String args[])
	{
		Boolean loop = true;
		while(loop == true)
		{
			System.out.println("1. Insert cards into hand.");
			System.out.println("2. Get all cards in hand");
			System.out.println("3. Number of cards in hand.");
			System.out.println("4. Exit.");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter selection: ");
			int input = sc.nextInt();
			System.out.println();
			
			switch(input)
			{
			case 1:
				System.out.println("Enter card to insert: ");
				String input2 = sc.next();
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
				loop = false;
				break;
			}
		}
			
	}
}
