package _07_fortune_teller;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

public class FortuneTellerRunner {
    public static void main(String[] args) throws Exception {
      	 SwingUtilities.invokeLater(new FortuneTeller());
      	 begin();
       }
    
    static void begin() {
      	 // Welcome the user. Give them a hint for the secret location.
    	JOptionPane.showMessageDialog(null, "Welcome to the FortuneTeller, to find the secret location look into the shadows were you shall find the location");
    }
}
