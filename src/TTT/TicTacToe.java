package TTT;

import TTT.TTTBoard;
import TTT.Player;
import java.util.ArrayList;

public class TicTacToe {

	private TTTBoard thePlayBoard;
	private Player p1, p2;
	private char nextMove;

	//Constructor for the game. Sets p1 and p2 as this.p1 and this.p2
	public TicTacToe(Player p1, Player p2) 
	{
		this.thePlayBoard = new TTTBoard();
		this.p1 = p1;
		this.p2 = p2;
		this.nextMove = 'X';
	}
	
	//Sets the nextMove as c
	public void setNextMove(char c)
	{
		this.nextMove = c;
	}
	
	//returns the next move.
	public char getNextMove()
	{
		return this.nextMove;
	}
	
	//Initialisez a new game.
	public void newGame() 
	{
		this.nextMove = 'X';
		this.thePlayBoard = new TTTBoard();
	}
	
	//Prints the playing board.
	public void displayPlayBoard() 
	{
		this.thePlayBoard.print();
	}
	
	//Returns true if there is a winner with lastPlayerChar, false otherwise.
	public boolean checkForWinner(char lastPlayerChar)
	{
		return this.thePlayBoard.checkForSameChar(lastPlayerChar);
	}
	
	//Returns true if the playing board is full.
	public boolean boardIsFull()
	{
		//return this.thePlayBoard.IsFull();
		return false;

	}
	
	//Returns an iterable of current players.
	public Iterable<Player> getAllPlayers()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(this.p1);
		players.add(this.p2);
		return players;
	}
	
	//returns the player with the symbol symbol.
	public Player getPlayerWithSymbol(char symbol)
	{
		if(Character.compare(this.p1.getPlayer(), symbol) == 0){
			return p1;
		}
		return p2;
	}
	
	// Changes the player symbols.
	public void changePlayerSymbols()
	{
		p1.setNextSymbol();
		p2.setNextSymbol();
	}

	public char getCharAtLocation(int row, int column)
	{
		return this.thePlayBoard.getAt(row, column);
	}

	public char[][] returnBoardToWeb()
	{
		return this.thePlayBoard.returnBoard();
	}

	//returns true if the player can make the move, false otherwise.
	public boolean makeMove(Player p, int row, int column)
	{
		if (Character.compare(p.getPlayer(), 'X') == 0)
		{
			if(thePlayBoard.setX(row, column))
			{
				this.nextMove = 'O';
				return true;
			}
		}
		else if (Character.compare(p.getPlayer(), 'O') == 0)
		{
			if(thePlayBoard.setO(row, column))
			{
				this.nextMove = 'X';
				return true;
			}
		}
		return false;
	}
}
