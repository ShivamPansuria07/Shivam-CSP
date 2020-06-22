package _09_latest_tweet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LatestTweet {
	JTextField awnser = new JTextField(20);
	JButton button = new JButton();
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		
		button.setText("Search the Twitterverse");
		awnser.setSize(20, 20);
		frame.add(awnser);
		
		
	}

}
