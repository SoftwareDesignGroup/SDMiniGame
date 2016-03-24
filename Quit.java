import java.awt.Button;
import java.awt.event.*;

//QUIT IS FINISHED AS IS
public class Quit extends Button implements ActionListener{
	private Button bttn;
	public Quit()
	{
		bttn = new Button();
		bttn.addActionListener(this);
		bttn.setEnabled(true);
	}
	public  void actionPerformed(ActionEvent e)
	{
		//Kill everything on quit
		System.exit(0);
	}
}