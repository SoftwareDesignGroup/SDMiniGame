import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JPanel;



//MAY OR MAY NOT BE DONE AS IS 
//I like the grid idea but dragging and dropping 
//or click and click to grid is a pain in the ass
//I was not able to solve it but ill keep working on it
class TileGrid extends JPanel{
	private GridLayout layout = new GridLayout(8,1);
	private JPanel grid;
	public TileGrid()
	{
		grid = new JPanel(layout);
		
	}
}