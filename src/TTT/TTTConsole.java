package TTT;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdIn;
//import java.lang.Exception;

import TTT.Player;
import TTT.ComputerPlayer;
import TTT.HumanPlayer;

/**
 * The <tt>TTTConsole.java</tt> class provides the aspects to play <b>Tic Tac Toe</b> in console.
 * <b>TODO: Write about this motherfocking class</b>
 * @author Arnar Freyr Kristjánsson
 * @author Dagur Leó Bergsson
 * @author Daníel Fannar Guðmundsson
 * @author Daníel Ingvarsson
 * @author Hlynur Hansen
 * @author Theódór Ágúst Magnússon
 * @version v1.0
 * 
 */

public class TTTConsole {
	
	private TicTacToe ttt;
	
	/**
	 * TTTConsole constructor.
	 * @param p1 <b>Player 1</b>
	 * @param p2 <b>Player 2</b>
	 */
	public TTTConsole(Player p1, Player p2)
	{
		this.ttt = new TicTacToe(p1, p2);
	}
	
	/**
	 * 
	 * @return an iterable of all players.
	 */
	private Iterable<Player> getAllPlayers()
	{
		return ttt.getAllPlayers();
	}
	
	/**
	 * Gets <b>Player</b> with the symbol
	 * @param symbol char
	 * @return the <b>Player</b> with the corresponding symbol.
	 */
	private Player getPlayerWithSymbol(char symbol)
	{
		return ttt.getPlayerWithSymbol(symbol);
	}
	
	/**
	 * Gets the next move.
	 * @return nextMove
	 */
	private char getNextMove()
	{
		return ttt.getNextMove();
	}
	
	/**
	 * Tries to make the desired move that the Player has inserted.
	 * @param p
	 * @param row
	 * @param column
	 * @return <b>true</b> if the player can make the move, <b>false</b> otherwise.
	 */
	private boolean makeMove(Player p, int row, int column){
		return ttt.makeMove(p, row, column);
	}
	
	/**
	 * Checks if the playerSymbol has won.
	 * @param playerSymbol char
	 * @return <b>true</b> if the playerSymbol has won the game, <b>false</b> otherwise.
	 */
	private boolean checkForWinner(char playerSymbol){
		return ttt.checkForWinner(playerSymbol);
	}
	
	private boolean boardIsFull()
	{
		return ttt.boardIsFull();
	}
	
	public static void main(String[] args)
	{
		start();
	}

	//CONSOLE
	/**
	 * Changes the symbols of the <b>Players</b> if they want them to change.
	 * @return <b>true</b> if the <b>Players</b> want to change symbols, <b>false</b> otherwise.
	 */
	public boolean changePlayerSymbols()
	{
		ArrayList<Player> players = (ArrayList<Player>) getAllPlayers();
		StdOut.println("Would you like to change the symbols of the players?(y/n)");
		for(Player p : players){
			StdOut.printf("%s, %c\n", p.getNickname(), p.getPlayer());
		}
		String input = StdIn.readString();
		if(input.compareTo("y") == 0 | input.compareTo("Y") == 0){
			ttt.changePlayerSymbols();
			return true;
		}
		return false;
	}
	
	
	//CONSOLE ONLY DISPLAY FUNCTIONS.
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * 							Display Functions    						   *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Displays the <b>Players</b> names and symbols for the current game.
	 */
	public void displayNamesAndSymbols()
	{
		ArrayList<Player> players = (ArrayList<Player>) getAllPlayers();
		StdOut.println("A new game has started");
		for(Player p : players){
			StdOut.printf("%s - %c \n", p.getNickname(), p.getPlayer());
		}
		StdOut.println();
	}
	
	/**
	 * Displays which <b>Player</b> is supposed to play.
	 * @param p
	 */
	public void displayPlayerTurn(Player p)
	{
		StdOut.printf("It is %s turn to play\n", p.getNickname());
	}
	
	/**
	 * Displays the score for the <b>Player</b>.
	 * @param p
	 */
	public void displayScores(){
		ArrayList<Player> players = (ArrayList<Player>) getAllPlayers();
		for(Player p : players){
			StdOut.printf("Player %s has %d wins\n", p.getNickname(), p.getWinnings());	
		}
	}
	
	/**
	 * Displays a help menu for the user.
	 */
	public void displayHelp(){
		StdOut.println("Press q to exit");
		StdOut.println("Press r to restart");
		StdOut.println("Press i for info about TicTacToe\n");
	}
	
