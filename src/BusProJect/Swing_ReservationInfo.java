package BusProJect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import javafx.scene.control.PasswordField;
class AlignedTables extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (column == 0) {
			this.setHorizontalAlignment(SwingConstants.CENTER);
		} else if (column == 1) {
			this.setHorizontalAlignment(SwingConstants.CENTER);
		} else if (column == 2) {
			this.setHorizontalAlignment(SwingConstants.CENTER);
		} else if (column == 3) {
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this;
	}
}
public class Swing_ReservationInfo extends BasicFrame implements ActionListener {
	JPanel pan1 = new JPanel();
	private static final long serialVersionUID = 1L;
	static String pathC = "C:\\workspace\\src\\BusProJect\\Reavaration\\";
	static String path ="C:\\workspace\\src\\BusProJect\\SeatInfo\\";
	String[] cdata ={"출발시간","출발지역","도착지역","선택좌석","티켓가격"};
	String[][] rdata = new String[20][5];
	JButton bt4;
	JButton logo;
	JButton bt3;
	JButton bt2;
	JButton bt1;
	JButton bt6;
	JTextField tx1,tx2;
	JPasswordField tx3;
	String name ;
	String pw ;
	String ph ;
	String save;
	JTable table = new JTable(rdata,cdata);
	JScrollPane scrollPane = new JScrollPane();
	JScrollPane scrollPane_1 = new JScrollPane(table);
	int cnt=0;
	AlignedTables align = new AlignedTables();

