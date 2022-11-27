package CSP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class guiRunner implements ActionListener {
	static JButton button1;
	static JButton button2;
public static void main(String[] args) {
	 button1 = new JButton();
	button2 = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	panel.add(button1);
	button1.setText("button1");
	button2.setText("button2");
	panel.add(button2);
	frame.add(panel);
	frame.setVisible(true);
	frame.setSize(100,100);

}
	@Override
	public void actionPerformed(ActionEvent e) {
		button1.addActionListener(this);
		button2.addActionListener(this);
		JButton buttonClicked = (JButton) e.getSource();
		if(buttonClicked== button1) {
			System.out.println("lol working");
		//	new WhackAMole().DrawButtons();
		}else if(buttonClicked == button2) {
			System.out.println("wow");
		
	}

	
	
}}


