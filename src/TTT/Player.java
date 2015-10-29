Player implement
package TTT;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Player 
{		
		public Player() 
		{
			
		}
		
		public String getNickname() 
		{
			return null;
		}

		public char getPlayer()
		{
			return 'X';
		}
		
		public void setNextSymbol()
		{
			
		}
		
		public int getWinnings()
		{
			
		}
		
		public void setOneMoreWin()
		{
			
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
	public HumanPlayer(String nickname, char player)
	{

	}
	
	@Override
	public String getNickname()
	{
		return "Player";
	}
	
	@Override
	public char getRowMove()
	{
		return '1'
	}
	
	@Override
	public char getColumnMove()
	{
		return '1';
	}
}



class ComputerPlayer extends Player 
{	
	private static String generateBotName()
	{
		return "Bot1";
	}
	
	public ComputerPlayer()
	{

	}
	
	@Override
	public String getNickname()
	{
		return "ComputerPlayer";
	}
	 
	@Override
	public char getRowMove()
	{
		return '1';
	}
	
	@Override
	public char getColumnMove()
	{
		return '1';
	}
}