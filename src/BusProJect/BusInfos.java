package BusProJect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.glass.events.WindowEvent;

public class BusInfos extends JFrame implements ActionListener {
	static String path = "C:\\workspace\\src\\BusProJect\\TimeInfo\\";
	private static final long serialVersionUID = 1L;
	JPanel pan = new JPanel(new GridLayout(2, 2));
	JPanel pan1 = new JPanel();
	JLabel lab1 = new JLabel("버스이름");
	JLabel lab2 = new JLabel("출발지점");
	JLabel lab3 = new JLabel("도착지점");
	JLabel lab4 = new JLabel("출발시간");
	JLabel lab7 = new JLabel("도착시간");
	JLabel lab6 = new JLabel("소요시간");
	JLabel lab5 = new JLabel("버스등급");
	JTextField tx1 = new JTextField(10);
	JTextField tx2 = new JTextField(10);
	JTextField tx3 = new JTextField(10);
	JTextField tx4 = new JTextField(10);
	JTextField tx5 = new JTextField(10);
	JTextField tx6 = new JTextField(10);
	JTextField tx7 = new JTextField(10);
	JButton bt = new JButton("정보등록");
	String locat, start, finish, stime, grade,etime;
	int ttime;

	public BusInfos() {
		this.setBounds(300, 100, 450, 700);
		init();
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void win(WindowEvent e){
				setVisible(false);
				dispose();
				
			}
		});
	}// const

	private void init() {
		// pan1
		pan1.setLayout(null);
		pan1.setBackground(Color.white);
		// 버스이름
		pan1.add(lab1);
		pan1.add(tx1);
		// 출발지
		pan1.add(lab2);
		pan1.add(tx2);
		// 도착지
		pan1.add(lab3);
		pan1.add(tx3);
		// 버스등급
		pan1.add(lab5);
		pan1.add(tx5);

		// 출발시간
		pan1.add(lab4);
		pan1.add(tx4);
		
		// 도착시간
		pan1.add(lab7);
		pan1.add(tx7);

		// 소요시간
		pan1.add(lab6);
		pan1.add(tx6);

		// 버스등급
		pan1.add(lab5);
		pan1.add(tx5);

		// 버스정보위치
		lab1.setBounds(50, 50, 150, 40);
		lab1.setFont(new Font("굴림", Font.BOLD, 30));
		tx1.setBounds(190, 50, 200, 40);

		// 출발지위치
		lab2.setBounds(50, 110, 150, 50);
		lab2.setFont(new Font("굴림", Font.BOLD, 30));
		tx2.setBounds(190, 120, 200, 40);

		// 도착지위치
		lab3.setBounds(50, 170, 150, 50);
		lab3.setFont(new Font("굴림", Font.BOLD, 30));
		tx3.setBounds(190, 180, 200, 40);

		// 출발시간
		lab4.setBounds(50, 240, 150, 50);
		lab4.setFont(new Font("굴림", Font.BOLD, 30));
		tx4.setBounds(190, 240, 200, 40);
		
		// 도착시간
		lab7.setBounds(50, 470, 150, 50);
		lab7.setFont(new Font("굴림", Font.BOLD, 30));
		tx7.setBounds(190, 470, 200, 40);

		// 소요시간
		lab6.setBounds(50, 310, 150, 50);
		lab6.setFont(new Font("굴림", Font.BOLD, 30));
		tx6.setBounds(190, 315, 200, 40);

		// 버스등급
		lab5.setBounds(50, 380, 150, 50);
		lab5.setFont(new Font("굴림", Font.BOLD, 30));
		tx5.setBounds(190, 385, 200, 40);

		// 정보등록버튼
		pan1.add(bt);
		bt.setBounds(170, 570, 90, 50);
		bt.setBackground(new Color(235, 111, 49));
		bt.addActionListener(this);
		pan.add(pan1);
		this.getContentPane().add(pan1);
	}// init

	//static Scanner sc;
	//static String st, ed, nu, gr, stm, etm;
	//static int tm;

	public static void main(String[] args) {
		new BusInfos();
	}//main
		/*sc = new Scanner(System.in);
		System.out.println("=======배차정보관리=======");

		int sel = 0;

		while (true) {
			System.out.println("1.등록 2.검색 3.종료 : ");
			sel = sc.nextInt();
			if (sel == 1) {
				insert();
			} else if (sel == 2) {
				search();
			} else if (sel == 3) {
				System.out.println("종료!");
				System.exit(0);
			} else {
				System.out.println("잘못입력!");
			} // else
		} // while
	}// main

	public static void search() {
		System.out.println("찾을 버스의 번호를 입력하시오 : ");
		nu = sc.next();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(path + nu + ".ser"));
			BI inDatas = (BI) ois.readObject();
			ois.close();
			if (inDatas != null) {
				inDatas.prt();
			} // if
		} catch (Exception e) {
			System.out.println("잘못 입력되었습니다.");
		} // catch
	}// search

	public static void insert() {
		System.out.println("버스번호");
		nu = sc.next();
		System.out.println("출발지 : ");
		st = sc.next();
		System.out.println("도착지 : ");
		ed = sc.next();
		System.out.println("출발시각 : ");
		stm = sc.next();
		System.out.println("도착시각 : ");
		etm = sc.next();
		System.out.println("등급 : ");
		gr = sc.next();
		System.out.println("소요시간 : ");
		tm = sc.nextInt();

		BI bi = new BI(nu, gr, st, ed, stm, etm, tm);
		OutputStream out;

		try {
			out = new FileOutputStream(path + nu + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(bi);
			oos.close();

			// ObjectInputStream
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// insert
*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bt) {
			
			locat = tx1.getText();
			start = tx2.getText();
			finish = tx3.getText();
			ttime = Integer.parseInt(tx6.getText());//
			stime = tx4.getText();
			grade = tx5.getText();
			etime = tx7.getText();
			OutputStream out;
			try {
				out = new FileOutputStream(path + locat+ ".ser");
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(new BI(locat, grade, start, finish, stime, etime, ttime));
				oos.close();
				JOptionPane.showMessageDialog(null, "버스정보등록완료", "Message", JOptionPane.ERROR_MESSAGE);

				// ObjectInputStream
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}// action

}// class
