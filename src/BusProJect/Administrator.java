package BusProJect;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sun.net.www.content.audio.basic;
public class Administrator extends BasicFrame implements ActionListener {
	private static final long serialVesionUID = 1L;
	JPanel pan = new JPanel(new GridLayout(2, 2));
	JPanel pan1 = new JPanel();
	JLabel lab1 = new JLabel("ID");
	JLabel lab2 = new JLabel("PW");
	JTextField tx1 = new JTextField(10);
	JPasswordField tx2 = new JPasswordField(10);
	JButton bt = new JButton("로그인");
	static String path = "C:\\workspace\\src\\BusProJect\\AdmisInfo\\";
	String id,pw;
	public Administrator() {
		this.setBounds(300, 100, 380, 300);
		//this.setResizable(false);
		init();
		this.setVisible(true);
	}//const
	

	private void init() {
		pan1.setLayout(null);
		//ID 
		pan1.add(lab1);
		pan1.add(tx1);
		
		lab1.setBounds(50, 50, 40, 40);
		lab1.setFont(new Font("굴림", Font.BOLD, 30));
		tx1.setBounds(120, 50, 200, 40);
		//tx1.setFont(new Font("굴림", Font.BOLD, 30));
		//PW
		pan1.add(lab2);
		pan1.add(tx2);
		lab2.setBounds(50, 110, 50, 50);
		lab2.setFont(new Font("굴림", Font.BOLD, 30));
		tx2.setBounds(120, 120, 200, 40);
		//로그인
		pan1.add(bt);
		bt.setBounds(150, 180, 90, 50);
		bt.addActionListener(this);
		pan.add(pan1);
		this.getContentPane().add(pan1);
	}//init

	public static void main(String[] args) {
		new Administrator();
		
	}//main

	@Override
	public void actionPerformed(ActionEvent arg0) {
		id = tx1.getText();
		pw = tx2.getText();
		if (check()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+id+".ser"));
				Member mem = (Member) ois.readObject();
				ois.close();
				if (mem.pw.equals(this.pw)) {
					//MainInterFace main = new MainInterFace();
					MainInterFaceMain.main.setVisible(false);
					this.setVisible(false);
					
					Swing_BusManager sb = new Swing_BusManager();
				}else{
					System.out.println("패스워드가 틀립니다.");
				}//else
			} catch (Exception ex) {	
				ex.printStackTrace();
			}	//catch	
		}else{
			System.out.println("아이디가 없습니다!!");		
		}//else
		
	}

	private boolean check() {
		boolean flag = false;
		File dir = new File(path);
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!(files[i].isDirectory()) && (id+".ser").equals(files[i].getName())) {
				flag = true;
			}//if
		}//for		
		return flag;
	}//check
}//class
