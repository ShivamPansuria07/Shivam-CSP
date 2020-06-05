package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chuckle_Clicker implements ActionListener {
	public static void main(String[] args) {

	}

	

		public void run() {

			
			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			frame.setVisible(true);
			frame.add(panel);
			button.setText("joke");
			button2.setText("punchline");
			makeButtons(button, button2);
			panel.add(button);
			panel.add(button2);
			button.addActionListener(this);
			button2.addActionListener(this);
		
			

			

		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// alternate way of doing code below --> if(e.getSource() == button){}
			

			JButton buttonClicked = (JButton) e.getSource();
			if (buttonClicked == button) {
				JOptionPane.showMessageDialog(null, "Why can’t you hear a pterodactyl in the bathroom?");
			} else if (buttonClicked == button2) {
				JOptionPane.showMessageDialog(null, "Because it has a silent pee.");
			}
			
		}

	

	{
	}

	void makeButtons(JButton button, JButton button2) {
	}

	JButton button = new JButton();

	JButton button2 = new JButton();

	
}