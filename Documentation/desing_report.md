
Design report
===========
The McTeam designed a game of TicTacToe using Java. The main focus of the team was to use pair programming and test driven development.
Steps
------
The McTeam used Test Driven Development to perform this project.

###Console Version
First of the team created a Console Version of Tic Tac Toe. For this version the team created a couple of classes and test classes.

*  TicTacToe.java - The logic behind the game.
*  TTTBoard.java - The board class
*  Player - A super class for the players.
	* HumanPlayer - class for HumanPlayers
	* ComputerPlayer - class for ComputerPlayers
*   TestTTT.java - Unit tests.
* TTTConsole.java - the console version of the application.

###Gui Version
Then the team created a Gui Version of Tic Tac Toe. The team added a the class TTTGui.java which is the logic behind the GUI version of the game. This class utilizes the class TicTacToe.java but contains the GUI logic itself.

###Web Application
Finally the team created a Web Application of Tic Tac Toe using Spark.
The team programmed the Web Application in HTML with CSS, using JavaScript to connect to the Java backend. The Web Application also utilizes the TicTacToe.java class for the logic behind the game.

###Testing
The team used the following to test the program.

####Travis CI
 To test each push that went into GitHub we checked if the push passed all tests. If it passed we assured ourselves that merging that branch with the master branch was ok.

#### Selenium
The team performed tests using Selenium on the web application.




