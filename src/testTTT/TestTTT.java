package testTTT;

import org.junit.Assert;
import org.junit.Test;

public class TestTTT {
	public static void main(String arg[])
	{
		org.junit.runner.JUnitCore.main("testTTT.TestTTT");
	}
	
	private Player p1 = new HumanPlayer("Player1", 'X');
	private Player p2 = new HumanPlayer("Player2", 'O');
	private Player p3 = new ComputerPlayer('X');
	private Player p4 = new ComputerPlayer('O');
	
	@Test
	public void NonNullHumanPlayersName()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		for(Player p : TTTGame.getAllPlayers())
		{
			Assert.assertNotEquals(null, p.getNickname());
		}
	}
	
	@Test
	public void NonNullComputerPlayersName()
	{
		TicTacToe TTTGame = new TicTacToe(p3, p4);
		for(Player p : TTTGame.getAllPlayers())
		{
			Assert.assertNotEquals(null, p.getNickname());
		}
	}
	
	
	@Test
	public void checkXIsWinnerFirstRowHorizontal()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 0, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 0, 2);
		Assert.assertEquals(true,TTTGame.checkForWinner('X'));
	}
	
	@Test
	public void checkOIsWinnerSecondRowHorizontal()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 2, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 0, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 2);
		Assert.assertEquals(true,TTTGame.checkForWinner('O'));
	}
	
	@Test
	public void checkXIsWinnerThirdRowHorizontal()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 2, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 2, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 2, 2);
		Assert.assertEquals(true, TTTGame.checkForWinner('X'));
	}
	
	
	@Test
	public void checkOIsWinnerFirstRowVertical()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 2, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 1, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 2, 0);
		Assert.assertEquals(true, TTTGame.checkForWinner('O'));
	}
	
	@Test
	public void checkXIsWinnerSecondRowVertical()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 2, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 2, 1);
		Assert.assertEquals(true, TTTGame.checkForWinner('X'));
	}
	
	@Test
	public void checkOIsWinnerThirdRowVertical()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 0, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 2, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 2, 2);
		Assert.assertEquals(true, TTTGame.checkForWinner('O'));
	}
	
	@Test
	public void checkXIsWinnerDiagonal()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 2, 2);
		Assert.assertEquals(true, TTTGame.checkForWinner('X'));
	}
	
	/*
	@Test	
	public void checkOIsWinnerDiagonal()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 0, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 1, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove(p1, 0, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove(p2, 2, 0);
		Assert.assertEquals(true, TTTGame.checkForWinner('O'));
	}
	*/
	
	@Test
	public void checkForDraw()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		TTTGame.makeMove(p1, 0, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p2, 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p1, 0, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p2, 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p1, 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p2, 1, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p1, 2, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p2, 2, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(false, TTTGame.boardIsFull());
		TTTGame.makeMove(p1, 2, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		Assert.assertEquals(true, TTTGame.boardIsFull());
	}
	
	@Test
	public void canChangePlayerSymbols()
	{
		TicTacToe TTTGame = new TicTacToe(p1, p2);
		Assert.assertEquals('X', p1.getPlayer());
		Assert.assertEquals('O', p2.getPlayer());
		TTTGame.changePlayerSymbols();
		Assert.assertEquals('X', p2.getPlayer());
		Assert.assertEquals('O', p1.getPlayer());
	}
}
