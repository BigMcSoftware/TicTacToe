package TTT;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import TTT.TicTacToe;
import TTT.Player;
import org.json.simple.JSONObject;
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
    }

    @Override
    public void init() 
    {
	char[][] board;
	char nextMove = 'X';

	post("/newGame", (req, res) -> { 
			Player p1R = new HumanPlayer(req.queryParams("name1"), 'X'); 
			Player p2R = new HumanPlayer(req.queryParams("name2"), 'O'); 
			this.setPlayers(p1R, p2R);
			JSONObject json = new JSONObject();
			json.put("CurrentPlayer", TicTacToeRun.getNextMove());
			return json;
			});
	
	post("/move", (req, res) -> {
				if (nextMove == 'X')
				{
					return TicTacToeRun.makeMove(p1, Integer.parseInt(req.queryParams("row")),Integer.parseInt(req.queryParams("column")) );			
				}
				else
				{
					 return TicTacToeRun.makeMove(p2, Integer.parseInt(req.queryParams("row")),Integer.parseInt(req.queryParams("column")) );
				}
			});
    }
}
