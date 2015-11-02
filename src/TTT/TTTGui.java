package TTT;

import TTT.TicTacToe;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.awt.event.*;

//import java.io.File;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.ArrayList;

public class TTTGui
{
	private TicTacToe TTTGame;
	private JTextPane pane;
    private JPanel TTTpanel;
    private Container content;
    //Player configs
    private Player p1, p2;
    private boolean HumanVsHuman;
    private boolean StillPlaying;
    protected JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    
    public TTTGui() {
    	p1 = new HumanPlayer("Player1", 'X');
    	p2 = new HumanPlayer("Player2", 'O');

    	HumanVsHuman = true;
    	StillPlaying = false;
    	//GAME LOGIC
    	TTTGame = new TicTacToe(p1, p2);
    	//call CreateMenu logic
    	JMenuBar menuBar = CreateMenu();
        //call CreateFrame for gui design
    	JFrame frame = CreateFrame(menuBar);
    	//caææ create Content
    	content = CreateContent(frame);
    	frame.setVisible(true);
    	DisableAllButtons();
    }
    
    private Container CreateContent(JFrame frame){
    	Container content = frame.getContentPane();
        content.setSize(400 ,400);
        content.setLayout(new BoxLayout(content, BoxLayout.LINE_AXIS));
        generateMill(content);
        return content;
    }
    
    private JFrame CreateFrame(JMenuBar menuBar){
    	//GUI DESIGN
    	JFrame frame;
    	frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(400 ,400);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    
    private JMenuBar CreateMenu(){
    	//MENU BAR SETUP //
    	JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenu modeMenu = new JMenu("Mode");
        gameMenu.setMnemonic('G');
        modeMenu.setMnemonic('M');

        MenuAction newma = new MenuAction("New");
        MenuAction exit = new MenuAction("Exit");
        MenuAction vsai = new MenuAction("VS AI");
        
		MenuAction twopl = new MenuAction("2 Player");
        JMenuItem item;
        item = gameMenu.add(newma);
        item.setMnemonic('N');
        item = gameMenu.add(exit);
        item.setMnemonic('E');
        item = modeMenu.add(vsai);
        item.setMnemonic('A');
        item = modeMenu.add(twopl);
        item.setMnemonic('T');

        menuBar.add(gameMenu);
        menuBar.add(modeMenu);
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
        return menuBar;
    }
    
    class MenuAction extends AbstractAction {
   
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MenuAction(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {
        	if(e.getActionCommand().toString().equals("Exit"))
        	{
        		int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit the game?", "Choose", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION)
				{ 
					GetStatistics();
					System.exit(0);
				}
        		
        	}
        	else
        	if (e.getActionCommand().toString().equals("New"))
        	{
        		NewGame();
        	}
        	else if(e.getActionCommand().toString().equals("VS AI"))
        	{
        		JOptionPane.showMessageDialog(null, "You have selected to play against superior intelligence");
        		if (HumanVsHuman) { StillPlaying = false; } 
        		HumanVsHuman = false;
        	}
        	else if(e.getActionCommand().toString().equals("2 Player"))
        	{
        		if (HumanVsHuman) {
        			int choice = JOptionPane.showConfirmDialog(null, "Do you want to change Player nicknames?");
        			if (choice == JOptionPane.YES_OPTION) { StillPlaying = false; }
        		}
        		
        		JOptionPane.showMessageDialog(null, "You have selected to play against another meat bag");
        		HumanVsHuman = true;
        	}
        	
            /*try { pane.getStyledDocument().insertString(0 ,
                  "Action ["+e.getActionCommand()+"] performed!\n", null);
            } catch (Exception ex) { ex.printStackTrace(); } */
        }
    }
    
    private void generateMill(Container contents) {
    	// Create some buttons
		GenerateGamePanelButton(b1 = new JButton(""));
		GenerateGamePanelButton(b2 = new JButton(""));
		GenerateGamePanelButton(b3 = new JButton(""));
		GenerateGamePanelButton(b4 = new JButton(""));
		GenerateGamePanelButton(b5 = new JButton(""));
		GenerateGamePanelButton(b6 = new JButton(""));
		GenerateGamePanelButton(b7 = new JButton(""));
		GenerateGamePanelButton(b8 = new JButton(""));
		GenerateGamePanelButton(b9 = new JButton(""));
		b1.setName("1");
		b2.setName("2");
		b3.setName("3");
		b4.setName("4");
		b5.setName("5");
		b6.setName("6");
		b7.setName("7");
		b8.setName("8");
		b9.setName("9");
        
        TTTpanel = new JPanel();
        TTTpanel.add(b1);
        TTTpanel.add(b2);
        TTTpanel.add(b3);
        TTTpanel.add(b4);
        TTTpanel.add(b5);
        TTTpanel.add(b6);
        TTTpanel.add(b7);
        TTTpanel.add(b8);
        TTTpanel.add(b9);
        
        contents.add(TTTpanel, BorderLayout.SOUTH);
    }
    
    private void DisableAllButtons(){
    	b1.setEnabled(false);
    	b2.setEnabled(false);
    	b3.setEnabled(false);
    	b4.setEnabled(false);
    	b5.setEnabled(false);
    	b6.setEnabled(false);
    	b7.setEnabled(false);
    	b8.setEnabled(false);
    	b9.setEnabled(false);
    }
    
    private void ClearAllButtons(){
    	b1.setEnabled(true);
    	b1.setText("");
    	b2.setEnabled(true);
    	b2.setText("");
    	b3.setEnabled(true);
    	b3.setText("");
    	b4.setEnabled(true);
    	b4.setText("");
    	b5.setEnabled(true);
    	b5.setText("");
    	b6.setEnabled(true);
    	b6.setText("");
    	b7.setEnabled(true);
    	b7.setText("");
    	b8.setEnabled(true);
    	b8.setText("");
    	b9.setEnabled(true);
    }
    
    private void GenerateGamePanelButton(JButton button){
		button.setPreferredSize(new Dimension(100, 100));
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				if(button.getText() == ""){
					ChangeButtonState(button);
				}
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 40));
		
	}
    
