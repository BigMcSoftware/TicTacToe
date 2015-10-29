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
	
	@Test
	public void checkXIsWinnerFirstRow()
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
	public void checkOIsWinnerSecondRow()
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
	public void CheckLeftLeaningX()
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
}