	public void displayInformation(){
		StdOut.println("Tic-tac-toe (also known as Noughts and crosses or Xs and Os) is a ");
		StdOut.println("paper-and-pencil game for two players, X and O, who take turns marking");
		StdOut.println("the spaces in a 3x3 grid. The player who succeeds in placing three of");
		StdOut.println("their marks in a horizontal, vertical, or diagonal row wins the game");
	}
	
	/**
	 * Displays a welcome message for the user/s.
	 */
	public void displayWelcomeMessage()
	{
		StdOut.println("********************************************************************************************");
		StdOut.println(" _    _      _                            _          _____ _    _____        _____          ");
		StdOut.println("| |  | |    | |                          | |        |_   _(_)  |_   _|      |_   _|         ");
		StdOut.println("| |  | | ___| | ___ ___  _ __ ___   ___  | |_ ___     | |  _  ___| | __ _  ___| | ___   ___ ");
		StdOut.println("| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\    | | | |/ __| |/ _` |/ __| |/ _ \\ / _ \\");
		StdOut.println("\\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |   | | | | (__| | (_| | (__| | (_) |  __/");
		StdOut.println(" \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/    \\_/ |_|\\___\\_/\\__,_|\\___\\_/\\___/ \\___|\n");
		StdOut.println("********************************************************************************************");	
		StdOut.println("Please enter h for help.");
	}
	
	/**
	 * Displays a victory message for the <b>Player</b>.
	 * @param p
	 */
	public void displayVictoryMessage(Player p)
	{
		StdOut.printf("Congratulations to %s he is the winner!\n", p.getNickname());
	}
	
	/**
	 * Displays a draw message.
	 */
	public void displayDrawMessage()
	{
		StdOut.println("It's a draw\n");
	}
	
	/**
	 * Displays the playing board.
	 */
	public void displayPlayBoard()
	{
		ttt.displayPlayBoard();
	}
	
