package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BusInfo extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	static  String path = "D:\\JAVA_LAB\\miniproject\\src\\mini\\TimeInfo\\";
	JPanel pan = new JPanel(new GridLayout(2,2));
	JPanel pan1 = new JPanel();
	JLabel  lab1 = new JLabel("버스 이름");
	JLabel  lab2 = new JLabel("출발지점");
	JLabel  lab3 = new JLabel("도착지점");
	JLabel  lab4 = new JLabel("출발시간");
	JLabel  lab5 = new JLabel("버스등급");
	JLabel  lab6 = new JLabel("소요시간");
	JLabel  lab7 = new JLabel("도착시간");
	JTextField tx1 = new JTextField(10);
	JTextField tx2 = new JTextField(10);
	JTextField tx3 = new JTextField(10);
	JTextField tx4 = new JTextField(10);
	JTextField tx5 = new JTextField(10);
	JTextField tx6 = new JTextField(10);
	JTextField tx7 = new JTextField(10);
	JButton bt = new JButton("정보등록");
	String locate, start, finish, stime, grade, etime;
	int ttime;
	
	public BusInfo() {
		this.setBounds(30, 100, 450, 700);
		init();
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void win(WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
	}
	
	private void init() {
		pan1.setLayout(null);
		pan1.setBackground(Color.WHITE);
		//버스 이름
		pan1.add(lab1);
		pan1.add(tx1);
		//출발지
		pan1.add(lab2);
		pan1.add(tx2);
		//도착지
		pan1.add(lab3);
		pan1.add(tx3);
		//버스등급
		pan1.add(lab5);
		pan1.add(tx5);
		//출발시간
		pan1.add(lab4);
		pan1.add(tx4);
		//도착시간
		pan1.add(lab7);
		pan1.add(tx7);
		//소요시간
		pan1.add(lab6);
		pan1.add(tx6);
		
		//버스정보위치
		lab1.setBounds(50, 50, 150, 40);
		lab1.setFont(new Font("굴림", Font.BOLD, 30));
		tx1.setBounds(190, 50, 200, 40);
		//출발지 위치
		lab2.setBounds(50, 110, 150, 50);
		lab2.setFont(new Font("굴림", Font.BOLD, 30));
		tx2.setBounds(190, 120, 200, 40);
		//도착지 위치
		lab3.setBounds(50, 170, 150, 50);
		lab3.setFont(new Font("굴림", Font.BOLD, 30));
		tx3.setBounds(190, 180, 200, 40);
		//출발시간
		lab4.setBounds(50, 240, 150, 50);
		lab4.setFont(new Font("굴림", Font.BOLD, 30));
		tx4.setBounds(190, 240, 200, 40);
		//도착시간
		lab7.setBounds(50, 470, 150, 50);
		lab7.setFont(new Font("굴림", Font.BOLD, 30));
		tx7.setBounds(190, 470, 200, 40);
		//소요시간
		lab6.setBounds(50, 310, 150, 50);
		lab6.setFont(new Font("굴림", Font.BOLD, 30));
		tx6.setBounds(190, 315, 200, 40);
		//버스등급
		lab5.setBounds(50, 380, 150, 50);
		lab5.setFont(new Font("굴림", Font.BOLD, 30));
		tx5.setBounds(190, 385, 200, 40);
		//정보등록버튼
		pan1.add(bt);
		bt.setBounds(170, 570, 90, 50);
		bt.setBackground(new Color(235,	111,	49));
		bt.addActionListener(this);
		this.getContentPane().add(pan1);
		
	} //end of init
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == bt) {
			locate = tx1.getText();
			start = tx2.getText();
			finish = tx3.getText();
			ttime= Integer.parseInt(tx6.getText());
			stime = tx4.getText();
			grade = tx5.getText();
			etime = tx7.getText();
			
			OutputStream out;
			try {
				out = new FileOutputStream(path+locate+".ser");//직렬화 시키겠다
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(new BI(locate, grade, start, finish, stime, etime, ttime));
				oos.close();
				JOptionPane.showMessageDialog(null,"버스정보등록완료", "Message", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			} //end of try/catch
			
		} //end of if

	} //end of actionPerformed
	
	public static void main(String[] args) {
		new BusInfo();
	}

}
