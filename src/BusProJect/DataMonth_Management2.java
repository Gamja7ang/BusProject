package BusProJect;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
class AlignedTablesw extends DefaultTableCellRenderer {
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
class DataMon extends JFrame implements ActionListener{
	Calendar calendar = Calendar.getInstance();		
	java.util.Date date = calendar.getTime();
	private static final long serialVesionUID = 1L;
	static String pathC = "C:\\workspace\\src\\BusProJect\\Reavaration\\";
	int total1 = 0;
	int total2 = 0;
	int total3 = 0;
	int total4 = 0;
	int total5 = 0;
	int total6 = 0;
	int total7 = 0;
	int total8 = 0;
	int total9 = 0;
	int total10 = 0;
	int total11 = 0;
	int total12 = 0;
	String[] cdata = {"월","매출"};
	String[] cdata2 = {"월별매출","총합"};
	String[][] rdata = new String[12][2];
	JPanel pan1 = new JPanel();
	JButton bt4;
	JButton bt2;
	JButton bt1;
	JTable table = new JTable(rdata,cdata);
	JScrollPane scrollPane = new JScrollPane();
	JScrollPane scrollPane_1= new JScrollPane(table);
	JButton bt5 = new JButton("월별매출조회");
	AlignedTablesw align = new AlignedTablesw();


	public DataMon() {
		table.setDefaultRenderer(table.getColumnClass(0), align);
		this.setTitle("Data Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 1400, 800);
		pan1.setLayout(null);
		control();
		this.setVisible(true);
	}//const

	private void control(){

		pan1.setBackground(Color.white);

		//logo
		JButton logo = new JButton(new ImageIcon("D:\\JavaStudy_sunny\\JAVA\\btimg\\s_logo.jpg"));
		logo.setBounds(35, 20, 110, 60);
		logo.setBackground(Color.white);
		logo.setBorderPainted(false);
		pan1.add(logo);

		bt1 = new JButton("매출관리");
		bt1.setBounds(180, 30, 100, 40);
		bt1.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		bt1.setForeground(Color.white);
		bt1.setBackground(new Color(235, 111, 49));
		bt1.setBorderPainted(false);
		pan1.add(bt1);

		bt2 = new JButton("운행정보관리");
		bt2.setBounds(290, 30, 130, 40);
		bt2.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		bt2.setForeground(Color.white);
		bt2.setBackground(new Color(235, 111, 49));
		bt2.setBorderPainted(false);
		bt2.addActionListener(this);
		pan1.add(bt2);

		bt4 = new JButton("뒤로가기");
		bt4.setBounds(450, 40, 90, 30);
		bt4.setForeground(Color.white);
		bt4.setBackground(new Color(30, 144, 255));
		bt4.setBorderPainted(false);
		bt4.addActionListener(this);
		pan1.add(bt4);

		//버튼5 -일일매출조회
		bt5.setBounds(200, 120, 250, 70);
		bt5.setFont(new java.awt.Font("나눔고딕",Font.BOLD,20));
		bt5.setForeground(Color.white);
		bt5.setBackground(new Color(235, 111, 49));
		bt5.setBorderPainted(false);
		pan1.add(bt5);
		bt5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Data dt = new Data();
				setVisible(false);
			}
		});
		
