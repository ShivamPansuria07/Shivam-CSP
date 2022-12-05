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
	JLabel Cherry = new JLabel();
	JLabel Lime = new JLabel();
	JLabel Orange = new JLabel();
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	Random rand = new Random();
	int cherry = 0;
	int lime = 0;
	int orange = 0;
	int wins = 0;
	JButton button = new JButton();

	public void run() {
		panel.add(button);
		frame.add(panel);
		panel.setSize(500, 600);

		Cherry = createLabelImage("Cherry.png");
		Orange = createLabelImage("Orange.png");
		Lime = createLabelImage("Lime.png");
		Cherry.setPreferredSize(new Dimension(100, 100));
		Lime.setPreferredSize(new Dimension(100, 100));
		Orange.setPreferredSize(new Dimension(100, 100));
		panel.add(Cherry);
		panel.add(Orange);
		panel.add(Lime);

		button.setText("SPIN");
		button.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();

		if (buttonClicked == button) {

			frame.getContentPane().removeAll();
			panel = new JPanel();
			panel.add(button);
			cherry = 0;
			lime = 0;
			orange = 0;
			
			for (int i = 0; i < 3; i++) {

				int pic = rand.nextInt(3);

				if (pic == 0) {
					JLabel image = createLabelImage("Cherry.png");
					image.setPreferredSize(new Dimension(100, 100));
					panel.add(image);
					cherry++;

				}
				if (pic == 1) {

					JLabel image2 = createLabelImage("Lime.png");
					image2.setPreferredSize(new Dimension(100, 100));
					panel.add(image2);
					lime++;
				}
				if (pic == 2) {

					JLabel image3 = createLabelImage("Orange.png");
					image3.setPreferredSize(new Dimension(100, 100));
					panel.add(image3);
					orange++;
				}
//lol
			}
			if (cherry == 3) {
				JOptionPane.showMessageDialog(null, "You Win! Nice job getting 3 cherries in a row!");
				
				wins++;
			}
			if (lime == 3) {
				JOptionPane.showMessageDialog(null, "You Win! Nice job getting 3 limes in a row! ");
				wins++;
			}
			if (orange == 3) {
				JOptionPane.showMessageDialog(null, "You Win! Nice job getting 3 oranges in a row!");
				wins++;
			}
			
			
				if(wins>1) {	
					System.out.println("You have "+wins+" wins");
					
					}
			
			
			
			panel.setSize(500, 600);
			frame.add(panel);
			frame.pack();
			
		}

	}

}
