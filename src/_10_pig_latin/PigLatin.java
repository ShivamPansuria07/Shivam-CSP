package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatin implements ActionListener {
	
	PigLatinTranslator pig = new PigLatinTranslator();
	JTextField str1 = new JTextField(20);
	JTextField str2 = new JTextField(20);
	JButton button = new JButton();
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	
	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600, 90);
		button.setText("Translate");
		str1.setSize(20, 20);
		str2.setSize(20, 20);
		panel.add(str1);
		panel.add(str2);
		frame.setTitle("Shivam's Pig Latin translator");
		panel.add(button);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if(buttonClicked == button) {
		String text = str1.getText();
		str2.setText(pig.translate(text));
		frame.pack();
			
			
		}
		
	}

}
