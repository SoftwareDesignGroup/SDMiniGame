import java.awt.*;
import java.util.Random;

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
	private int randSpot[];
	private Tile masterTiles[];
	private MazeImage img;
	public TileGrid()
	{
		grid = new JPanel(layout);
		fillBoard();
	}
	
	public void fillBoard()
    {
		MazeImage img = new MazeImage();
		randSpot = new int[16];
		tiles = new Tile[16];
		resetTiles = new Tile[16];
		masterTiles = new Tile[16];
		randomize();
    	for(int i = 0; i < tiles.length; i++)
    	{
    	    masterTiles[i] = new Tile(){
                public Dimension getPreferredSize() {
                      return new Dimension(80, 80);
                    //Sets Dimensions 
                   };
            };
            masterTiles[i].setIcon(img.getImage(i));
            masterTiles[i].setIdentifier("Tile_" + (i + 1));
            
    		tiles[i] = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(80, 80);
				    //Sets Dimensions 
				   };
    		};
    		//tiles[i].setText("Tile_" + (i + 1));
    		tiles[i].setIcon(img.getImage(randSpot[i]));
    		tiles[i].setIdentifier("Tile_" + (randSpot[i] + 1 ));
    		resetTiles[i] = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(80, 80);
				    //Sets Dimensions 
				   };
    		};
    		//resetTiles[i].setText("Tile_" + (i + 1));
    		resetTiles[i].setIcon(img.getImage(randSpot[i]));
    		resetTiles[i].setIdentifier("Tile_" + (randSpot[i] + 1));
    	
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
	
	public Tile[] getMasterTiles()
	{
	    return masterTiles;
	}
	
	public void randomizeResetTiles()
	{
	    MazeImage img = new MazeImage();
        resetTiles = new Tile[16];
        randomize();
      
        for(int i = 0; i < resetTiles.length; i++)
        {resetTiles[i] = new Tile(){
            public Dimension getPreferredSize() {
                return new Dimension(80, 80);
              //Sets Dimensions 
             };
      };
      //resetTiles[i].setText("Tile_" + (i + 1));
      resetTiles[i].setIcon(img.getImage(randSpot[i]));
      resetTiles[i].setIdentifier("Tile_" + (randSpot[i] + 1));
  
        }
        
	}
	
	// will randomize all 16 numbers 1-16 in the randSpot array
	private void randomize()
	{
	    int num = 0;
	    Random random = new Random();
	    int usedNums[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	    for(int i = 0; i < usedNums.length; i++)
	    {
	        num = random.nextInt(16);
	        while(usedNums[num] == num)
	        {
	            num = random.nextInt(16);
	        }
	        randSpot[i] = num;
	        usedNums[num] = num;
	    }   
	}
}

