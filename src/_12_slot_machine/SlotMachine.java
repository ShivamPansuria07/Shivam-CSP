package _12_slot_machine;

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
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JLabel Cherry = new JLabel();
	JLabel Lime = new JLabel();
	JLabel Orange = new JLabel();
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	Random rand = new Random();

	JButton button = new JButton();

	public void run() {
		panel.add(button);
		frame.add(panel);
		panel.setPreferredSize(new Dimension(900, 900));
		frame.setPreferredSize(new Dimension(900, 900));

		Cherry = createLabelImage("Cherry.png");
		Orange = createLabelImage("Orange.png");
		Lime = createLabelImage("Lime.png");
		Cherry.setPreferredSize(new Dimension(200, 200));
		Lime.setPreferredSize(new Dimension(300, 300));
		Orange.setPreferredSize(new Dimension(200, 200));
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
			panel = new JPanel();
			for (int i = 0; i < 3; i++) {
				
				int pic = rand.nextInt(4);
				if (pic == 1) {
						JLabel image = createLabelImage("Cherry.png");
						image.setPreferredSize(new Dimension(100,100));
					panel.add(image);
					
					
				}
				if (pic == 2) {
					
					JLabel image2 = createLabelImage("Lime.png");
					image2.setPreferredSize(new Dimension(100,100));
					panel.add(image2);
				}
				if (pic == 3) {
					
					JLabel image3 = createLabelImage("Orange.png");
					image3.setPreferredSize(new Dimension(100,100));
					panel.add(image3);
				}

			}
			panel.add(button);
			panel.setPreferredSize(new Dimension(900, 900));
			frame.setPreferredSize(new Dimension(900, 900));
			frame.add(panel);
			frame.pack();
		}

	}

}
