package testTTT;

import org.junit.Assert;
import org.junit.Test;

public class TestTTT {
	public static void main(String arg[])
	{
		org.junit.runner.JUnitCore.main("testTTT.TestTTT");
	}
	
	@Test
	public void checkXIsWinnerFirstRow()
	{
		TicTacToe TTTGame = new TicTacToe();
		TTTGame.makeMove('X', 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove('O', 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove('X', 0, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove('O', 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove('X', 0, 2);
		Assert.assertEquals(true,TTTGame.checkForWinner('X'));
		//TTTGame.print();
	}
	
	@Test
	public void checkOIsWinnerSecondRow()
	{
		TicTacToe TTTGame = new TicTacToe();
		TTTGame.makeMove('X', 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove('O', 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove('X', 2, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove('O', 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove('X', 0, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove('O', 1, 2);
		Assert.assertEquals(true,TTTGame.checkForWinner('O'));
		TTTGame.print();
	}
	
	@Test
	public void CheckLeftLeaningX()
	{
		TicTacToe TTTGame = new TicTacToe();
		TTTGame.makeMove('X', 0, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove('O', 1, 0);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove('X', 1, 1);
		Assert.assertEquals(false, TTTGame.checkForWinner('X'));
		TTTGame.makeMove('O', 1, 2);
		Assert.assertEquals(false, TTTGame.checkForWinner('O'));
		TTTGame.makeMove('X', 2, 2);
		Assert.assertEquals(true, TTTGame.checkForWinner('X'));
		TTTGame.print();
	}
	
	@Test
	public void CheckRightLeaningO()
}