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

