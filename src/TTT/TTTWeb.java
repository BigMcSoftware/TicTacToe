package TTT;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import TTT.TicTacToe;
import TTT.Player;
import TTT.HumanPlayer;
import TTT.ComputerPlayer;
import org.json.simple.JSONObject;
import edu.princeton.cs.algs4.StdOut;

//import org.json.simple.JSONObject;

public class TTTWeb implements SparkApplication 
{

    public static void main(String[] args) 
    {
        staticFileLocation("/public");
        SparkApplication TicTacToeWeb = new TTTWeb();

        String port = System.getenv("PORT");
        if (port != null) 
		{
            port(Integer.valueOf(port));
        }

        TicTacToeWeb.init();
    }

    Player p1;
    Player p2;
    TicTacToe TicTacToeRun;
    public void setPlayers(Player p1R, Player p2R)
    {
	p1 = p1R;
	p2 = p2R;
	TicTacToeRun = new TicTacToe(p1, p2);
	//StdOut.println(p1.getNickname());
	//StdOut.println(p2.getNickname());
    }
    public boolean makeMove(int id, char thePChar)
    {
	int row = 0;
	int column = 0;
	switch (id) {
	case 1:
		row = 0;
		column = 0;
		break;
	case 2:
		row = 0;
		column = 1;
		break;
	case 3:
		row = 0;
		column = 2;
		break;
	case 4: 
		row = 1;
		column = 0;
		break;
	case 5:
		row = 1;
		column = 1;
		break;
	case 6:
		row = 1;
		column = 2;
		break;
	case 7:
		row = 2;
		column = 0;
		break;
	case 8: 
		row = 2;
		column = 1;
		break;
	case 9:
		row = 2;
		column = 2;
		break;
	}

	if (thePChar == 'X')
	{ return TicTacToeRun.makeMove(p1, row, column); }
	else { return TicTacToeRun.makeMove(p2, row, column); }
    }

    @Override
    public void init() 
    {
	char[][] board;
	char nextMove = 'X';

	post("/newGame", (req, res) -> {
			String[] names = req.body().split(":|,");
			names[1] = names[1].substring(1,names[1].length()-1);
			names[3] = names[3].substring(1,names[3].length()-2);
			//StdOut.println(names[0]); 
			//StdOut.println(names[1]);
			//StdOut.println(names[2]);
			//StdOut.println(names[3]);
			Player p1R = new HumanPlayer(names[1], 'X'); 
			Player p2R = new HumanPlayer(names[3], 'O'); 
			this.setPlayers(p1R, p2R);
			JSONObject json = new JSONObject();
			
			json.put("CurrentPlayer", TicTacToeRun.getNextMove());
			return json;
			});
	
	post("/move", (req, res) -> {
				String[] moves = req.body().split(":|,");
				moves[1] = moves[1].substring(1,moves[1].length()-2);
				//StdOut.println(moves[1]);
				//StdOut.println(moves[2]);
                                //StdOut.println(moves[3]);
				JSONObject json = new JSONObject();
				if (TicTacToeRun.getNextMove() == 'X')
				{
					json.put("makeMove",makeMove(Integer.parseInt(moves[1]),'X')); 
					json.put("Winner",TicTacToeRun.checkForWinner('X'));
					json.put("IsBoardFull",TicTacToeRun.boardIsFull());
					json.put("Name",TicTacToeRun.getPlayerWithSymbol('X').getNickname());
					StdOut.println(json);
					TicTacToeRun.displayPlayBoard();
					return json;			
				}
				else
				{
					json.put("makeMove",makeMove(Integer.parseInt(moves[1]),'O'));
					json.put("Winner",TicTacToeRun.checkForWinner('O'));
                                        json.put("IsBoardFull",TicTacToeRun.boardIsFull());
					json.put("Name",TicTacToeRun.getPlayerWithSymbol('O').getNickname());
					StdOut.println(json);
					TicTacToeRun.displayPlayBoard();
					return json;
				}
			});
    }
}
