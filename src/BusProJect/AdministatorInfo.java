package BusProJect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdministatorInfo extends BasicFrame implements Serializable, ActionListener {
	private static final long serialVesionUID = 1L;
	static String path = "C:\\workspace\\src\\BusProJect\\AdmisInfo\\";
	JLabel lab1,lab2,lab3;
	JTextField txtf1, txtf2, txtf3;
	JPanel pan;	JButton bt;
	String name,id,pw;
	public AdministatorInfo() {
		this.setTitle("MemberMain");
		this.setSize(220, 200);
		init();
		this.setVisible(true);
	}
	private void init() {
		lab1 = new JLabel("이름 : ");
		txtf1 = new JTextField(10);
		lab2 = new JLabel("아이디 : ");
		txtf2 = new JTextField(10);
		txtf3 = new JTextField(10);
		lab3 = new JLabel("패스워드 : ");
		bt = new JButton("save");
		bt.addActionListener(this);
		pan =  new JPanel();
		pan.add(lab1);		pan.add(txtf1);		pan.add(lab2);
		pan.add(txtf2);		pan.add(lab3);		pan.add(txtf3);
		pan.add(bt);
		this.getContentPane().add(pan);
	}//init
	public static void main(String[] args) {
		new AdministatorInfo();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		name = txtf1.getText();
		id = txtf2.getText();
		pw = txtf3.getText();
		if (check()) {
			OutputStream out;
			try {
				out = new FileOutputStream(path+id+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(new Member(name, id, pw));
				oos.close();			
				System.out.println(name+"님 파일 생성");
			} catch (Exception ex) {	
				ex.printStackTrace();
			}	//catch			
		}else{
			System.out.println(id+"는 이미 존재합니다.");			
		}//else
		
	}
	private boolean check() {
		boolean flag = true;
		File dir = new File(path);
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!(files[i].isDirectory()) && (id+".ser").equals(files[i].getName())) {
				flag = false;
			}//if
		}//for		
		return flag;
	}//check
}
