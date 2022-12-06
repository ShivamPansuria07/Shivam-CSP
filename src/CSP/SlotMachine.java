package CSP;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JLabel Kevin = new JLabel();
	JLabel White = new JLabel();
	JLabel Shakeri = new JLabel();
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	Random rand = new Random();
	int kevin = 0;
	int white = 0;
	int shakeri = 0;
	int wins = 0;
	JButton button = new JButton();

	public void run() {
		panel.add(button);
		frame.add(panel);
		panel.setSize(500, 600);
		frame.setTitle("Mr.Hare Machine");
		Kevin = createLabelImage("kevin.jpg");
		White = createLabelImage("white.jpg");
		Shakeri = createLabelImage("shakeri2.jpg");
		Kevin.setPreferredSize(new Dimension(100, 100));
		White.setPreferredSize(new Dimension(100, 100));
		Shakeri.setPreferredSize(new Dimension(100, 100));
		panel.add(Kevin);
		panel.add(White);
		panel.add(Shakeri);
		button.setText("Find Mr.Hare!");
		button.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Welcome to 'Mr.Hare Machine' Get 3 Mr.Hare's in a row to win!");
	}

	public JLabel createLabelImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
//d
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();

		if (buttonClicked == button) {

			frame.getContentPane().removeAll();
			panel = new JPanel();
			panel.add(button);
			white = 0;
			kevin = 0;
			shakeri = 0;
			for (int i = 0; i < 3; i++) {

				int pic = rand.nextInt(3);

				if (pic == 1) {
					JLabel image = createLabelImage("kevin.jpg");
					image.setPreferredSize(new Dimension(100, 100));
					panel.add(image);
					kevin++;

				}
				if (pic == 0) {
					JLabel image2 = createLabelImage("white.jpg");
					image2.setPreferredSize(new Dimension(100, 100));
					panel.add(image2);
					white++;
				}
				if (pic == 2) {
					JLabel image3 = createLabelImage("shakeri2.jpg");
					image3.setPreferredSize(new Dimension(100, 100));
					panel.add(image3);
					shakeri++;
				}
//lol
			}
			
				
			
			
			
			panel.setSize(500, 600);
			frame.add(panel);
			frame.pack();
			if (kevin == 3) {
				JOptionPane.showMessageDialog(null, "You Win! Nice job getting 3 Mr.Hare's in a row");
				wins++;
				frame.dispose();
			}
			if (white == 3) {
				JOptionPane.showMessageDialog(null, "You failed.");
				//wins++;
				frame.dispose();
			}
			if (shakeri == 3) {
				JOptionPane.showMessageDialog(null, "You failed.");
				//wins++;
				frame.dispose();
			}
			
		}

	}

}