		//버튼6 -월별매출조회
		JButton bt6 = new JButton("월별매출조회");
		bt6.setBounds(200, 220, 250, 70);
		bt6.setFont(new java.awt.Font("나눔고딕",Font.BOLD,20));
		bt6.setForeground(Color.white);
		bt6.setBackground(new Color(235, 111, 49));
		bt6.setBorderPainted(false);
		pan1.add(bt6);
		bt6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String year = (new SimpleDateFormat("yyyy년").format(date));
				String mon = (new SimpleDateFormat("M월").format(date));
		        String day = (new SimpleDateFormat("dd일").format(date));
				int cnt =0;
				total1 = 0;
				total2 = 0;
				total3 = 0;
				total4 = 0;
				total5 = 0;
				total6 = 0;
				total7 = 0;
				total8 = 0;
				total9 = 0;
				total10 = 0;
				total11 = 0;
				total12 = 0;
				for (int i = 1; i <= 100; i++) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathC + i + ".ser"));
						Revarate se = (Revarate) ois.readObject();
						ois.close();
						
							rdata[0][0] = "17년1월";
							rdata[1][0] = "17년2월";
							rdata[2][0] = "17년3월";
							rdata[3][0] = "17년4월";
							rdata[4][0] = "17년5월";
							rdata[5][0] = "17년6월";
							rdata[6][0] = "17년7월";
							rdata[7][0] = "17년8월";
							rdata[8][0] = "17년9월";
							rdata[9][0] = "17년10월";
							rdata[10][0] = "17년11월";
							rdata[11][0] = "17년12월";
							if (se.month.equals("1월")) {
								total1 += se.price;
							}else if (se.month.equals("2월")) {
								total2 += se.price;	
							}else if (se.month.equals("3월")) {
								total3 += se.price;	
							}else if (se.month.equals("4월")) {
								total4 += se.price;	
							}else if (se.month.equals("5월")) {
								total5 += se.price;	
							}else if (se.month.equals("6월")) {
								total6 += se.price;	
							}else if (se.month.equals("7월")) {
								total7 += se.price;	
							}else if (se.month.equals("8월")) {
								total8 += se.price;	
							}else if (se.month.equals("9월")) {
								total9 += se.price;	
							}else if (se.month.equals("10월")) {
								total10 += se.price;	
							}else if (se.month.equals("11월")) {
								total11 += se.price;	
							}else if (se.month.equals("12월")) {
								total12 += se.price;	
							}
				
							rdata[0][1] = String.valueOf(total1);
							rdata[1][1] = String.valueOf(total2);
							rdata[2][1] = String.valueOf(total3);
							rdata[3][1] = String.valueOf(total4);
							rdata[4][1] = String.valueOf(total5);
							rdata[5][1] = String.valueOf(total6);
							rdata[6][1] = String.valueOf(total7);
							rdata[7][1] = String.valueOf(total8);
							rdata[8][1] = String.valueOf(total9);
							rdata[9][1] = String.valueOf(total10);
							rdata[10][1] = String.valueOf(total11);
							rdata[11][1] = String.valueOf(total12);
							scrollPane.setViewportView(scrollPane_1);
							cnt++;
				
						
						//} // if
					} catch (Exception ex) {
						
					} // catch
				} // for
				
			}
		});
		
		//버튼7 -노선별매출조회
		JButton bt7 = new JButton("노선별매출조회");
		bt7.setBounds(200, 320, 250, 70);
		bt7.setFont(new java.awt.Font("나눔고딕",Font.BOLD,20));
		bt7.setForeground(Color.white);
		bt7.setBackground(new Color(235, 111, 49));
		bt7.setBorderPainted(false);
		pan1.add(bt7);
		
		//버튼8 -전체매출조회
		JButton bt8 = new JButton("전체매출조회");
		bt8.setBounds(200, 420, 250, 70);
		bt8.setFont(new java.awt.Font("나눔고딕",Font.BOLD,20));
		bt8.setForeground(Color.white);
		bt8.setBackground(new Color(235, 111, 49));
		bt8.setBorderPainted(false);
		pan1.add(bt8);
		
			/*---------------------------------Right Side--------------------------------------------*/

		JLabel buschoice = new JLabel("일일매출");
		buschoice.setBounds(850, 120, 203, 30);
		pan1.add(buschoice);		
		
		//테이블 버전 1
		scrollPane.setBounds(620, 150, 550, 297);
		pan1.add(scrollPane);		
		table.setRowHeight(40);
		table.setFont(new Font("굴림", Font.BOLD, 20));
		scrollPane.setViewportView(scrollPane_1);
		//매출결과확인
		

		JLabel buttom = new JLabel(new ImageIcon("D:\\JavaStudy_sunny\\JAVA\\btimg\\bottom_info.jpg"));
		buttom.setBounds(-10,710,1405,55);
		pan1.add(buttom);	

		this.getContentPane().add(pan1);
	}//control

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt1) {
			Data da = new Data();
			this.setVisible(false);
		}
		if (e.getSource() == bt2) {
			Swing_BInPut sb = new Swing_BInPut();
			this.setVisible(false);
		}
		if (e.getSource() == bt4) {
			Swing_BusManager sb = new Swing_BusManager();
			this.setVisible(false);
		}
	}//action
}//class

public class DataMonth_Management2 {
	public static void main(String[] args) {
		new DataMon();
	}//main
}//class
