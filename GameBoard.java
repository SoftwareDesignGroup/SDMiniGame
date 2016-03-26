import java.awt.*;
import javax.swing.*;



//THIS IS A SKELETON IMPLEMENTATION OF GAMEBOARD
//THIS WILL PROBABLY HAVE TO CHANGE A LOT

class GameBoard extends JPanel{
	private JPanel board;
	private Tile tiles[];
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gbCon = new GridBagConstraints();
	//private GridLayout layout = new GridLayout(16,16);
	private final Dimension TILESIZE = new Dimension(80,80);
	public GameBoard()
	{
	  gbCon.weightx = 1;
	  gbCon.weighty = 1;
       board = new JPanel(layout);
       fillBoard();
	}
	
	public void fillBoard()
    {
		tiles = new Tile[16];
    	for(int i = 0; i < tiles.length; i++)
    	{
    		tiles[i] = new Tile();
    		tiles[i].setPreferredSize(TILESIZE);
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
