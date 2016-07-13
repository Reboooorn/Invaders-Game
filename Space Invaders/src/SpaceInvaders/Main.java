package SpaceInvaders;

import java.awt.Container;

import javax.swing.JFrame;


public class Main extends JFrame  {
	public Main() {
		setTitle("Space Invaders Game 2016.07.09");

		MainPanel panel = new MainPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);

		setResizable(false);

		pack();
	}


	public static void main(String[] args) {
		
		Main frame = new Main();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
