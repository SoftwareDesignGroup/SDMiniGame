import java.awt.Button;

import javax.swing.JOptionPane;

public class Solve extends Button{
	private Button bttn;
	private TileGrid winningTiles;
	public Solve()
	{
		bttn = new Button();
		bttn.setEnabled(true);
		winningTiles = new TileGrid();
	}
	
	public TileGrid getWinningTiles()
	{
		return winningTiles;
	}
}
