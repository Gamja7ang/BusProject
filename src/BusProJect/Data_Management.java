package BusProJect;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
class AlignedTablesq extends DefaultTableCellRenderer {
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
class Data extends JFrame implements ActionListener{
	Calendar calendar = Calendar.getInstance();		
	java.util.Date date = calendar.getTime();
	private static final long serialVesionUID = 1L;
	static String pathC = "C:\\workspace\\src\\BusProJect\\Reavaration\\";
	int total = 0;
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
	int go1=0;
	int go2=0;
	int go3=0;
	int go4=0;
	int go5=0;
	int go6=0;
	int go7=0;
	int go8=0;
	int go9=0;
	int go10=0;
	JLabel buschoice = new JLabel("");
	//일일
	String[] cdata = {"날짜","매출"};
	String[][] rdata = new String[20][2];
	//월별
	String[] cdata2 = {"월","매출"};
	String[][] rdata2 = new String[12][2];
	//노선별
	String[] cdata3 = {"출발지","도착지","매출"};
	String[][] rdata3 = new String[13][3];
	//전체조회
	String[] cdata4 = {"날짜","매출"};
	String[][] rdata4 = new String[50][2];
	
	JPanel pan1 = new JPanel();
	JButton bt4;
	JButton bt2;
	JButton bt1;
	JLabel lb1 = new JLabel("결산금액:");
	JTextField tx1 = new JTextField(10);
	//일일테이블
	JTable table = new JTable(rdata,cdata);
	JScrollPane scrollPane = new JScrollPane();
	JScrollPane scrollPane_1= new JScrollPane(table);
	//월별테이블
	JTable table2 = new JTable(rdata2,cdata2);
	JScrollPane scrollPane2 = new JScrollPane();
	JScrollPane scrollPane_2= new JScrollPane(table2);
	//노선별테이블
	JTable table3 = new JTable(rdata3,cdata3);
	JScrollPane scrollPane3 = new JScrollPane();
	JScrollPane scrollPane_3= new JScrollPane(table3);
	//전체조회테이블
	JTable table4 = new JTable(rdata4,cdata4);
	JScrollPane scrollPane4 = new JScrollPane();
	JScrollPane scrollPane_4= new JScrollPane(table4);
	//매출조회버튼
	JButton bt5 = new JButton("일일매출조회");
	AlignedTablesq align = new AlignedTablesq();


