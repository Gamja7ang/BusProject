package BusProJect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

class MainInterFace extends JFrame implements ActionListener{
	private static final long serialVesionUID = 1L;
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JButton admin,b1,b2,b3; 
	ImageIcon logo;
	JLabel picLabel,l1,l2,l3;
	boolean flag = true;
	String name;
	public MainInterFace() {
	this.setTitle("Bus Manager");
	this.setBounds(300, 100, 1400,800);
	pan2.setLayout(null);
	control();
	this.setVisible(true);
	}//const

	private void control() {
		//logo
		logo = new ImageIcon("D:\\JAVA_LAB\\miniproject\\src\\BusProJect\\IMG\\logo.jpg");
		picLabel = new JLabel(logo);
		picLabel.setBounds(550, 0, 300, 300);
		
		////°ü¸®ÀÚ ·Î±×ÀÎ
		admin = new JButton("ADMIN");
		admin.setBounds(1000, 130, 100, 50);
		admin.setBackground(Color.ORANGE);
		//admin.setBorder(BorderFactory.createEmptyBorder(5,10,5,50));
		admin.setBorder(BorderFactory.createEtchedBorder(1));
		admin.setHorizontalAlignment(SwingConstants.CENTER);
		admin.setBorderPainted(false);
		
		////¹öÆ°
		b1 = new JButton(new ImageIcon("D:\\\\JAVA_LAB\\\\miniproject\\src\\BusProJect\\IMG\\bus1.jpg"));
		b1.setBounds(300, 250, 210, 210);
		b1.setBackground(Color.WHITE);
		b1.setBorderPainted(false);
		
		//b1.setBorder(BorderFactory.createBevelBorder(0));
		b1.addActionListener(this);
		b2 = new JButton(new ImageIcon("D:\\\\JAVA_LAB\\\\miniproject\\src\\BusProJect\\IMG\\ticket.jpg"));
		b2.addActionListener(this);
		b2.setBounds(600, 250, 210, 210);
		b2.setBackground(Color.WHITE);
		b2.setBorderPainted(false);
		//b2.setBorder(BorderFactory.createBevelBorder(0));
		
		b3 = new JButton(new ImageIcon("D:\\\\JAVA_LAB\\\\miniproject\\src\\BusProJect\\IMG\\terminal.jpg"));
		b3.addActionListener(this);
		b3.setBounds(900, 250, 210, 210);
		b3.setBackground(Color.WHITE);
		b3.setBorderPainted(false);
		//b3.setBorder(BorderFactory.createBevelBorder(0));
		
		//label
		l1 = new JLabel("BUS");
		l1.setBounds(350, 470, 100, 50);
		l1.setFont(new Font("³ª´®°íµñ", Font.BOLD,30));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
			
		l2 = new JLabel("TICKET");
		l2.setBounds(630, 470, 150, 50);
		l2.setFont(new Font("³ª´®°íµñ", Font.BOLD,30));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		
		l3 = new JLabel("TERMINAL");
		l3.setBounds(910, 470, 180, 50);
		l3.setFont(new Font("³ª´®°íµñ", Font.BOLD,30));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		//¹è°æ»ö
		pan2.setBackground(Color.WHITE);
		
		//pan2
		pan2.add(picLabel);
		pan2.add(admin);
		pan2.add(b1); pan2.add(b2); pan2.add(b3); //¹öÆ°¾ÆÀÌÄÜ
		pan2.add(l1); pan2.add(l2); pan2.add(l3); //label
		
		admin.addActionListener(this);
		this.getContentPane().add(pan2);
	}//control	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()== admin) {
			Administrator ad = new Administrator();
		}else if (arg0.getSource() == b1) {
			BusManag bm = new BusManag();
			this.setVisible(false);
		}else if (arg0.getSource() == b2) {
			Swing_ReservationInfo sr = new Swing_ReservationInfo();
			this.setVisible(false);
		}else if (arg0.getSource() == b3) {
			Swing_TerMinalInfo sr = new Swing_TerMinalInfo();
			this.setVisible(false);
		}
	}
}//mainmenu



public class MainInterFaceMain {
	static MainInterFace main;
	public static void main(String[] args) {
		main = new MainInterFace();
	}//main
}//class
