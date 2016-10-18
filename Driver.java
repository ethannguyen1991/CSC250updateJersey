
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		
		ArrayList<Player> playerList = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		boolean finishedAddingPlayer = false;
		while(finishedAddingPlayer == false)
		{
			System.out.print("Enter player's jersey number:");
			int jerseyNum = input.nextInt();
			System.out.print("Enter player's rating:");
			int rating = input.nextInt();
			Player playerToAdd = new Player(jerseyNum, rating);
			playerList.add(playerToAdd);
			
			System.out.print("Want to add another player? (y/n): ");
			String inputString = input.next();
			if(inputString.equalsIgnoreCase("y") == false){
				finishedAddingPlayer = true;
			}
		}
		
		char option;
		do
		{
			option = Driver.showMenu(input);
			
			if(option == 'u')
			{
				Driver.updatePlayer(playerList, input);
			}
			else if(option == 'a')
			{
				Driver.aboveRating(playerList, input);
			}
			else if(option == 'r')
			{
				Driver.replacePlayer(playerList, input);
			}
			else if(option == 'o')
			{
				Driver.outputRoster(playerList, input);
			}
		}
		while(option != 'q');
		
		System.out.println("Get lost!");
		input.close();
	}
	
	static char showMenu(Scanner input)
	{
		System.out.println("MENU");
		System.out.println("u - Update player rating");
		System.out.println("a - Output players above a rating");
		System.out.println("r - Replace player");
		System.out.println("o - Output roster");
		System.out.println("q - Quit");
		System.out.print("Choose an option: ");
		return input.next().charAt(0);
	}
	static void updatePlayer(ArrayList<Player> playerList, Scanner input)
	{
		System.out.print("Which player (jersey number) would you like to update? ");
		int jersey_number = input.nextInt();
		for(int i = 0;i<playerList.size();i++){
			Player currentPlayer = playerList.get(i);
			if(currentPlayer.getJerseyNumber() == jersey_number){
				System.out.print("What is the new rating? ");
				int newRating = input.nextInt();
				currentPlayer.setRating(newRating);
			}
		}
	}
	static void aboveRating(ArrayList<Player> playerList, Scanner input)
	{
		System.out.print("What is the minimum rating? ");
		int min_rating = input.nextInt();
		for(int i = 0; i < playerList.size(); i++)
		{
			Player currentPlayer = playerList.get(i);
			if(currentPlayer.getRating() >= min_rating)
			{
				System.out.println("Jersey Number: " + currentPlayer.getJerseyNumber() + " (" + currentPlayer.getRating() + " rating)");
			}
		}
	}
	 static void replacePlayer(ArrayList<Player> playerList, Scanner input)
	    {
	        System.out.print("What player would you like to replace? ");
	        int jersey_number = input.nextInt();
	        for(int i = 0; i < playerList.size(); i++)
	        {
	        	Player currentPlayer = playerList.get(i);
	            if(currentPlayer.getJerseyNumber() == jersey_number)
	            {
	                System.out.print("Enter new player's jersey number:");
	                int newJerseyNum = input.nextInt();
	                System.out.print("Enter new player's rating:");
	                int newRating = input.nextInt();
	                Player newPlayer = new Player(newJerseyNum, newRating);
	                playerList.remove(i);
	                playerList.add(newPlayer);
	                return;
	            }
	        }
	    }
	    static void outputRoster(ArrayList<Player> playerList, Scanner input)
	    {
	    	for(int i = 0; i < playerList.size(); i++)
	    		
	        {
	    		Player currentPlayer = playerList.get(i);
	            System.out.println("Jersey Number: " + currentPlayer.getJerseyNumber() + " (" + currentPlayer.getRating()+"rating )");
	        }
	    }
}
		