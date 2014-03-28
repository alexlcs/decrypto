package decrypto;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;

public class decrypto extends JFrame{
	public decrypto(){
		String s;

		// Initialize handlers:
		CharHandler charHandler = new CharHandler();
		TextHandler textHandler = new TextHandler();

		// Panels:
		JPanel upperBig = new JPanel(new FlowLayout());
		JPanel upper = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new GridLayout(2,13, 0, 20));
		JPanel lower = new JPanel();

		// Create text fields, labels, text fields:
		JTextField input = new JTextField(60);
		JTextField output = new JTextField(60);
		JLabel labelArray [] = new JLabel[26];
		JTextField textArray [] = new JTextField[26];

		// Assign handler to input text field:
		input.addActionListener(textHandler);

		// Add content to upper panel:
		upper.add(input, BorderLayout.NORTH);
		upper.add(new JLabel(" "));
		upper.add(output, BorderLayout.SOUTH);
		upperBig.add(upper);

		// Add content to middle panel:
		middle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for(int i=0; i<26; i++){
			// Initialize label:
			s = " " + Character.toString((char)(i+97)) + ":";
			labelArray[i] = new JLabel(s);

			// Initialize text fields:
			textArray[i] = new JTextField(1);
			textArray[i].addActionListener(charHandler);
		}

		// Add labels and text field to the panel:
		for(int i=0; i<26; i++){
			middle.add(labelArray[i]);
			middle.add(textArray[i]);
		}

		// Add content to lower panel:
		lower.add(new JLabel(" "));

		// Add panels to the frame:
		add(upperBig, BorderLayout.NORTH);
		add(middle);
		add(lower, BorderLayout.SOUTH);
	}

	public static void main(String [] args){
		JFrame f = new decrypto();
		f.setTitle("Decrypto");
		f.setSize(700, 180);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
	}
}

// Handle input text field:
class TextHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("char field");
	}
}

// Handle input char fields:
class CharHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("input");
	}
}

