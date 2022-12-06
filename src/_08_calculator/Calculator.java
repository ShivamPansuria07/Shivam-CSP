package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {


	double multiply(double num1, double num2) {
		return num1 * num2;

	}

	double subtract(double num1, double num2) {
		return num1 - num2;
	}

	double divide(double num1, double num2) {
		return num1 / num2;
	}

	double add(double num1, double num2) {
		return num1 + num2;
	}

	JTextField num1 = new JTextField(20);
	JTextField num2 = new JTextField(20);
	JButton add = new JButton();
	JButton sub = new JButton();
	JButton mul = new JButton();
	JButton div = new JButton();
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();

	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(400, 250);
		panel.add(num1);
		panel.add(num2);
		panel.add(add);
		panel.add(sub);
		panel.add(mul);
		panel.add(div);
		add.setText("add");
		sub.setText("sub");
		mul.setText("mul");
		div.setText("div");
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		panel.add(label);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str1 = num1.getText();
		String str2 = num2.getText();
		double dnum = Double.parseDouble(str1);
		double dnum2 = Double.parseDouble(str2);
		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == mul) {

			System.out.println(str1 + " times " + str2 + " is " + multiply(dnum, dnum2));

		} else if (buttonClicked == sub) {
			System.out.println(str1 + " minus " + str2 + " is " + subtract(dnum, dnum2));
		}else if (buttonClicked == add) {
			System.out.println(str1 + " plus " + str2 + " is " + add(dnum, dnum2));
		}else {
			System.out.println(str1 + " divided by " + str2 + " is " + divide(dnum, dnum2));
		}

	}
}
