package CSP;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener, KeyListener {

	JPanel panel;
	JFrame frame;
	int MolesWhacked;
	int MolesMissed;
	JButton moleButton = new JButton();
	Random rand = new Random();
	Date startDate = null;

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
		Random rand = new Random();
		int i = rand.nextInt(5);
		if (startDate == null) {
			startDate = new Date();

		}
		if (buttonClicked != moleButton) {
			
			MolesMissed++;
			if (i == 1) {
				speak("Dont feel bad there are many people who have no talent");
				
			}
			if (i == 2) {
				speak("Are you always so stupid or is today a special occasion");
			}
			if (i == 3) {
				speak("You are living proof that someone can live without a brain");
			}
			if (i == 4) {
				speak("Brains arent everything in fact in your case theyre nothing");
			} else if (MolesMissed == 3) {
				JOptionPane.showMessageDialog(null, "You have missed 3 times, you have lost the game!");
				frame.dispose();
			}
		} else if (buttonClicked == moleButton) {
//			String filePath = "Whack.wav";
//			playMusic(filePath);
			MolesWhacked++;
			
			if (MolesWhacked == 5) {
				endGame(startDate, 5);
				frame.dispose();
			} else {
				frame.dispose();
				DrawButtons();
			}

			// frame.dispose();
		}
	}
	//Speak method taken from stack overflow
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

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}

	void playMusic(String musicLocation) {
		try {
			File musicPath = new File(musicLocation);
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				JOptionPane.showMessageDialog(null, "Press ok to stop playing music");
			}else {
				System.out.println("cant find file");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//			GamePanel gp = new GamePanel();
//			gp.currentState = gp.MENU;
//			gp.exitProgram(gp.currentState);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}