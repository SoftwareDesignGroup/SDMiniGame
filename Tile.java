import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


//SUPER BASIC NEEDS MORE
public class Tile extends JButton{
	private JButton tile;
	private String identifier; //used to check if the game has been won
	public Tile()
	{
		tile = new JButton();
	}
	
	public void setIdentifier(String ident)
	{
		identifier = ident;
	}
	
	public String getIdentifier()
	{
		return identifier;
	}

}