    private boolean ChangeButtonState(JButton button){
    	if (!button.isEnabled() || !button.getText().equals(""))
    	{
    		return false;
    	}
    	button.setText(String.valueOf(TTTGame.getNextMove()));
    	int row = -1;
		int columnt = -1;
		switch (button.getName().toString()) {
		case "1":
			row = 0;
			columnt = 0;
			break;
		case "2":
			row = 0;
			columnt = 1;
			break;
		case "3":
			row = 0;
			columnt = 2;
			break;
		case "4":
			row = 1;
			columnt = 0;
			break;
		case "5":
			row = 1;
			columnt = 1;
			break;
		case "6":
			row = 1;
			columnt = 2;
			break;
		case "7":
			row = 2;
			columnt = 0;
			break;
		case "8":
			row = 2;
			columnt = 1;
			break;
		case "9":
			row = 2;
			columnt = 2;
		}
		char lastPlayer = TTTGame.getNextMove();
		if (lastPlayer == 'O')
		{
			TTTGame.makeMove(p2, row, columnt);
		}
		else
		{
			TTTGame.makeMove(p1, row, columnt);
		}
		
		if (TTTGame.checkForWinner(lastPlayer))
		{
			GameOver(lastPlayer);
		}
		else
		if (TTTGame.boardIsFull())
		{
			GameOver('F');
		}
		
		if (!HumanVsHuman && lastPlayer == 'X' && !TTTGame.checkForWinner(lastPlayer) && !TTTGame.boardIsFull())
		{
			ComputersTurn();
		}
		return true;
    }
    private void ComputersTurn(){
    	int row = 0;
    	int column = 0;
    	JButton button = null;
    	do{
    		row = StdRandom.uniform(0, 3);
    		column = StdRandom.uniform(0, 3);
    		//StdOut.println(row);
    		//StdOut.println(column);
    	switch (row) {
		case 0:
				switch (column) {
				case 0:
						button = b1;
					break;
				case 1:
						button = b2;
					break;
				case 2:
						button = b3;
					break;
				default:
					break;
				}
			break;
		case 1:
				switch (column) {
				case 0:
						button = b4;
					break;
				case 1:
						button = b5;
					break;
				case 2:
						button = b6;
					break;
				default:
					break;
				}
			break;
		case 2:
				switch (column) {
				case 0:
						button = b7;
					break;
				case 1:
						button = b8;
					break;
				case 2:
						button = b9;
					break;
				default:
					break;
				}
			break;
		default:
			break;
		}
    	}while(!ChangeButtonState(button));
    }
    
    public void NewGame(){
    	ClearAllButtons();
    	TTTGame.newGame();
    	if (StillPlaying)
    	{
    		ClearAllButtons();
    	}
    	else
    	if (HumanVsHuman)
    	{
    		String p1Name = "";
    		String p2Name = "";
    		p1Name = JOptionPane.showInputDialog("Input Player 1 name");
    		p2Name = JOptionPane.showInputDialog("Input Player 2 name");
    		p1 = new HumanPlayer(p1Name, 'X');
    		p2 = new HumanPlayer(p2Name, 'O');
    		ClearAllButtons();
    	}
    	else
    	{
    		String p1Name = "";
    		p1Name = JOptionPane.showInputDialog("Input Player 1 name");
    		
    		p1 = new HumanPlayer(p1Name, 'X');
    		p2 = new ComputerPlayer('O');
    		ClearAllButtons();
    	}
    	StillPlaying = true;
    }
    
    private void GameOver(char lastPlayer){
		DisableAllButtons();
		if (lastPlayer == 'F')
		{
			JOptionPane.showMessageDialog(null, "No one is the winner you wankers!!");
		}
		else
		if (p1.getPlayer() == lastPlayer)
		{
			p1.setOneMoreWin();
			JOptionPane.showMessageDialog(null, p1.getNickname() + " is the winner !!!");
		}
		else
		{
			p2.setOneMoreWin();
			JOptionPane.showMessageDialog(null, p2.getNickname() + " is the winner !!!");
		}
		
	}
    
    private void GetStatistics(){
    	JOptionPane.showMessageDialog(null, p1.getNickname() + " has " + p1.getWinnings() + "\n" +
    									p2.getNickname() + " has " + p2.getWinnings());
    }
    
    public static void main(String s[]) {
    	new TTTGui();
    }
}

