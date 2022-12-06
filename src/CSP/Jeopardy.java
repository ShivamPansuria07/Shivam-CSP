package CSP;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton;
	private JPanel quizPanel;
	JFrame frame = new JFrame();
	boolean b1 = false;
	boolean b2 = false;
	boolean b3 = false;
	boolean b4 = false;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;

	public void run() {

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		frame.setVisible(true);

		frame.setTitle("CSP Jeapordy");

		JPanel Header = new JPanel();
		Header = createHeader("Questions about computer science!");

		quizPanel.add(Header);

		frame.add(quizPanel);
		
		firstButton = createButton("100");

		quizPanel.add(firstButton);
		secondButton = createButton("300");
		thirdButton = createButton("500");
		fourthButton = createButton("1000");
		thirdButton.setVisible(true);
		fourthButton.setVisible(true);

		quizPanel.add(secondButton);
		quizPanel.add(thirdButton);
		quizPanel.add(fourthButton);

		firstButton.addActionListener(this);
		secondButton.addActionListener(this);
		thirdButton.addActionListener(this);
		fourthButton.addActionListener(this);
		//lines 70-76 i found as a fix to an  error I had in my code source: stack overflow
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}

	private JButton createButton(String dollarAmount) {

		JButton button = new JButton();

		button.setText(dollarAmount);

		buttonCount++;

		return new JButton(dollarAmount);
	}

	public void actionPerformed(ActionEvent e) {
		
		buttonPressed = (JButton) e.getSource();
	//if all boolean variables are true(the user has done each question)
		

		if (buttonPressed == firstButton) {
			b1 = true;
			askQuestion("Who is the founder of computer science?", "Alan Turing", 100);
			firstButton.removeAll();

		}

		if (buttonPressed == secondButton) {
			b2 = true;
			askQuestion("Who is the best teacher at CCA?", "Mr.Hare", 300);

			secondButton.removeAll();
		}
		if (buttonPressed == thirdButton) {
			b3 = true;
			askQuestion("What is the name of one the two computer scientists that created the internet?", "Vinton Cerf",500);
			// BobKlahn is another answer for this question
			thirdButton.removeAll();
		}
		if (buttonPressed == fourthButton) {
			b4 = true;
			askQuestion("Who created ARPANET?", "DARPA", 1000);
			fourthButton.removeAll();
		}
		if(b1 && b2 && b3 && b4) {
			JOptionPane.showMessageDialog(null, "You final score is: "+score);
			frame.dispose();
		}
	}

	JButton buttonPressed;

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		String answer = JOptionPane.showInputDialog(null, question);


		if (answer.contains("Hare") && prizeMoney == 300 || answer.contains("hare") && prizeMoney == 300) {
			score += prizeMoney;
			JOptionPane.showMessageDialog(null, " You were correct!");
		} else if (!answer.contains("Hare") && prizeMoney == 300 || !answer.contains("hare") && prizeMoney == 300) {
			score -= prizeMoney;
			JOptionPane.showMessageDialog(null, "How dare you disrespect Mr.Hare like this");
		}
		if (correctAnswer.equalsIgnoreCase(answer) && prizeMoney == 500
				|| answer.equalsIgnoreCase("bob khlan") && prizeMoney == 500) {
			score += prizeMoney;
			JOptionPane.showMessageDialog(null, "You are correct, good job paying attention in CSP!");
		} else if (!correctAnswer.equalsIgnoreCase(answer) && prizeMoney == 500
				|| !answer.equalsIgnoreCase("bob khlan") && prizeMoney == 500) {
			score -= prizeMoney;
			JOptionPane.showMessageDialog(null, "Incorrect, you could've said Bob Khlan or Vinton Cerf!");
		}
		if (correctAnswer.equalsIgnoreCase(answer) && prizeMoney != 300 && prizeMoney != 500) {

			score += prizeMoney;

			JOptionPane.showMessageDialog(null, "You were correct!");
		} else if (!correctAnswer.equalsIgnoreCase(answer) && prizeMoney != 300 && prizeMoney != 500) {

			score -= prizeMoney;
			JOptionPane.showMessageDialog(null, "You were incorrect!");

		}

		updateScore();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	
//code taken from previous coding class
	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
