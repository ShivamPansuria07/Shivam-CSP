package _05_typing_tutor;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor {
	  char currentLetter;
	

	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}
	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		frame.setVisible(true);
		frame.add(panel);
		frame.setTitle("Type or Die");
		frame.setSize(200, 150);
		currentLetter = generateRandomLetter();
		 String value = ""+currentLetter;
		label.setText(value);
		panel.add(label);
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
	}

}
