package BusProJect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Swing_TerMinalInfo extends BasicFrame implements ActionListener{
	String path = "C:\\workspace\\src\\BusProJect\\IMG\\busmap\\stationimg\\";
	String path2 = "C:\\workspace\\src\\BusProJect\\IMG\\busmap\\";
	JButton bt = new JButton("배차정보조회");
	JButton bt2 = new JButton("예약조회");
	JButton bt3 = new JButton("터미널정보");
	JButton bt4 = new JButton("뒤로가기");
	JComboBox<String> comb;
	JPanel pane;
	JLabel lab,lab2;
	static String[] str = {"울산","부산","대구","대전","광주","서울"};
	ImageIcon[] img = {
			new ImageIcon(path+"1.jpg"),
			new ImageIcon(path+"2.jpg"),
			new ImageIcon(path+"3.jpg"),			
			new ImageIcon(path+"4.jpg"),
			new ImageIcon(path+"5.jpg"),
			new ImageIcon(path+"6.jpg")			
	};
	ImageIcon[] img2 = {
			new ImageIcon(path2+"1.jpg"),
			new ImageIcon(path2+"2.jpg"),
			new ImageIcon(path2+"3.jpg"),			
			new ImageIcon(path2+"4.jpg"),
			new ImageIcon(path2+"5.jpg"),
			new ImageIcon(path2+"6.jpg")			
	};
	public Swing_TerMinalInfo() {
		this.setTitle("JComboBox2");
		init();
		this.setVisible(true);
	}//const
	private void init() {
		lab2 = new JLabel(new ImageIcon(path2+"1.jpg"));		
		lab = new JLabel(new ImageIcon(path+"1.jpg"));		
		pane = new JPanel();	
		pane.setBackground(Color.WHITE);
		pane.setLayout(null);
		comb = new JComboBox<String>(str);
		comb.addActionListener(this); 
		bt.setBackground(new Color(235, 111, 49));
		bt2.setBackground(new Color(235, 111, 49));
		bt3.setBackground(new Color(235, 111, 49));
		bt4.setBackground(new Color(235, 111, 49));
		bt4.addActionListener(this);
		pane.add(bt);
		pane.add(bt2);
		pane.add(bt3);
		pane.add(bt4);
		pane.add(comb);
		pane.add(lab);
		pane.add(lab2);
		
		bt.setBounds(100,50,200,50);
		bt2.setBounds(450,50,200,50);
		bt3.setBounds(800,50,200,50);
		bt4.setBounds(1100,50,200,50);
		comb.setBounds(80, 250, 200, 50);
		lab.setBounds(450, 300, 300, 300);
		lab2.setBounds(900, 300, 300, 300);
		bt2.addActionListener(this);
		bt.addActionListener(this);
		
		this.getContentPane().add(pane);

	}//init
	public static void main(String[] args) {
		new Swing_TerMinalInfo();
	}//main
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt4) {
			BusManag bm = new BusManag();
			this.setVisible(false);
		}
		if (e.getSource() == bt) {
			BusManag bm = new BusManag();
			this.setVisible(false);
		}
		if (e.getSource() == bt2) {
			Swing_ReservationInfo sr = new Swing_ReservationInfo();
			this.setVisible(false);
		}
		if (e.getSource() == comb) {
			JComboBox<String> com = (JComboBox<String>) e.getSource();
			JComboBox<String> com2 = (JComboBox<String>) e.getSource();
			lab.setIcon(img[com.getSelectedIndex()]);
			lab2.setIcon(img2[com2.getSelectedIndex()]);
			
		}
	}
}//class