	public Data() {
		table.setDefaultRenderer(table.getColumnClass(0), align);
		table2.setDefaultRenderer(table.getColumnClass(0), align);
		table3.setDefaultRenderer(table.getColumnClass(0), align);
		table4.setDefaultRenderer(table.getColumnClass(0), align);
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
				buschoice.setText("일별매출");
				scrollPane.setVisible(true);
				scrollPane_1.setVisible(true);
				String year = (new SimpleDateFormat("yyyy년").format(date));
				String mon = (new SimpleDateFormat("M월").format(date));
		        String day = (new SimpleDateFormat("dd일").format(date));
				int cnt =0;
				total = 0;
				for (int i = 1; i <= 100; i++) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathC + i + ".ser"));
						Revarate se = (Revarate) ois.readObject();
						ois.close();
						if (year.equals(se.year) && day.equals(se.day) && mon.equals(se.month)) {
							rdata[cnt][0] = se.month+" "+se.day;
							rdata[cnt][1] = String.valueOf(se.price);
							total += se.price;
							rdata[cnt+1][0] = "일일매출";
							rdata[cnt+1][1] = String.valueOf(total);
							scrollPane.setViewportView(scrollPane_1);
							cnt++;
				
						}
						//} // if
					} catch (Exception ex) {
						
					} // catch
				} // for
				scrollPane.setBounds(620, 150, 550, 297);
				pan1.add(scrollPane);		
				table.setRowHeight(40);
				table.setFont(new Font("굴림", Font.BOLD, 20));
				scrollPane.setViewportView(scrollPane_1);
				scrollPane2.setVisible(false);
				scrollPane_2.setVisible(false);
				scrollPane3.setVisible(false);
				scrollPane_3.setVisible(false);
				scrollPane4.setVisible(false);
				scrollPane_4.setVisible(false);
				
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
				buschoice.setText("월별매출");
				scrollPane2.setVisible(true);
				scrollPane_2.setVisible(true);
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
						
							rdata2[0][0] = "17년1월";
							rdata2[1][0] = "17년2월";
							rdata2[2][0] = "17년3월";
							rdata2[3][0] = "17년4월";
							rdata2[4][0] = "17년5월";
							rdata2[5][0] = "17년6월";
							rdata2[6][0] = "17년7월";
							rdata2[7][0] = "17년8월";
							rdata2[8][0] = "17년9월";
							rdata2[9][0] = "17년10월";
							rdata2[10][0] = "17년11월";
							rdata2[11][0] = "17년12월";
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
				
							rdata2[0][1] = String.valueOf(total1);
							rdata2[1][1] = String.valueOf(total2);
							rdata2[2][1] = String.valueOf(total3);
							rdata2[3][1] = String.valueOf(total4);
							rdata2[4][1] = String.valueOf(total5);
							rdata2[5][1] = String.valueOf(total6);
							rdata2[6][1] = String.valueOf(total7);
							rdata2[7][1] = String.valueOf(total8);
							rdata2[8][1] = String.valueOf(total9);
							rdata2[9][1] = String.valueOf(total10);
							rdata2[10][1] = String.valueOf(total11);
							rdata2[11][1] = String.valueOf(total12);
							scrollPane2.setViewportView(scrollPane_2);
							cnt++;
				
						
						//} // if
					} catch (Exception ex) {
						
					} // catch
				} // for
				scrollPane2.setBounds(620, 150, 550, 297);
				pan1.add(scrollPane2);		
				table2.setRowHeight(40);
				table2.setFont(new Font("굴림", Font.BOLD, 20));
				scrollPane2.setViewportView(scrollPane_2);
				scrollPane.setVisible(false);
				scrollPane_1.setVisible(false);
				scrollPane3.setVisible(false);
				scrollPane_3.setVisible(false);
				scrollPane4.setVisible(false);
				scrollPane_4.setVisible(false);
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
		bt7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buschoice.setText("노선별매출");
				scrollPane3.setVisible(true);
				scrollPane_3.setVisible(true);
				String year = (new SimpleDateFormat("yyyy년").format(date));
				String mon = (new SimpleDateFormat("M월").format(date));
		        String day = (new SimpleDateFormat("dd일").format(date));
				int cnt =0;
				go1 =0;
				go2 =0;
				go3 =0;
				go4 =0;
				go5 =0;
				go6 =0;
				go7 =0;
				go8 =0;
				go9 =0;
				go10 =0;
				for (int i = 1; i <= 100; i++) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathC + i + ".ser"));
						Revarate se = (Revarate) ois.readObject();
						ois.close();
						
							rdata3[0][0] = "울산";
							rdata3[0][1] = "부산";
							rdata3[1][0] = "울산";
							rdata3[1][1] = "대구";
							rdata3[2][0] = "울산";
							rdata3[2][1] = "대전";
							rdata3[3][0] = "울산";
							rdata3[3][1] = "서울";
							rdata3[4][0] = "울산";
							rdata3[4][1] = "광주";
							rdata3[5][0] = "부산";
							rdata3[5][1] = "울산";
							rdata3[6][0] = "대구";
							rdata3[6][1] = "울산";
							rdata3[7][0] = "대전";
							rdata3[7][1] = "울산";
							rdata3[8][0] = "서울";
							rdata3[8][1] = "울산";
							rdata3[9][0] = "광주";
							rdata3[9][1] = "울산";
							if (se.start.equals("울산") && se.finish.equals("부산")) {
								go1 += se.price;
							}else if (se.start.equals("울산") && se.finish.equals("대구")) {
								go2 += se.price;	
							}else if (se.start.equals("울산") && se.finish.equals("대전")) {
								go3 += se.price;	
							}else if (se.start.equals("울산") && se.finish.equals("서울")) {
								go4 += se.price;	
							}else if (se.start.equals("울산") && se.finish.equals("광주")) {
								go5 += se.price;	
							}else if (se.start.equals("부산") && se.finish.equals("울산")) {
								go6 += se.price;	
							}else if (se.start.equals("대구") && se.finish.equals("울산")) {
								go7 += se.price;	
							}else if (se.start.equals("대전") && se.finish.equals("울산")) {
								go8 += se.price;	
							}else if (se.start.equals("서울") && se.finish.equals("울산")) {
								go9 += se.price;	
							}else if (se.start.equals("광주") && se.finish.equals("울산")) {
								go10 += se.price;	
							}
				
							rdata3[0][2] = String.valueOf(go1);
							rdata3[1][2] = String.valueOf(go2);
							rdata3[2][2] = String.valueOf(go3);
							rdata3[3][2] = String.valueOf(go4);
							rdata3[4][2] = String.valueOf(go5);
							rdata3[5][2] = String.valueOf(go6);
							rdata3[6][2] = String.valueOf(go7);
							rdata3[7][2] = String.valueOf(go8);
							rdata3[8][2] = String.valueOf(go9);
							rdata3[9][2] = String.valueOf(go10);
							scrollPane3.setViewportView(scrollPane_3);
							cnt++;
				
						
						//} // if
					} catch (Exception ex) {
						
					} // catch
				} // for
				scrollPane3.setBounds(620, 150, 550, 297);
				pan1.add(scrollPane3);		
				table3.setRowHeight(40);
				table3.setFont(new Font("굴림", Font.BOLD, 20));
				scrollPane3.setViewportView(scrollPane_3);
				scrollPane.setVisible(false);
				scrollPane_1.setVisible(false);
				scrollPane2.setVisible(false);
				scrollPane_2.setVisible(false);
				scrollPane4.setVisible(false);
				scrollPane_4.setVisible(false);
			}
		});
		
		//버튼8 -전체매출조회
		JButton bt8 = new JButton("전체매출조회");
		bt8.setBounds(200, 420, 250, 70);
		bt8.setFont(new java.awt.Font("나눔고딕",Font.BOLD,20));
		bt8.setForeground(Color.white);
		bt8.setBackground(new Color(235, 111, 49));
		bt8.setBorderPainted(false);
		pan1.add(bt8);
		bt8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buschoice.setText("전체조회");
				scrollPane4.setVisible(true);
				scrollPane_4.setVisible(true);
				String year = (new SimpleDateFormat("yyyy년").format(date));
				String mon = (new SimpleDateFormat("M월").format(date));
		        String day = (new SimpleDateFormat("dd일").format(date));
				int cnt =0;
				total = 0;
				
				for (int i = 1; i <= 100; i++) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathC + i + ".ser"));
						Revarate se = (Revarate) ois.readObject();
						ois.close();
							
							total = se.price;
							rdata4[cnt][0] = se.year+se.month+se.day;
							rdata4[cnt][1] = String.valueOf(total);
							scrollPane.setViewportView(scrollPane_1);
							cnt++;
				
						}catch (Exception ex) {
							
						} // catch
						
					 
					
				} // for
				scrollPane4.setBounds(620, 150, 550, 297);
				pan1.add(scrollPane4);		
				table4.setRowHeight(40);
				table4.setFont(new Font("굴림", Font.BOLD, 20));
				scrollPane4.setViewportView(scrollPane_4);
				scrollPane2.setVisible(false);
				scrollPane_2.setVisible(false);
				scrollPane3.setVisible(false);
				scrollPane_3.setVisible(false);
				scrollPane.setVisible(false);
				scrollPane_1.setVisible(false);
				
		
				
		}
		});
		
			/*---------------------------------Right Side--------------------------------------------*/

			
		
		//테이블 버전 1
		buschoice.setBounds(850, 120, 203, 35);
		pan1.add(buschoice);
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

public class Data_Management {
	public static void main(String[] args) {
		new Data();
	}//main
}//class
