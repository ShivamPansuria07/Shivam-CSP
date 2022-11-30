package CSP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont1;
	Font titleFont2, titleFont = new Font("Arial", Font.PLAIN, 12), titleFont21 = new Font("Arial", Font.PLAIN, 35);
	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawMenuState(g);
		}
		else if (currentState == GAME) {
			System.out.println("game state");
			//drawGameState(g);

		} else if (currentState == END) {
			//drawEndState(g);
		}
//j
	}
	void drawMenuState(Graphics g) {
		int middle = (GamePanel.WIDTH/2)+140;
		g.setColor(Color.green);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.green);
		g.setFont(titleFont21);
		// g.drawImage(image, 0, 0, BattleBoats.WIDTH, BattleBoats.HEIGHT, null);
	
		g.setColor(Color.BLACK);
		g.drawString("Shivam's Arcade", 110, 50);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Press the following key to play each game", middle, 100);

		g.drawString("WhackAMole(Press C to start)", 155, 200);
		g.drawString("SlotMachine(Press V to start)", 155, 300);
		g.drawString("Jeopardy(Press B to start)", 155, 400);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == MENU) {
				currentState = GAME;
			}

			} 
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
