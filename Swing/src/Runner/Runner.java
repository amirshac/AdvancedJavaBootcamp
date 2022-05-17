package Runner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Runner {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		
		label.setText("Hello");
		
		frame.setTitle("JFRAME TEST");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(420,420);
		frame.setVisible(true);
		frame.add(label);
		
		
	}

}
