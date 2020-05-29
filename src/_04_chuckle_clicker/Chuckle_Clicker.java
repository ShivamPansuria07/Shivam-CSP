package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chuckle_Clicker {
	
public static void main(String[] args) {
		
	}
void run(){
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
frame.setVisible(true);
frame.add(panel);
button.setText("joke");
button2.setText("punchline");
makeButtons(button,button2);
panel.add(button);
panel.add(button2);


}
public class ChuckleClicker implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		button.addActionListener(this);
		button2.addActionListener(this);
		if(buttonClicked== button) {
			System.out.println("f");
			JOptionPane.showMessageDialog(null, "hi");
		}else if(buttonClicked== button2) {
			System.out.println("f");
			JOptionPane.showMessageDialog(null, "hi");
		}
	}
}
void makeButtons(JButton button,JButton button2) {}
JButton button = new JButton();

JButton button2 = new JButton();

}