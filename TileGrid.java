import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.JComponent;
import javax.swing.JPanel;



//MAY OR MAY NOT BE DONE AS IS 
//I like the grid idea but dragging and dropping 
//or click and click to grid is a pain in the ass
//I was not able to solve it but ill keep working on it
class TileGrid extends JPanel{
	private GridLayout layout = new GridLayout(8,1);
	private JPanel grid;
	private Tile tiles[];
	public TileGrid()
	{
		grid = new JPanel(layout);
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
    		tiles[i].setLabel("Tile_" + (i + 1));
    	}
    }
	
	public Tile[] getTiles()
	{
		return tiles;
	}
}
