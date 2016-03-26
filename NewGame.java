import java.awt.Button;
import java.awt.Frame;
import java.awt.event.*;




//NEW GAME BUTTON IS FINSIHED AS IS
public class NewGame extends Button implements ActionListener{
	private Button bttn;
	public NewGame()
	{
		bttn = new Button();
		bttn.addActionListener(this);
		bttn.setEnabled(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Prevents multiple windows from being open
		//this way when you select new game you always have only 
		//one instance of the MiniGame Object running
		MiniGame game = new MiniGame();
		Frame [] numframe = game.getFrames();
		if(numframe.length > 1)
		{
			for(int i = 1; i<numframe.length-1; i++){
				numframe[i].dispose();
			}
		}
	}
};