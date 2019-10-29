package BusProJect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Swing_BusManager extends BasicFrame implements ActionListener {
	private static final long serialVesionUID = 1L;
	JPanel pan1 = new JPanel();//exbar
	JPanel pan2 = new JPanel();//bt
	JButton bt1 = new JButton("운행정보관리");
	JButton bt2 = new JButton("매출정보관리");
	JButton logout = new JButton("로그아웃");
	public Swing_BusManager() {
		this.setTitle("BusGo");
		init();
		this.setVisible(true);
	}//const
	private void init() {
		pan2.setLayout(null);
		pan1.setBorder(new EmptyBorder(30, 50, 50, 50)); //(top, left, bottom, right)
		pan1.setBackground(Color.DARK_GRAY);
		pan1.setPreferredSize(new Dimension(1400,100));
		//버튼디자인영역 
		bt1.setPreferredSize(new Dimension(300, 100));
		bt2.setPreferredSize(new Dimension(300, 100));
		bt1.setForeground(Color.white);
		bt1.setFont(new Font("굴림", Font.BOLD, 20));
		bt1.setBackground(new Color(235, 111, 49));
		bt2.setForeground(Color.white);
		logout.setForeground(Color.white);
		bt2.setFont(new Font("굴림", Font.BOLD, 20));
		logout.setFont(new Font("굴림", Font.BOLD, 20));
		logout.setBackground(new Color(235, 111, 49));
		bt2.setBackground(new Color(235, 111, 49));
		pan2.add(logout);		
		pan2.add(bt1);		
		pan2.add(bt2);		
		bt1.setBounds(40, 30, 300, 80);
		bt2.setBounds(350, 30, 300, 80);
		logout.setBounds(1080, 670, 270, 50);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		logout.addActionListener(this);
		this.getContentPane().add(pan2,BorderLayout.CENTER);
		
	}//init
	public static void main(String[] args) {
		new Swing_BusManager();
	}//main
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//버튼
		if (arg0.getSource() == bt1) {
			Swing_BInPut sb = new Swing_BInPut();
			this.setVisible(false);		
		}else if (arg0.getSource() == bt2) {
			Data da = new Data();
			this.setVisible(false);
			
		}else if (arg0.getSource() == logout) {
			MainInterFace main = new MainInterFace();
			this.setVisible(false);
		}//elseif
		//콤보박스
		
	}
}//class