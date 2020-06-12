package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	String value;
	JLabel label = new JLabel();
	JPanel panel = new JPanel();

	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	public void run() {
		JFrame frame = new JFrame();

		frame.setVisible(true);
		frame.add(panel);
		frame.setTitle("Type or Die");
		frame.setSize(200, 150);
		currentLetter = generateRandomLetter();
		value = "" + currentLetter;
		label.setText(value);
		panel.add(label);
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.addKeyListener(this);
		panel.setBackground(Color.WHITE);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		char KeyPressed = e.getKeyChar();
		
		if (KeyPressed == currentLetter) {
			
			panel.setBackground(Color.white);
			System.out.println("you typed: " + currentLetter);
		}
		if (KeyPressed == currentLetter) {
			panel.setBackground(Color.WHITE);
			System.out.println("Correct!");
			panel.setBackground(Color.GREEN);
		}else {
			panel.setBackground(Color.WHITE);
			System.out.println("incorrect");
			panel.setBackground(Color.RED);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char KeyReleased = e.getKeyChar();
		if (KeyReleased == currentLetter) {
			currentLetter = generateRandomLetter();
			value = "" + currentLetter;
			label.setText(value);
			

		}

	}

}
