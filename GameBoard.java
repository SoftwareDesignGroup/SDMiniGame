import java.awt.*;
import javax.swing.*;



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
				      return new Dimension(80, 80);
				    //Sets Dimensions 
				   };
    		};
    		
    	}
    }
	
	public Tile[] getTiles()
	{
		return tiles;
	}
	
	public boolean gameWon()
	{
		boolean won = true;
		for(int i = 0; i < tiles.length; i++)
		{
			if (!tiles[i].getIdentifier().equals("Tile_" + (i + 1)))
				won = false;
		}
		return won;
	}
}
