import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MiniGame extends Frame implements ActionListener
{
	private GameBoard gb;
	private ButtonGrid bgrid;
	private TileGrid tgrid0_7;
	private TileGrid tgrid8_16;
	private NewGame newgame;
	private Quit quit;
	private Reset reset;
	private Solve solve;
	private JFrame window;
	private Tile tilesToSwap[];
	private final Dimension BTTNDIMENSION = new Dimension(125,50);
	private final Dimension BGRIDSIZE = new Dimension(0, 65);
	private final Dimension BORDERSIZE = new Dimension(0, 100);
	private final Dimension TGRIDSIZE = new Dimension(175, 0);
	private final Dimension GBSIZE = new Dimension(400, 400);
	
	public MiniGame()
	{
	    
	 
		tilesToSwap = new Tile[2];
		
		newgame = new NewGame();
		newgame.setPreferredSize(BTTNDIMENSION);
		newgame.setLabel("New Game");
		newgame.addActionListener(newgame);
		
		//-----------------------------------------------------		
		
		quit = new Quit();
		quit.setPreferredSize(BTTNDIMENSION);
		quit.setLabel("Quit");
		quit.addActionListener(quit);
		
		//-----------------------------------------------------		
		
		reset = new Reset();
		reset.setPreferredSize(BTTNDIMENSION);
		reset.setLabel("Reset");		
		reset.addActionListener(this);
		
		//-----------------------------------------------------	
		
		solve = new Solve();
		solve.setPreferredSize(BTTNDIMENSION);
		solve.setLabel("Solve");
		solve.addActionListener(this);
		
		//-----------------------------------------------------

		bgrid = new ButtonGrid();
		bgrid.setPreferredSize(BGRIDSIZE);
		
		bgrid.add(newgame).setLocation(1, 1);
		bgrid.add(quit).setLocation(1, 2);
		bgrid.add(reset).setLocation(1,3);
		bgrid.add(solve).setLocation(1, 4);
		bgrid.setBackground(new Color(127,23,52));
		
		insertGameTiles();
		
		//-----------------------------------------------------
		
		JPanel border = new JPanel();
		border.setPreferredSize(BORDERSIZE);
		border.setBackground(new Color(127,23,52));
		
		//------------------------------------------------------
		
		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(new Color(243,229,171));
		gamePanel.setLayout(new GridBagLayout());
		gamePanel.add(gb,new GridBagConstraints());
		
		//All of this is for proper centering 
		
		//-------------------------------------------------------------
		
		window = new JFrame();
		window.setLayout(new BorderLayout());
		window.setSize(800,650);
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
		x = t1.getIdentifier();
		t1.setIdentifier(t2.getIdentifier());
		t2.setIdentifier(x);
		String y;
		y = t1.getText();
		t1.setText(t2.getText());
		t2.setText(y);
		//ImageIcon y = new ImageIcon();
		//y = (ImageIcon) t1.getIcon();
		//t1.setIcon(t2.getIcon());
		//t2.setIcon(y);
		t1.setBorder(UIManager.getBorder("Button.border"));
		t2.setBorder(UIManager.getBorder("Button.border"));
		
	}
	
	public  void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "Reset")
		{
		    tgrid0_7.randomizeResetTiles();
            tgrid8_16.randomizeResetTiles();
			for(int i = 0; i < gb.getTiles().length; i++)
			{
			    
				//gb.getTiles()[i].setIcon(null);
				gb.getTiles()[i].setIdentifier(null);
				gb.getTiles()[i].setText(null);
				if(i < 8)
				{
					tgrid0_7.getTiles()[i].setIdentifier(tgrid0_7.getResetTiles()[i].getIdentifier());
					tgrid0_7.getTiles()[i].setText(tgrid0_7.getResetTiles()[i].getText());
					//tgrid0_7.getTiles()[i].setIcon(tgrid0_7.getResetTiles()[i].getIcon());
				}
				else
				{
					tgrid8_16.getTiles()[i].setIdentifier(tgrid8_16.getResetTiles()[i].getIdentifier());
					tgrid8_16.getTiles()[i].setText(tgrid0_7.getResetTiles()[i].getText());
					//tgrid8_16.getTiles()[i].setIcon(tgrid8_16.getResetTiles()[i].getIcon());
				}
			}
		}
		else if(e.getActionCommand() == "Solve")
		{
			for(int i = 0; i < gb.getTiles().length; i++)
			{
				//tgrid0_7.getTiles()[i].setIcon(null);
				//tgrid8_16.getTiles()[i].setIcon(null);
				tgrid0_7.getTiles()[i].setText(null);
                tgrid8_16.getTiles()[i].setText(null);
				//gb.getTiles()[i].setIcon(solve.getWinningTiles().getMasterTiles()[i].getIcon());
				gb.getTiles()[i].setIdentifier(solve.getWinningTiles().getMasterTiles()[i].getIdentifier());
				gb.getTiles()[i].setText(solve.getWinningTiles().getMasterTiles()[i].getText());
			}
			gameWon();
		}
		else
		{
			if(tilesToSwap[0] == null)
			{
				Border border = new LineBorder(Color.blue, 3);
				tilesToSwap[0] = (Tile) e.getSource();
				tilesToSwap[0].setBorder(border);
			}
			else 
			{
				tilesToSwap[1] = (Tile) e.getSource();
				swapTiles(tilesToSwap[0], tilesToSwap[1]);
				tilesToSwap[0] = null;
				tilesToSwap[1] = null;
				gameWon();
			}			
		}
	}
	
	public void gameWon()
	{
		if(gb.gameWon())
		{
			JOptionPane won = new JOptionPane();
			won.showMessageDialog(null, "You Win!");
		}
	}
	
	public void insertGameTiles()
	{
        
		tgrid0_7 = new TileGrid();
		tgrid0_7.setPreferredSize(TGRIDSIZE);
		tgrid0_7.setBackground(new Color(127,23,52));	
		
		tgrid8_16 = new TileGrid();
		tgrid8_16.setPreferredSize(TGRIDSIZE);
	    tgrid8_16.setBackground(new Color(127,23,52));	
		
		gb = new GameBoard();
		gb.setPreferredSize(GBSIZE);
		gb.setBackground(new Color(243,229,171));
		
		for(int i = 0; i < 8; i++)
		{
			tgrid0_7.getTiles()[i].addActionListener(this);
			tgrid0_7.add(tgrid0_7.getTiles()[i]);
		}
		
		for(int i = 8; i < 16; i++)
	    {
	    	tgrid8_16.getTiles()[i].addActionListener(this);
			tgrid8_16.add(tgrid8_16.getTiles()[i]);
	    }
		
		for(int i = 0; i < gb.getTiles().length; i++)
		{
			gb.getTiles()[i].addActionListener(this);
			gb.add(gb.getTiles()[i]);
		}
	}
	
	public static void main(String[] args)
	{
		MiniGame minigame = new MiniGame();		
	}
}
