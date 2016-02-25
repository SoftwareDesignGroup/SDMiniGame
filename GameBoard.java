import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;



//THIS IS A SKELETON IMPLEMENTATION OF GAMEBOARD
//THIS WILL PROBABLY HAVE TO CHANGE A LOT

class GameBoard extends JPanel{
	private JPanel board;
	private Tile tiles[];
	private GridLayout layout = new GridLayout(16,16);
	public GameBoard()
	{
		board = new JPanel(layout);
		fillBoard();
	}
	
	public void fillBoard()
    {
		tiles = new Tile[16];
    	for(int i = 0; i < tiles.length; i++)
    	{
    		tiles[i] = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(90, 45);
				    //Sets Dimensions 
				   };
    		};
    	}
    }
	
	public Tile[] getTiles()
	{
		return tiles;
	}
}
