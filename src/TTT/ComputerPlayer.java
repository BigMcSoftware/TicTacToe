package TTT;

import TTT.Player;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class ComputerPlayer extends Player
{
        private static String[] botAdjectives = {"Soucy", "Antiquated", "Salsa", "Colorless", "Fucking", "Super", "Zombified",

         "Spicy", "Overhyped", "Squandered", "Tough", "Blissful", "Concerned", "Corny",

         "Clumsy", "Clueless", "Healty", "Impeccable", "Jolly", "Kindly", "Medium",

         "Neutral", "Cheesy", "Relatively", "Sentimental", "Uneven"};
        private static String[] botNouns = {"Banana", "Doll", "Bot", "Cat", "Dog", "Rocket", "Zombie", "Breakfest", "Actor",

"Cannon", "Carpenter"};
        private static String generateBotName()
        {
                return botAdjectives[StdRandom.uniform(0, botAdjectives.length)] + " " + botNouns[StdRandom.uniform(0, botNouns.length)];
        }

        private String nickname;
        public ComputerPlayer(char player)
        {
                super(player);
                this.nickname = generateBotName();
        }

        @Override
        public String getNickname()
        {
                return this.nickname;
        }

        @Override
        public char getRowMove()
        {
                return Integer.toString(StdRandom.uniform(0, 3)).charAt(0);
        }

        @Override
        public char getColumnMove()
        {
                return Integer.toString(StdRandom.uniform(0, 3)).charAt(0);
        }
}

