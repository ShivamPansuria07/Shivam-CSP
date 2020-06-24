package _11_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {

	JPanel panel; 
	JFrame frame; 
	JButton moleButton = new JButton();
	Random rand =  new Random();
	void DrawButtons() {
		
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		int random = rand.nextInt(25);
		
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setTitle("Whack a Button for Fame and Glory");
		for (int i = 1; i < 25; i++) {
			JButton button = new JButton();
			panel.add(button);
			button.addActionListener(this);
			if (random == i) {
				
				button.setText("mole!");
				moleButton = button;
			}
		}

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked != moleButton) {
			speak("You missed the mole Button!");

		} else if (buttonClicked == moleButton) {
		frame.dispose();
		DrawButtons();
		
			// frame.dispose();
		}
	}

	static void speak(String words) {
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
