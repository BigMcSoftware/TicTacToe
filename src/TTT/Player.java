package TTT;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Player 
{		private int Winnings = 0;
		private char player;

		public Player(char player) 
		{
			this.player = player;
		}
		
		public String getNickname() 
		{
			return null;
		}

		public char getPlayer()
		{
			return this.player;
		}
		
		public void setNextSymbol()
		{
			if(this.player == 'X') { this.player = 'O'; }
			else { this.player = 'X'; }
		}
		
		public int getWinnings()
		{
			return this.Winnings;
		}
		
		public void setOneMoreWin()
		{
			this.Winnings++;
		}
		
		public char getRowMove()
		{
			return '\0';
		}
		
		public char getColumnMove()
		{
			return '\0';
		}
}

class HumanPlayer extends Player 
{
	private String nickname;

	public HumanPlayer(String nickname, char player)
	{
		super(player);
		this.nickname = nickname;
	}
	
	@Override
	public String getNickname()
	{
		return this.nickname;
	}
	
	@Override
	public char getRowMove()
	{
		return StdIn.readString().substring(0, 1).toCharArray()[0];
	}
	
	@Override
	public char getColumnMove()
	{
		return StdIn.readString().substring(0,1).toCharArray()[0];
	}
}



class ComputerPlayer extends Player 
{	
	private static String[] botAdjectives = {"Soucy", "Antiquated", "Salsa", "Colorless", "Fucking", "Super", "Zombified",
											 "Spicy", "Overhyped", "Squandered", "Tough", "Blissful", "Concerned", "Corny",
											 "Clumsy", "Clueless", "Healty", "Impeccable", "Jolly", "Kindly", "Medium",
											 "Neutral", "Cheesy", "Relatively", "Sentimental", "Uneven"};
	private static String[] botNouns = {"Banana", "Doll", "Bot", "Cat", "Dog", "Rocket", "Zombie", "Breakfest", "Actor",
										"Cannon", "Carpenter"};
	private static String generateBotName()
	{
		return botAdjectives[StdRandom.uniform(0, botAdjectives.length)] + " " + botNouns[StdRandom.uniform(0, botNouns.length)];
	}
	
	private String nickname;
	public ComputerPlayer(char player)
	{
		super(player);
		this.nickname = generateBotName();
	}
	
	@Override
	public String getNickname()
	{
		return this.nickname;
	}
	 
	@Override
	public char getRowMove()
	{
		return Integer.toString(StdRandom.uniform(0, 3)).charAt(0);
	}
	
	@Override
	public char getColumnMove()
	{
		return Integer.toString(StdRandom.uniform(0, 3)).charAt(0);
	}
}

