package TTT;

import edu.princeton.cs.algs4.StdIn;
import TTT.Player;

public class HumanPlayer extends Player
{
        private String nickname;

        public HumanPlayer(String nickname, char player)
        {
                super(player);
                this.nickname = nickname;
        }

        @Override
        public String getNickname()
        {
                return this.nickname;
        }
	@Override
        public char getRowMove()
        {
                return StdIn.readString().substring(0, 1).toCharArray()[0];
        }

        @Override
        public char getColumnMove()
        {
                return StdIn.readString().substring(0,1).toCharArray()[0];
        }
}

