import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//RESET STILL NEEDS WORK
//It uses the dfault method in MiniGame
//I was thinking that reset could call that method which would 
//then reset only the tiles
public class Reset extends Button implements ActionListener{
	private Button bttn;
	public Reset()
	{
		bttn = new Button();
		//bttn.setLabel("Reset");
		bttn.addActionListener(this);
		bttn.setEnabled(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		MiniGame.dfault();
	}
	
}