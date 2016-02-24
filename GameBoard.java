import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;



//THIS IS A SKELETON IMPLEMENTATION OF GAMEBOARD
//THIS WILL PROBABLY HAVE TO CHANGE A LOT

class GameBoard extends JPanel{
	private JPanel board;
	//private JButton test;
	private GridLayout layout = new GridLayout(16,16);
	public GameBoard()
	{
		board = new JPanel(layout);
		
	}

}