	/**
	 * Restarts the program.
	 */
	public static void restart()
	{
		StdOut.println("Restarting");
		StdOut.println("Please wait while the system loads a new game");
		for(int i = 0; i <= 100; i+=10){
			StdOut.print(i+"% ");	
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		StdOut.println();
		start();
	}
	
	/**
	 * Shut downs the program.
	 */
	public void shutDown()
	{
		StdOut.println("Shutting down! \nGood bye !");
		System.exit(0);
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * 							Input Functions 						       *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Gets input from the <b>User</b> on which game mode they would like to play.
	 * @return <b>1</b> if the <b>User</b> wants to play versus another <b>User</b>.
	 *         <p><b>2</b> if the <b>User</b> wants to play versus the <b>Computer</b>.</p>
	 * 		   <p><b>3</b> if the <b>User</b> wants to watch the <b>Computer</b> play versus the <b>Computer</b>.</p>
	 */
	public static int getGameMode(){
		StdOut.println("Please enter the number to go to the game mode you desire");
		StdOut.println("1 - Human vs Human");
		StdOut.println("2 - Human vs Bot");
		StdOut.println("3 - Bot vs Bot");
		int choice = StdIn.readInt();
		return choice;
	}
	
	/**
	 * Checks if the <b>Players</b> want to play again. If the <b>Players</b> want to play again.
	 * The program checks if the <b>Players</b> want to change their symbols.
	 * @return <b>true</b> if the user wants to play again, <b>false</b> otherwise.
	 * @param tc <b>Instance of the TTTConsole class</b>
	 */
	public static boolean playAgain(TTTConsole tc)
	{
		StdOut.println("Would you like to play again?(y/n)");
		String input = StdIn.readString();
		if(input.compareTo("y") == 0 || input.compareTo("Y") == 0)
		{
			tc.changePlayerSymbols();
			return true;
		}
		else if(input.compareTo("n") == 0 | input.compareTo("N") == 0)
		{
			return false;
		}
		else
		{
			StdOut.println("Invalid input");
			return playAgain(tc);
		}
	}
	
	/**
	 * Checks if the <b>User</b> wants to quit the game.
	 * @param c
	 * @return <b>true</b> if the user wants to quit the game, <b>false</b> otherwise.
	 */
	public boolean playerWantsToQuit(char c)
	{
		if(Character.compare(c, 'Q') == 0 | Character.compare(c, 'q') == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the <b>User</b> wants to restart the game.
	 * @param c
	 * @return <b>true</b> if the user wants to restart the game, <b>false</b> otherwise.
	 */
	public boolean playerWantsToRestart(char c)
	{
		if(Character.compare(c, 'R') == 0 | Character.compare(c, 'r') == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the <b>User</b> wants help.
	 * @param c
	 * @return <b>true</b> if the user wants to help, <b>false</b> otherwise.
	 */
	public boolean playerWantsHelp(char c)
	{
		if(Character.compare(c, 'h') == 0 | Character.compare(c, 'H') == 0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks if the <b>User</b> wants information.
	 * @param c
	 * @return <b>true</b> if the user wants information, <b>false</b> otherwise.
	 */
	public boolean playerWantsInformation(char c)
	{
		if(Character.compare(c, 'i') == 0 | Character.compare(c, 'I') == 0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks if the <b>User</b> has inputed a special character.
	 * @param c
	 * @return <b>true</b> if the <b>User</b> inputed a special character, <b>false</b> otherwise.
	 */
	public boolean specialInput(char c)
	{
		if(playerWantsToQuit(c)){
			shutDown();
			return true;
		}
		if(playerWantsToRestart(c)){
			restart();
			return true;
		}
		if(playerWantsHelp(c)){
			displayHelp();
			return true;
		}
		if(playerWantsInformation(c)){
			displayInformation();
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the row input from the <b>Player</b>.
	 * @param currentPlayer
	 * @return The row input from the <b>Player</b>.
	 */
	public char getPlayerRow(Player currentPlayer)
	{
		char c = currentPlayer.getRowMove();
		return c;
	}
	
	/**
	 * Gets the column input from the <b>Player</b>.
	 * @param currentPlayer
	 * @return The column input from the <b>Player</b>.
	 */
	public char getPlayerColumn(Player currentPlayer)
	{
		char c = currentPlayer.getColumnMove();
		return c;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * 							The main functions 						       *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * <p>
	 * Creates two <b>Players</b>. Gets the desired <b>Game Mode</b> from the user
	 * using the function <tt>getGameMode()</tt>.
	 * Initializes the two <b>Players</b> to the current <b>Game Mode</b>.
	 * Starts the game and continues until the <b>user</b> wants to quit the game.
	 * </p>
	 */
	public static void start()
	{	
		Player p1 = null, p2 = null;
		int gameMode = getGameMode();
		if(gameMode == 1){		//Start a game of human vs human
			StdOut.print("Insert name for player 1: ");
			p1 = new HumanPlayer(StdIn.readString(), 'X');
			StdOut.print("Insert name for player 2: ");
			p2 = new HumanPlayer(StdIn.readString(), 'O');
		} else if(gameMode == 2){
			StdOut.print("Insert name for player 1: ");
			p1 = new HumanPlayer(StdIn.readString(), 'X');
			p2 = new ComputerPlayer('O');
		} else if(gameMode == 3){
			p1 = new ComputerPlayer('X');
			p2 = new ComputerPlayer('O');
		} else{
			StdOut.println("You have entered an invalid game mode. Please try again");
			start();
		}
		
		boolean firstGame = true;
		TTTConsole ttt = null;
		do {
			ttt = new TTTConsole(p1, p2);
			//assert(ttt != null);
			//TicTacToe t = new TicTacToe();
			if(firstGame){
				ttt.displayWelcomeMessage();
				ttt.displayHelp();
			}
			ttt.displayNamesAndSymbols();
			firstGame = false;
			//assert(p1 != null & p2 != null);
			ttt.play();
		} while(playAgain(ttt));
	}
	
	
	/**
	 * The main logic of the console version. Here the program gets the input from the <b>Players</b>
	 * and assigns that information to the TicTacToe grid. The program then checks if either one of the
	 * <b>Players</b> has won.
	 */

	public void play()
	{
		displayPlayBoard();
		do
		{
			Player currentPlayer = getPlayerWithSymbol(getNextMove());
			displayPlayerTurn(currentPlayer);
			//assert(currentPlayer == null);
			char row = getPlayerRow(currentPlayer);
			if(!specialInput(row))
			{
				char column = getPlayerColumn(currentPlayer);
				if(!specialInput(column))
				{
					if(makeMove(currentPlayer, Character.getNumericValue(row), Character.getNumericValue(column)))
					{	
						if(checkForWinner(currentPlayer.getPlayer()))
						{
							displayVictoryMessage(currentPlayer);
							currentPlayer.setOneMoreWin();
						}
						else if(boardIsFull()){
							displayDrawMessage();
						}
						displayPlayBoard();
					}
					else
					{
						StdOut.printf("Sorry but that part of the grid is already taken.\nAre you blind %s?\n", currentPlayer.getNickname());
					}
				}
			}
		}while(!checkForWinner('X') & !checkForWinner('O') & !boardIsFull());
		displayScores();
	}
}

