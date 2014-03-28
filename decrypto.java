import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;

public class decrypto extends JFrame{

	// Create text fields
	private JTextField input = new JTextField(95);
	private JTextField output = new JTextField(95);
	private JTextField textArray [] = new JTextField[26];

	public decrypto(){

		String s;

		// Style text fields:
		input.setFont(new Font("Monospaced", Font.PLAIN, 12));
		output.setFont(new Font("Monospaced", Font.PLAIN, 12));
		output.setEditable(false);

		// Initialize handlers:
		CharHandler charHandler = new CharHandler();
		TextHandler textHandler = new TextHandler();

		// Panels:
		JPanel upperBig = new JPanel(new FlowLayout());
		JPanel upper = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new GridLayout(2,13, 0, 20));
		JPanel lower = new JPanel();

		// Create text labels:
		JLabel labelArray [] = new JLabel[26];

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

	// Handle input text field:
	class TextHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s = input.getText();
			String s2 = "";
			int len = s.length();
			for(int i=0; i<len; i++){
				s2 += '-';
			}
			output.setText(s2);
		}
	}

	// Handle input char fields:
	class CharHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// Get text from text in/out-put text fields:
			String in = input.getText();
			String out = output.getText();
			int len = in.length();
			char c = ' ';

			// Create two arrays for in/out-put strings:
			char inarr []= new char[len];
			char outarr[] = new char[len];

			// Copy two strings to arrays:
			for(int i=0; i<len; i++){
				inarr[i] = in.charAt(i);
				outarr[i] = out.charAt(i);
			}

			// Modify output:
			for(int i=0; i<len; i++){
				for(int j=0; j<26; j++){
					if(inarr[i] == Character.toString((char)(j+97)).charAt(0)){
						try{
							outarr[i] = textArray[j].getText().charAt(0);
						}catch(Exception ex){
							outarr[i] = '-';
							continue;
						}
					}
				}
			}

			// Set output to decrypted string:
			String result = new String(outarr);
			output.setText(result);
		}
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