	public Swing_ReservationInfo() {
		this.setTitle("BusGo");
		table.setDefaultRenderer(table.getColumnClass(0), align);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 1400, 800);
		pan1.setLayout(null);
		control();
		this.setVisible(true);
	}//const

	private void control(){

		pan1.setBackground(Color.white);

		//logo
		logo = new JButton(new ImageIcon("C:\\workspace\\src\\BusProJect\\IMG\\s_logo.jpg"));
		logo.setBounds(35, 20, 110, 60);
		logo.setBackground(Color.white);
		logo.setBorderPainted(false);
		logo.addActionListener(this);
		pan1.add(logo);
		
		JButton bt1 = new JButton("배차정보");
		bt1.setBounds(180, 30, 100, 40);
		bt1.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		bt1.setForeground(Color.white);
		bt1.setBackground(new Color(235, 111, 49));
		bt1.setBorderPainted(false);
		pan1.add(bt1);
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BusManag bm = new BusManag();
				setVisible(false);
			}
		});

		bt2 = new JButton("예약정보");
		bt2.setBounds(290, 30, 100, 40);
		bt2.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		bt2.setForeground(Color.white);
		bt2.setBackground(new Color(235, 111, 49));
		bt2.setBorderPainted(false);
		bt2.addActionListener(this);
		pan1.add(bt2);

		bt3 = new JButton("터미널정보");
		bt3.setBounds(400, 30, 120, 40);
		bt3.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		bt3.setForeground(Color.white);
		bt3.setBackground(new Color(235, 111, 49));
		bt3.setBorderPainted(false);
		bt3.addActionListener(this);
		pan1.add(bt3);

		bt4 = new JButton("뒤로가기");
		bt4.setBounds(530, 40, 90, 30);
		bt4.setForeground(Color.white);
		bt4.setBackground(new Color(30, 144, 255));
		bt4.setBorderPainted(false);
		bt4.addActionListener(this);
		pan1.add(bt4);

		//예약자명
		JLabel l1 = new JLabel("예약자명");
		l1.setBounds(20, 150, 300,100);
		l1.setFont(new Font("나눔고딕", Font.BOLD,15));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		tx1 = new JTextField();
		tx1.setBounds(250, 180, 200, 40);
		pan1.add(l1);
		pan1.add(tx1);

		//전화번호
		JLabel l2 = new JLabel("전화번호");
		l2.setBounds(20, 260, 300,100);
		l2.setFont(new Font("나눔고딕", Font.BOLD,15));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		tx2 = new JTextField();
		tx2.setBounds(250, 290, 200, 40);
		pan1.add(l2);
		pan1.add(tx2);

		//비밀번호
		JLabel l3 = new JLabel("비밀번호");
		l3.setBounds(20, 360, 300,100);
		l3.setFont(new Font("나눔고딕", Font.BOLD,15));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		tx3 = new JPasswordField();
		tx3.setBounds(250, 390, 200, 40);
		pan1.add(l3); 
		pan1.add(tx3); 

		//조회하기
		bt1 = new JButton("조회하기");
		bt1.setFont(new Font("나눔고딕", Font.BOLD,15));
		bt1.setHorizontalAlignment(SwingConstants.CENTER);
		bt1.setBounds(250, 500, 200, 40);
		bt1.setBackground(new Color(235, 111, 49));
		pan1.add(bt1);
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cnt=0;
				for (int i = 0; i <5; i++) {
					rdata[i][0] = null;
					rdata[i][1] = null;
					rdata[i][2] = null;
					rdata[i][3] = null;
					rdata[i][4] = null;
				}
				name = tx1.getText();
				pw = tx3.getText();
				ph = tx2.getText();
				String se1="",se2="",se3="",se4="",se5="",se6="",se7="",se8="";
				for (int i = 1; i <= 100; i++) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathC + i + ".ser"));
						Revarate se = (Revarate) ois.readObject();
						ois.close();
						if (se.name.equals(name) && se.pass.equals(pw) && se.phon.equals(ph)) {
							save =String.valueOf(i);
							rdata[cnt][0] = se.stime;
							rdata[cnt][1] = se.start;
							rdata[cnt][2] = se.finish;
							if (se.seat1!=null) {
								se1 = se.seat1+"번"+" ";
							}
							if (se.seat2!=null) {
								se2 = se.seat2+"번"+" ";
							}
							if (se.seat3!=null) {
								se3 = se.seat3+"번"+" ";
							}
							if (se.seat4!=null) {
								se4 = se.seat4+"번"+" ";
							}
							if (se.seat5!=null) {
								se5 = se.seat5+"번"+" ";
							}
							if (se.seat6!=null) {
								se6 = se.seat6+"번"+" ";
							}
							if (se.seat7!=null) {
								se7 = se.seat7+"번"+" ";
							}
							if (se.seat8!=null) {
								se8 = se.seat8+"번"+" ";
							}
							rdata[cnt][3] = se1+se2+se3+se4+se5+se6+se7+se8;
							rdata[cnt][4] = String.valueOf(se.price);
								
							scrollPane.setViewportView(scrollPane_1);
							cnt++;
							
						}
						//} // if
					} catch (Exception ex) {
						
					} // catch
				} // for
			}
		});
		
		bt6 = new JButton("예매취소");
		bt6.setFont(new Font("나눔고딕", Font.BOLD,15));
		bt6.setHorizontalAlignment(SwingConstants.CENTER);
		bt6.setBounds(780, 600, 200, 40);
		bt6.setBackground(new Color(235, 111, 49));
		pan1.add(bt6);
		bt6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cnts=0;
				File dir = new File(pathC);
				File[] files = dir.listFiles();
				boolean flag = true;
						for (int i = 0; i < files.length; i++) {
							if ((files[i].getName().equals(save + ".ser"))) {
								files[i].delete();
								JOptionPane.showMessageDialog(null, "삭제완료되었습니다", "Message", JOptionPane.ERROR_MESSAGE);
								rdata[cnts][0] = "";
								rdata[cnts][1] = "";
								rdata[cnts][2] = "";
								rdata[cnts][3] = "";
								rdata[cnts][4] = "";
								cnts++;
								scrollPane.setViewportView(scrollPane_1);
								flag = false;
							} // if
						} // for
						if (flag) {
							JOptionPane.showMessageDialog(null, "없는버스번호입니다", "Message", JOptionPane.ERROR_MESSAGE);
						} // if
			} // if
		});
		
		//table
		
		scrollPane.setBounds(520, 150, 750, 397);
		pan1.add(scrollPane);		
		
		
	
		scrollPane.setViewportView(scrollPane_1);
		table.setRowHeight(40);
		//table.setDefaultRenderer(table.getColumnClass(0), align);
		

	/*	JButton pay_button = new JButton("결제하기");
		pay_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 결제하기 이벤트 처리 부분 
			}
		});
		pay_button.setBounds(815, 575, 117, 29);
		pay_button.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		pay_button.setForeground(Color.white);
		pay_button.setBackground(new Color(235, 111, 49));
		pay_button.setBorderPainted(false);
		pan1.add(pay_button);
*/
		
		JLabel buttom = new JLabel(new ImageIcon("C:\\workspace\\src\\BusProJect\\IMG\\bottom_info.jpg"));
		buttom.setBounds(-10,690,1405,55);
		pan1.add(buttom);

		this.getContentPane().add(pan1);
	}//control

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt2) {
			Swing_ReservationInfo sr = new Swing_ReservationInfo();
			this.setVisible(false);
		}
		if (e.getSource() == bt3) {
			Swing_TerMinalInfo tm = new Swing_TerMinalInfo();
			this.setVisible(false);
		}
		if (e.getSource() == bt4) {
			MainInterFace main = new MainInterFace();
			this.setVisible(false);
		}
		if (e.getSource() == logo) {
			MainInterFace main = new MainInterFace();
			this.setVisible(false);			
		}
		
	}//action
	public static void main(String[] args) {
		new Swing_ReservationInfo();
	}
}
