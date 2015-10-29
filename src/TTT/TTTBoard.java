package  TTT;

import edu.princeton.cs.algs4.StdOut;

public class TTTBoard {
	//initalize board
	private final static Integer bSize = 3; // size of board as a constant
	private char[][] board; //character board for 'X' and 'O' 
	
	public TTTBoard() 
	{
		board = new char[bSize][bSize]; // 3 x 3 board for gameplay
		for(int i = 0; i < bSize; i++)
		{
			for(int j = 0; j < bSize; j++)
			{
				board[i][j] = '\0';
			}
		}
	}
	
	public boolean isFull()
	{
		
	}
	
	
	public char getAt(int row, int column)
	{
		if (row < 0 || column < 0 || row >= bSize || column >= bSize)
		{ return board[row][column]; }
		return 'f';		
	}
	
	public boolean setX(int row, int column)
	{
		if (row < 0 || column < 0 || row >= bSize || column >= bSize)
		{
			return false;
		}
		if (board[row][column] == '\0')
		{ 
			board[row][column] = 'X';
			return true;
		}
		return false;
	}
	
	public boolean setO(int row, int column)
	{
		if (row < 0 || column < 0 || row >= bSize || column >= bSize)
		{
			return false;
		}
		if (board[row][column] == '\0')
		{ 
			board[row][column] = 'O';
			return true;
		}
		return false;
	}
	
	//Function to check if bsize count of rows or columns have the same character stored
	public boolean checkForSameChar(char checkChar)
	{
		for (int i = 0; i < bSize; i++)
		{
			int counterRows = 0;
			int counterColumns = 0;
			for (int j = 0; j < bSize; j++)
			{
				if (board[i][j] == checkChar)
				{
					counterRows++;
				}
				if (board[j][i] == checkChar)
				{
					counterColumns++;
				}
				
			}
			if (counterRows == bSize)
			{
				return true;
			}
			if (counterColumns == bSize)
			{
				return true;
			}
		}
		//check right leaning from corner to corner
		int countXleftRight = 0;
		for (int i = 0; i < bSize; i++)
		{
			if (board[i][i] == checkChar)
			{
				countXleftRight++;
			}
		}
		if (countXleftRight == bSize)
		{
			return true;
		}
		//check left leaning from corner to corner
		int countXRightLeft = 0;
		for (int i = bSize-1; i >= 0; i--)
		{
			if (board[i][i] == checkChar)
			{
				countXRightLeft++;
			}
		}
		if (countXRightLeft == bSize)
		{
			return true;
		}
		return false;
	}
	
	public static Integer size()
	{
		return bSize;
	}
	
	public void print()
	{
		StdOut.println("   0 1 2");
		for (int i = 0; i < bSize; i++)
		{
			StdOut.print(i + "  ");
			for (int j = 0; j < bSize; j++)
			{
				if(board[i][j] == 'X' || board[i][j] == 'O')
				{
					StdOut.print(board[i][j]+" ");	
				}
				else
				{
					StdOut.print("." + " ");
				}
			}
			StdOut.print("\n");
		}
		StdOut.println();
	}
}

