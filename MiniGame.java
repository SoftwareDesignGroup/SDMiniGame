import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MiniGame extends Frame implements ActionListener
{
	private GameBoard gb;
	private ButtonGrid bgrid;
	private TileGrid tgrid0_7;
	private TileGrid tgrid8_16;
	private NewGame newgame;
	private Quit quit;
	private Reset reset;
	private JFrame window;
	private Tile tilesToSwap[];
	
	public MiniGame()
	{
		tilesToSwap = new Tile[2];
		newgame = new NewGame(){
			public Dimension getPreferredSize() {
			      return new Dimension(125, 50);
			      //Sets Dimensions
			   };

		};
		newgame.setLabel("New Game");
		newgame.addActionListener(newgame);
		//-----------------------------------------------------
		
		
		quit = new Quit(){
			public Dimension getPreferredSize() {
			      return new Dimension(125, 50);
			    //Sets Dimensions
			};
		};
		quit.setLabel("Quit");
		quit.addActionListener(quit);
		//-----------------------------------------------------
		
		
		
		reset = new Reset(){
			public Dimension getPreferredSize() {
			      return new Dimension(125, 50);
			    //Sets Dimensions
			   };
		};
		reset.setLabel("Reset");
		reset.addActionListener(reset);
		//-----------------------------------------------------
		
		
		

		bgrid = new ButtonGrid(){
			public Dimension getPreferredSize() {
			      return new Dimension(0, 65);
			    //Sets Dimensions
			   };
	
		};
		bgrid.add(newgame).setLocation(1, 1);
		bgrid.add(quit).setLocation(1, 2);
		bgrid.add(reset).setLocation(1,3);
		bgrid.setBackground(new Color(127,23,52));
		//-----------------------------------------------------
		
		
		
		
		tgrid0_7 = new TileGrid(){
			public Dimension getPreferredSize() {
			      return new Dimension(110, 0);
			    //Sets Dimensions
			   };
		};
		tgrid0_7.setBackground(new Color(127,23,52));
		/*for(int i=1; i<9; i++)
		{
			Tile tile = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(90, 45);
				    //Sets Dimensions
				   };
			};
			tile.setLabel("Tile_"+i);
			tgrid0_7.add(tile);
			//Just For ShowCase
		}*/
		for(int i = 0; i < 8; i++)
		{
			tgrid0_7.getTiles()[i].addActionListener(this);
			tgrid0_7.add(tgrid0_7.getTiles()[i]);
		}
		//-----------------------------------------------------
		
		
		
		
		tgrid8_16 = new TileGrid(){
			public Dimension getPreferredSize() {
			      return new Dimension(110, 0);
			    //Sets Dimensions
			   };
		};
	    tgrid8_16.setBackground(new Color(127,23,52));
		/*for(int i=9; i<17; i++)
		{
			Tile tile = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(90, 45);
				    //Sets Dimensions
				   };
			};
			tile.setLabel("Tile_"+i);
			tgrid8_16.add(tile);
			//Just For ShowCase
		}*/
	    for(int i = 8; i < 16; i++)
	    {
	    	tgrid8_16.getTiles()[i].addActionListener(this);
			tgrid8_16.add(tgrid8_16.getTiles()[i]);
	    }
		//-----------------------------------------------------
		
		
		
		
		
		gb = new GameBoard(){
			public Dimension getPreferredSize() {
			      return new Dimension(400,400);
			    //Sets Dimensions
			   };
		};
		gb.setBackground(new Color(243,229,171));
		/*for(int i=0; i<16; i++)
		{
			Tile tile = new Tile(){
				public Dimension getPreferredSize() {
				      return new Dimension(90, 45);
				    //Sets Dimensions 
				   };
			};

			gb.add(tile);
			//Just For ShowCase
		}*/
		for(int i = 0; i < gb.getTiles().length; i++)
		{
			gb.getTiles()[i].addActionListener(this);
			gb.add(gb.getTiles()[i]);
		}
		//-----------------------------------------------------
		
		JPanel border = new JPanel(){    
			 public Dimension getPreferredSize() {
			      return new Dimension(0, 100);
			      //Sets Dim of South Border
			   };
		};
		border.setBackground(new Color(127,23,52));
		//------------------------------------------------------
		
		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(new Color(243,229,171));
		gamePanel.setLayout(new GridBagLayout());
		gamePanel.add(gb,new GridBagConstraints());
		//All of this is for proper centering but still has issues
		
		//-------------------------------------------------------------
		
		window = new JFrame();
		window.setLayout(new BorderLayout());
		window.setSize(650,650);
		window.getContentPane().setBackground(new Color(243,229,171));
		window.getContentPane().setForeground(new Color(243,229,171));
		
		window.add(bgrid,BorderLayout.NORTH);
		window.add(tgrid0_7,BorderLayout.WEST);
		window.add(tgrid8_16,BorderLayout.EAST);
		window.add(gamePanel, BorderLayout.CENTER);
		window.add(border,BorderLayout.SOUTH );
		
		
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		window.setVisible(true);
		
	
	}
	
	public void swapTiles(Tile t1, Tile t2)
	{
		String x;
		x = t1.getLabel();
		t1.setLabel(t2.getLabel());
		t2.setLabel(x);
	}
	
	public  void actionPerformed(ActionEvent e)
	{
		if(tilesToSwap[0] == null)
			tilesToSwap[0] = (Tile) e.getSource();
		else 
		{
			tilesToSwap[1] = (Tile) e.getSource();
			swapTiles(tilesToSwap[0], tilesToSwap[1]);
			tilesToSwap[0] = null;
			tilesToSwap[1] = null;
		}
	}
	
	public static void dfault() //For Reset Button this will eventually change
	{
		JOptionPane reset = new JOptionPane();
		reset.showMessageDialog(null, "Game has been reset!");
	}
	
	public static void main(String[] args)
	{
		MiniGame minigame = new MiniGame();
		
	}
}
