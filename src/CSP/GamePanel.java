package CSP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	int currentState = MENU;
	Font titleFont1;
	Font titleFont2, titleFont = new Font("Arial", Font.PLAIN, 12), titleFont21 = new Font("Corbel", Font.PLAIN, 45),
			subTitleFont = new Font("Calibri", Font.BOLD, 20);;


	public void paintComponent(Graphics g) {
// I tried to add different game states depending where the user is to quickly allow for the user to simply press a key to enter the menu
// but this didnt end up working which is why there are so many parts in my code where it checks if the current state is equal to the meny
		
			drawMenuState(g);
		


	}

	void drawMenuState(Graphics g) {
		int middle = (GamePanel.WIDTH / 2) + 140;
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		// g.setColor(Color.green);
		g.setFont(titleFont21);
		// g.drawImage(image, 0, 0, BattleBoats.WIDTH, BattleBoats.HEIGHT, null);

		g.setColor(Color.green);
		g.drawString("Shivam's Arcade", 105, 50);
		g.setFont(subTitleFont);
		g.setColor(Color.RED);
		g.drawString("Press enter to exit the arcade", 110, 500);
		g.setColor(Color.BLUE);
		g.drawString("Press shift for instructions", 135, 125);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);

		g.drawString("WhackAMole(Press C to start)", 155, 200);
		g.drawString("Mr.Hare Machine(Press V to start)", 155, 300);
		g.drawString("Jeopardy(Press B to start)", 155, 400);
		// g.drawString("Press enter to exit the arcade", 155, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (currentState == MENU) {
//			//updateMenuState();
//		} else if (currentState == GAME) {
//			
//		} else if (currentState == END) {
//			//updateEndState();
//		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

			
				JOptionPane.showMessageDialog(null,
						"Welcome to Shivam's Arcade. Press enter to exit a game and go back to the menu.");
			
			

		}
		if (e.getKeyCode() == KeyEvent.VK_V) {
			
			if (currentState == MENU) {
			new SlotMachine().run();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {

			if (currentState == MENU) {
				new WhackAMole().DrawButtons();
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_B) {

			if (currentState == MENU) {
				new Jeopardy().run();
			}

		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

		
				JOptionPane.showMessageDialog(null, "Thank you for visiting!");
				System.exit(currentState);
			
		}
	}

	void exitProgram(int cs) {
		System.exit(cs);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
