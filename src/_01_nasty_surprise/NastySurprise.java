package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


	public class NastySurprise implements ActionListener {
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(button1);
		button1.setText("Trick");
		button2.setText("Treat");
		panel.add(button2);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(100,100);
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		button1.addActionListener(this);
		JButton buttonClicked = (JButton) e.getSource();
		if(buttonClicked== button1) {
			showPictureFromTheInternet("https://images-na.ssl-images-amazon.com/images/I/41dbm1LQNWL._AC_SX466_.jpg");
		}else if(buttonClicked == button2) {
			showPictureFromTheInternet("https://static-23.sinclairstoryline.com/resources/media/d60d4f1c-9fcc-4ae4-8058-05e885080e19-large16x9_momo2.PNG?1551379953599");
		}
		
		
	}



private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}}