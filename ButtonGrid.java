import java.awt.GridLayout;

import javax.swing.JPanel;




//THIS IS A SKELETON IMPLEMENTATION OF BUTTON GRID
class ButtonGrid extends JPanel{
	private JPanel grid;
	public GridLayout layout = new GridLayout(3,1);
	public ButtonGrid()
	{
		grid = new JPanel(layout);
		
	}
}