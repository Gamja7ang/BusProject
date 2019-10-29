package BusProJect;

import javax.swing.JFrame;

public class BasicFrame extends JFrame {
	public BasicFrame() {
		this.setTitle("BusGo");
		this.setBounds(300, 100, 1400, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//const
	public static void main(String[] args) {
		new BasicFrame();
	}//main

}//class
