import java.awt.*;
import javax.swing.*;



//MAY OR MAY NOT BE DONE AS IS 
//I like the grid idea but dragging and dropping 
//or click and click to grid is a pain in the ass
//I was not able to solve it but ill keep working on it
class TileGrid extends JPanel{
	private GridLayout layout = new GridLayout(8,1);
	private JPanel grid;
	private Tile tiles[];
	private Tile resetTiles[];
	public TileGrid()
	{
		grid = new JPanel(layout);
		fillBoard();
	}
	
	public void fillBoard()
    {
		MazeImage img = new MazeImage();
		tiles = new Tile[16];
		resetTiles = new Tile[16];
    	for(int i = 0; i < tiles.length; i++)
    	{
    		tiles[i] = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(80, 80);
				    //Sets Dimensions 
				   };
    		};
    		//tiles[i].setText("Tile_" + (i + 1));
    		tiles[i].setIcon(img.getImage(i));
    		tiles[i].setIdentifier("Tile_" + (i + 1));
    		resetTiles[i] = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(80, 80);
				    //Sets Dimensions 
				   };
    		};
    		//resetTiles[i].setText("Tile_" + (i + 1));
    		resetTiles[i].setIcon(img.getImage(i));
    		resetTiles[i].setIdentifier("Tile_" + (i + 1));    		
    	}
    }
	
	public Tile[] getTiles()
	{
		return tiles;
	}
	
	public Tile[] getResetTiles()
	{
		return resetTiles;
	}
}
