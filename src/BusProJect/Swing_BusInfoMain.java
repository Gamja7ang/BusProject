package BusProJect;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


class Opt extends JOptionPane{
	public Opt() {
		this.setBounds(800,300, 300, 300);
		this.setVisible(true);
	}//const
}//class
class BusManag extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static String path = "C:\\workspace\\src\\BusProJect\\TimeInfo\\";//버스정보
	static String paths = "C:\\workspace\\src\\BusProJect\\SeatInfo\\";//좌석정보
	static String pathC = "C:\\workspace\\src\\BusProJect\\Reavaration\\";
	String[] start = { "울산", "부산", "대구", "대전", "광주", "서울" };
	String[] finish = { "울산", "부산", "대구", "대전", "광주", "서울" };
	String[] eng = { "ul", "bu", "da", "dj", "gw", "se" };
	String[] engs = { "ul", "bu", "da", "dj", "gw", "se" };
	String[] grade = { "일반", "우등" };
	JPanel pan1 = new JPanel();
	JPanel pan5 = new JPanel();
	String[] set = new String[8];
	int insub=0;
	int price=0;
	int total =0;
	JButton pay_button;
	JButton bt4;
	JButton bt8;
	JButton pay = new JButton("결제하기");
	JButton can = new JButton("취소하기");
	JLabel lab6 = new JLabel("이름");
	JTextField txtf6 = new JTextField(10);
	JLabel lab7 = new JLabel("PW");
	JPasswordField txtf7 = new JPasswordField();
	JLabel lab8 = new JLabel("전화");
	JTextField txtf8 = new JTextField(10);
	JButton logo;
	JButton bt3;
	JButton bt2;
	JRadioButton rb2,rb1;
	JRadioButton rb3,rb4;
	String etimes = null;
	String startss = null;
	String etimess = null;
	int time1;
	String ends;
	int  submit; //제한설정
	int[] sub = {0,1,2,3,4,5,6,7,8};
	int  submits; // 제한에걸릴시 버튼선택불가
	//combobox
	JComboBox departure;//출발지
	JComboBox destination;//목적지
	JComboBox time;//시간
	JComboBox year;//년도
	JComboBox month;//월
	JComboBox day;//일
	String id,pw,ph;
	String[] stime = new String[10];
	ButtonGroup group = new ButtonGroup();
	ButtonGroup group2 = new ButtonGroup();
	JButton seat_1,seat_2,seat_3,seat_4,seat_5;
	JButton seat_6,seat_7,seat_8;
	JButton complete;
	//등급추출
	String setgrade;
	//날짜추출
	String years,months,days;
	//출발지추출
	int idx1,idx2;
	int pt;
	String str = start[idx1];
	//도착지추출
	String fin = finish[idx2];
	
	//출발시간
	String stimes;
	//좌석추출
	String set1=null;
	String set2=null;
	String set3=null;
	String set4=null;
	String set5=null;
	String set6=null;
	String set7=null;
	String set8=null;
	//소아 대인 추출
	JComboBox kids,adult;
	String idx3="0",idx4="0";
	//출력부분 
	JTextArea choice_print = new JTextArea();;
	int se1,se2,se3,se4,se5,se6,se7,se8;
	int cnt=1;
	boolean flag;
	public BusManag() {
		this.setTitle("BusGo");
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

		//출발지
		JLabel l1 = new JLabel("출발지");
		l1.setBounds(20, 80, 300,100);
		l1.setFont(new Font("나눔고딕", Font.BOLD,15));
		l1.setHorizontalAlignment(SwingConstants.CENTER);		
		pan1.add(l1);

		//목적지
		JLabel l2 = new JLabel("목적지");
		l2.setBounds(20, 180, 300,100);
		l2.setFont(new Font("나눔고딕", Font.BOLD,15));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		pan1.add(l2);

		//출발일시
		JLabel l3 = new JLabel("출발일시");
		l3.setBounds(20, 280, 300,100);
		l3.setFont(new Font("나눔고딕", Font.BOLD,15));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		pan1.add(l3); 

		//출발지 - departure
		departure = new JComboBox(start);
		departure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = false;
				if (e.getSource() == departure ) {
					
						seat_1.setEnabled(true);
						seat_1.setText("1");
						seat_1.setBackground(null);
					
						seat_2.setEnabled(true);
						seat_2.setText("2");
						seat_2.setBackground(null);
					
						seat_3.setEnabled(true);
						seat_3.setText("3");
						seat_3.setBackground(null);
					
						seat_4.setEnabled(true);
						seat_4.setText("4");
						seat_4.setBackground(null);
					
						seat_5.setEnabled(true);
						seat_5.setText("5");
						seat_5.setBackground(null);
					
						seat_6.setEnabled(true);
						seat_6.setText("6");
						seat_6.setBackground(null);
						seat_7.setEnabled(true);
						seat_7.setText("7");
						seat_7.setBackground(null);
						seat_8.setEnabled(true);
						seat_8.setText("8");
						seat_8.setBackground(null);
					price = 0;
					total =0;
					JComboBox<String> com = (JComboBox<String>) e.getSource();
					idx1 = com.getSelectedIndex();
					if (idx1 == 0) {
						flag = true;
						destination.removeAllItems();
						for (int i = 1; i < 6; i++) {
							destination.addItem(finish[i]);		
						}//for
						
					}else if (idx1!=0) {
						destination.removeAllItems();
						destination.addItem(finish[0]);
					}//elseif
				}
			}//action
		});
		departure.setBounds(230, 100, 150, 50);
		departure.setBackground(Color.WHITE);
		((JLabel)departure.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		pan1.add(departure);


		//목적지-destination
		
		destination = new JComboBox();
		destination.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//flag = false;
				if (e.getSource() == destination ) {
					JComboBox<String> com = (JComboBox<String>)e.getSource();
					idx2 = 0;
					idx2 = com.getSelectedIndex();
					time.removeAllItems();
					if (flag) {
						idx2+=1;
					}//if
				}//outif			
			}//action
		});
		
		destination.setBounds(230, 200, 150, 50);
		((JLabel)destination.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		destination.setBackground(Color.WHITE);
		pan1.add(destination);

		// 연도 - year 
		year = new JComboBox();
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == year) {
					JComboBox<String> com = (JComboBox<String>)e.getSource();
					years = (String) com.getSelectedItem();
				}
			}
		});
		year.setModel(new DefaultComboBoxModel(new String[] {
				"연도", "2017년", "2018년", "2019년", "2020년", "2021년"}));
		year.setBounds(230, 300, 150, 50);
		((JLabel)year.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		year.setBackground(Color.WHITE);
		pan1.add(year);

		//월- month
		month = new JComboBox();
		month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == month) {
					JComboBox<String> com = (JComboBox<String>)e.getSource();
					months = (String) com.getSelectedItem();
				}
			}
		});
		month.setModel(new DefaultComboBoxModel(new String[] {
				"월","1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"}));
		month.setBounds(230, 370, 120, 50);
		((JLabel)month.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		month.setBackground(Color.WHITE);
		pan1.add(month);

		// 일 - day
		day = new JComboBox();
		day.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == day) {
					if (e.getSource() == day) {
						JComboBox<String> com = (JComboBox<String>)e.getSource();
						days = (String) com.getSelectedItem();
					}//if
					for (int i = 1; i <= 100; i++) {
						try {
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + i + ".ser"));
							BI mem = (BI) ois.readObject();
							ois.close();
							if (mem.start.equals(eng[idx1]) && mem.end.equals(engs[idx2]) ) {
								time.addItem("시간:"+mem.stime+"시");
								etimes = mem.etime;
								pt = mem.time;
								
							} // if
						} catch (Exception ex) {
							
						} // catch
					} // for
				}
				
			}
		});
		day.setModel(new DefaultComboBoxModel(new String[] {
				"일", "1일", "2일", "3일", "4일","5일","6일","7일","8일","9일","10일",
				"11일", "12일", "13일", "14일", "15일","16일","17일","18일","19일","20일",
				"21일", "22일", "23일", "24일", "25일","26일","27일","28일","29일","30일","31일"}));
		day.setBounds(370, 370, 120, 50);
		((JLabel)day.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		day.setBackground(Color.WHITE);
		pan1.add(day);

		//시간 - time
		time = new JComboBox();
		time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stimes = (String) time.getSelectedItem();
			}
		});
		time.setBounds(230, 450, 260, 50);
		((JLabel)time.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		time.setBackground(Color.WHITE);
		pan1.add(time);

		//등급 -label4
		JLabel l4 = new JLabel("등급");
		l4.setBounds(20, 490,300,100);
		l4.setFont(new Font("나눔고딕", Font.BOLD,15));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l4.setBackground(Color.WHITE);
		pan1.add(l4);

		//등급-일반 - radio button 1
		rb1 = new JRadioButton("일반");
		group.add(rb1);
		rb1.setBounds(250, 515, 100, 50);
		rb1.setBackground(Color.WHITE);
		pan1.add(rb1);
		rb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
					int cnts=0;
					price = 5000;
					
					for (int i = 0; i < 8; i++) {
					}
					
					setgrade = rb1.getActionCommand();
					//좌석색깔 
					for (int i = 1; i <= 100; i++) {
						try {
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathC + i + ".ser"));
							Revarate se = (Revarate) ois.readObject();
							ois.close();
							if (se.start.equals(start[idx1]) && se.finish.equals(finish[idx2]) && se.year.equals(years) && se.month.equals(months) && se.day.equals(days) && se.grade.equals(setgrade) && se.stime.equals(stimes)) {
									set[0] = se.seat1;
									set[1] = se.seat2;
									set[2] = se.seat3;
									set[3] = se.seat4;
									set[4] = se.seat5;
									set[5] = se.seat6;
									set[6] = se.seat7;
									set[7] = se.seat8;
										if (set[0]!=null) {
											seat_1.setEnabled(false);
											seat_1.setText("매진");
											seat_1.setBackground(Color.gray);
										}
										if(set[1]!=null) {
											seat_2.setEnabled(false);
											seat_2.setText("매진");
											seat_2.setBackground(Color.gray);
										}
										if(set[2]!=null) {
											seat_3.setEnabled(false);
											seat_3.setText("매진");
											seat_3.setBackground(Color.gray);
										}
										if(set[3]!=null) {
											seat_4.setEnabled(false);
											seat_4.setText("매진");
											seat_4.setBackground(Color.gray);
										}
										if(set[4]!=null) {
											seat_5.setEnabled(false);
											seat_5.setText("매진");
											seat_5.setBackground(Color.gray);
										}
										if(set[5]!=null) {
											seat_6.setEnabled(false);
											seat_6.setText("매진");
											seat_6.setBackground(Color.gray);
										}
										if(set[6]!=null) {
											seat_7.setEnabled(false);
											seat_7.setText("매진");
											seat_7.setBackground(Color.gray);
										}
										if(set[7]!=null) {
											seat_8.setEnabled(false);
											seat_8.setText("매진");
											seat_8.setBackground(Color.gray);
										}
							}
							//} // if
						} catch (Exception ex) {
							
						} // catch
					} // for
			}
		});

		//등급 - 우등radio button 2
		rb2 = new JRadioButton("우등");
		group.add(rb2);
		rb2.setBounds(380, 515, 150, 50);
		rb2.setBackground(Color.WHITE);
		pan1.add(rb2);
		rb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rb2) {
					price = 10000;
					setgrade = rb2.getActionCommand();
					for (int i = 1; i <= 100; i++) {
						try {
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathC + i + ".ser"));
							Revarate se = (Revarate) ois.readObject();
							ois.close();
							if (se.start.equals(start[idx1]) && se.finish.equals(finish[idx2]) && se.year.equals(years) && se.month.equals(months) && se.day.equals(days) && se.grade.equals(setgrade) && se.stime.equals(stimes)) {
									set[0] = se.seat1;
									set[1] = se.seat2;
									set[2] = se.seat3;
									set[3] = se.seat4;
									set[4] = se.seat5;
									set[5] = se.seat6;
									set[6] = se.seat7;
									set[7] = se.seat8;
										if (set[0]!=null) {
											seat_1.setEnabled(false);
											seat_1.setText("매진");
											seat_1.setBackground(Color.gray);
										}
										if(set[1]!=null) {
											seat_2.setEnabled(false);
											seat_2.setText("매진");
											seat_2.setBackground(Color.gray);
										}
										if(set[2]!=null) {
											seat_3.setEnabled(false);
											seat_3.setText("매진");
											seat_3.setBackground(Color.gray);
										}
										if(set[3]!=null) {
											seat_4.setEnabled(false);
											seat_4.setText("매진");
											seat_4.setBackground(Color.gray);
										}
										if(set[4]!=null) {
											seat_5.setEnabled(false);
											seat_5.setText("매진");
											seat_5.setBackground(Color.gray);
										}
										if(set[5]!=null) {
											seat_6.setEnabled(false);
											seat_6.setText("매진");
											seat_6.setBackground(Color.gray);
										}
										if(set[6]!=null) {
											seat_7.setEnabled(false);
											seat_7.setText("매진");
											seat_7.setBackground(Color.gray);
										}
										if(set[7]!=null) {
											seat_8.setEnabled(false);
											seat_8.setText("매진");
											seat_8.setBackground(Color.gray);
										}
							}
							//} // if
						} catch (Exception ex) {
							
						} // catch
					} // for
				}//if
			}
		});//action
		
		// 매수 -label5
		JLabel l5 = new JLabel("매수");
		l5.setBounds(20, 545,300,100);
		l5.setFont(new Font("나눔고딕", Font.BOLD,15));
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		l5.setBackground(Color.WHITE);
		pan1.add(l5);

		//매수-성인 -label6
		JLabel l6 = new JLabel("성인");
		l6.setBounds(90,545,300,100);
		l6.setFont(new Font("나눔고딕", Font.BOLD,13));
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		pan1.add(l6);


		// 인원선택-성인-adult
		adult = new JComboBox();
		adult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == adult) {
					JComboBox<String> com = (JComboBox<String>)e.getSource();
					idx4 = (String) com.getSelectedItem();
					total += price* com.getSelectedIndex()*pt;
					insub = com.getSelectedIndex();
					submit += sub[insub];
				}
			}
		});
		adult.setModel(new DefaultComboBoxModel(new String[] {
				"0", "1", "2", "3", "4", "5", "6", "7", "8"}));
		adult.setBounds(260, 570, 100, 50);
		((JLabel)adult.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		adult.setBackground(Color.WHITE);
		pan1.add(adult);

		//label7 - 소아
		JLabel	l7 = new JLabel("소아");
		l7.setBounds(250,545,300,100);
		l7.setFont(new Font("나눔고딕", Font.BOLD,13));
		l7.setHorizontalAlignment(SwingConstants.CENTER);
		pan1.add(l7);

		// 인원선택칸 -소아 - kids
		kids = new JComboBox();
		kids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == kids) {
					JComboBox<String> com = (JComboBox<String>)e.getSource();
					idx3 = (String) com.getSelectedItem();
					total += price* com.getSelectedIndex()*pt;
					insub = com.getSelectedIndex();
					submit += sub[insub];

				}
			}
		});
		kids.setModel(new DefaultComboBoxModel(new String[] {
				"0", "1", "2", "3", "4", "5", "6", "7", "8"}));
		kids.setBounds(420, 570, 100, 50);
		((JLabel)kids.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		kids.setBackground(Color.WHITE);
		pan1.add(kids);

		//check1 - 현금결제
		rb3= new JRadioButton("현금결제");
		group2.add(rb3);
		rb3.setBounds(200, 650,100,30);
		rb3.setBackground(Color.WHITE);
		pan1.add(rb3);

		//check2 - 카드결제
		rb4= new JRadioButton("카드결제");
		group2.add(rb4);
		rb4.setBounds(350, 650, 100, 30);	
		rb4.setBackground(Color.WHITE);
		pan1.add(rb4);

		/*---------------------------------Right Side--------------------------------------------*/

		JLabel buschoice = new JLabel("좌석선택(일반,우등)");
		buschoice.setBounds(786, 100, 203, 16);
		pan1.add(buschoice);

		JLabel driver = new JLabel("운전석");
		driver.setForeground(Color.WHITE);
		driver.setBackground(Color.LIGHT_GRAY);
		driver.setOpaque(true);
		driver.setBounds(639, 150, 41, 163);
		pan1.add(driver);
		//좌석1
		seat_1 = new JButton("1");
		seat_1.setBounds(689, 150, 89, 72);
		seat_1.setBackground(null);
		pan1.add(seat_1);
		seat_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				seat_1.setBackground(new Color(235, 111, 49));
				set1 = (String)seat_1.getActionCommand();
				seat_1.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
					
				}
				
			}
		});
		//좌석2
		seat_2 = new JButton("2");
		seat_2.setBounds(689, 240, 89, 72);
		seat_2.setBackground(null);
		pan1.add(seat_2);
		seat_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				seat_2.setBackground(new Color(235, 111, 49));
				set2 = (String)seat_2.getActionCommand();
				seat_2.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
				}
			}
		});
		//좌석3
		seat_3 = new JButton("3");
		seat_3.setBounds(781, 150, 89, 72);
		seat_3.setBackground(null);
		seat_3.setEnabled(true);
		pan1.add(seat_3);
		seat_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seat_3.setBackground(new Color(235, 111, 49));
				set3 = (String)seat_3.getActionCommand();
				seat_3.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
				}
			}
		});
		//좌석4
		seat_4 = new JButton("4");
		seat_4.setBounds(781, 240, 89, 72);
		seat_4.setBackground(null);
		pan1.add(seat_4);
		seat_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seat_4.setBackground(new Color(235, 111, 49));
				set4 = (String)seat_4.getActionCommand();
				seat_4.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
				}
			}
		});
		//좌석
		seat_5 = new JButton("5");
		seat_5.setBounds(873, 150, 89, 72);
		seat_5.setBackground(null);
		pan1.add(seat_5);
		seat_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seat_5.setBackground(new Color(235, 111, 49));
				set5 = (String)seat_5.getActionCommand();
				seat_5.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
				}
			}
		});
		//좌석
		seat_6 = new JButton("6");
		seat_6.setBounds(873, 240, 89, 72);
		seat_6.setBackground(null);
		pan1.add(seat_6);
		seat_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seat_6.setBackground(new Color(235, 111, 49));
				set6 = (String)seat_6.getActionCommand();
				seat_6.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
				}
				
			}
		});
		//좌석
		seat_7 = new JButton("7");
		seat_7.setBounds(966, 150, 89, 72);
		seat_7.setBackground(null);
		pan1.add(seat_7);
		seat_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seat_7.setBackground(new Color(235, 111, 49));
				set7 = (String)seat_7.getActionCommand();
				seat_7.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
				}
			}
		});
		//좌석
		seat_8 = new JButton("8");
		seat_8.setBounds(966, 240, 89, 72);
		seat_8.setBackground(null);
		pan1.add(seat_8);
		seat_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seat_8.setBackground(new Color(235, 111, 49));
				set8 = (String)seat_8.getActionCommand();
				seat_8.setText("선택");
				submits +=1;
				if (submit<=submits) {
					seat_1.setEnabled(false);
					seat_2.setEnabled(false);
					seat_3.setEnabled(false);
					seat_4.setEnabled(false);
					seat_5.setEnabled(false);
					seat_6.setEnabled(false);
					seat_7.setEnabled(false);
					seat_8.setEnabled(false);
				}
			}
		});
		//좌선선택완료 
		complete = new JButton("완료");
		complete.setBounds(815, 345, 117, 29);
		complete.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		complete.setForeground(Color.white);
		complete.setBackground(new Color(235, 111, 49));
		complete.setBorderPainted(false);
		pan1.add(complete);
		complete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (e.getSource() == complete) {
					//파일얻기
					for (int i = 1; i <= 100; i++) {
						try {
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + i + ".ser"));
							BI mem = (BI) ois.readObject();
							ois.close();
							if (mem.start.equals(eng[idx1]) && mem.end.equals(engs[idx2])) {
								startss = mem.start; //출발지
								ends = mem.end; //도착지
								etimess = mem.etime; // 도착시간
								time1 = mem.time;//소요시간
								
							} // if
						} catch (Exception ex) {
							
						} // catch
					} // for
					
					//좌석정보빼내기
					File dir = new File(paths);
					File[] files = dir.listFiles();
					String[] fileinfo = new String[100];
					for (int i = 0; i < files.length; i++) {
						fileinfo[i+1] = files[i].getName();
					}//for
					
					try {
						for (int j = 1; j < 100; j++) {
							if (!((j+".ser").equals(fileinfo[j]))) {
								FileOutputStream out = new FileOutputStream(paths +j+ ".ser");
								ObjectOutputStream oos = new ObjectOutputStream(out);
								oos.writeObject(new SeatInfo(start[idx1], finish[idx2], stimes, etimess, years, months, days, setgrade,set1, set2, set3, set4, set5, set6, set7, set8) );
								oos.close();
								break;
							}//if	
						}
						
						// ObjectInputStream
					} catch (Exception s) {
						s.printStackTrace();
					}//catch
					//텍스트출력
					for (int i = 1; i <= 100; i++) {
						try {
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(paths + i + ".ser"));
							SeatInfo se2 = (SeatInfo) ois.readObject();
							ois.close();
							//System.out.println(se2.start+se2.grade);
							if (se2.start.equals(start[idx1]) && se2.finish.equals(finish[idx2]) && se2.year.equals(years) && se2.month.equals(months) && se2.day.equals(days) && se2.grade.equals(setgrade) && se2.stime.equals(stimes)) {
								choice_print.setText("출발지:"+se2.start+"  "+"도착지:"+se2.finish+"\n"+years+""+months+"월"+days+" "+stimes+" "+"고속"+setgrade+"\n"+"성인:"+idx4+"매"+" "+"소아:"+idx3+"매"+" "+"가격:"+total+"\n"+"위내역이맞습니까?");
							}
								
							//} // if
						} catch (Exception ex) {
							
						} // catch
					} // for
				}//if
				
			}//action
			
		});//action
		//출력부분
			
		choice_print.setBorder(BorderFactory.createDashedBorder(Color.darkGray));
		choice_print.setBounds(639, 400, 430, 151);
		choice_print.setBackground(Color.white);
		choice_print.setAlignmentY(CENTER_ALIGNMENT);
		choice_print.setFont(new Font("굴림", Font.BOLD, 25));
		choice_print.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pan1.add(choice_print);

		pay_button = new JButton("결제하기");
		pay_button.setBounds(815, 575, 117, 29);
		pay_button.setFont(new java.awt.Font("나눔고딕",Font.BOLD,15));
		pay_button.setForeground(Color.white);
		pay_button.setBackground(new Color(235, 111, 49));
		pay_button.setBorderPainted(false);
		pan1.add(pay_button);
		pay_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame fr = new JFrame("BusGo");
				 
				fr.setBounds(300,100,385,400);
				//pan5.setLayout(null);
				//이름
				pan5.setLayout(null);
				pan5.add(lab6);	pan5.add(txtf6);
				lab6.setBounds(50,50,90,40);
				lab6.setFont(new Font("굴림", Font.BOLD, 30));
				txtf6.setBounds(120,50,200,40);
				//PW
				pan5.add(lab7);	pan5.add(txtf7);
				lab7.setBounds(50,100,50,50);
				lab7.setFont(new Font("굴림", Font.BOLD, 30));
				txtf7.setBounds(120,110,200,40);
				//전화
				pan5.add(lab8);	pan5.add(txtf8);
				lab8.setBounds(50,160,90,50);
				lab8.setFont(new Font("굴림", Font.BOLD, 30));
				txtf8.setBounds(120,170,200,40);
				//결제하기버튼		
				pan5.add(pay);
				pay.setBounds(70,250,90,50);
				pay.setBackground(new Color(235, 111, 49));
				pay.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean fa = false;
		
						id = txtf6.getText();
						pw = txtf7.getText();
						ph = txtf8.getText();
						
						File dir = new File(pathC);
						File[] files = dir.listFiles();
						String[] fileinfo = new String[100];
						for (int i = 0; i < files.length; i++) {
							fileinfo[i+1] = files[i].getName();
						}//for
						
						try {
							for (int j = 1; j < 100; j++) {
								if (!((j+".ser").equals(fileinfo[j]))) {
									FileOutputStream out = new FileOutputStream(pathC +j+ ".ser");
									ObjectOutputStream oos = new ObjectOutputStream(out);
									oos.writeObject(new Revarate(id,pw,ph,start[idx1], finish[idx2], stimes, etimes, years, months, days, setgrade,set1, set2, set3, set4, set5, set6, set7, set8,total) );
									oos.close();
									fa = true;	
									int result =Opt.showConfirmDialog(null, "결제가완료되었습니다","Confirm",JOptionPane.YES_OPTION);
									if (result==Opt.YES_OPTION) {
										fr.setVisible(false);
									}
									break;
								}//if	
							}
							
						} catch (Exception s) {
							s.printStackTrace();
						}//catch
						if (fa) {
							seat_1.setEnabled(true);
							seat_1.setText("1");
							seat_1.setBackground(null);
						
							seat_2.setEnabled(true);
							seat_2.setText("2");
							seat_2.setBackground(null);
						
							seat_3.setEnabled(true);
							seat_3.setText("3");
							seat_3.setBackground(null);
						
							seat_4.setEnabled(true);
							seat_4.setText("4");
							seat_4.setBackground(null);
						
							seat_5.setEnabled(true);
							seat_5.setText("5");
							seat_5.setBackground(null);
						
							seat_6.setEnabled(true);
							seat_6.setText("6");
							seat_6.setBackground(null);
							seat_7.setEnabled(true);
							seat_7.setText("7");
							seat_7.setBackground(null);
							seat_8.setEnabled(true);
							seat_8.setText("8");
							seat_8.setBackground(null);
						}
					}
				});
				//취소하기
				pan5.add(can);
				can.setBounds(200,250,90,50);
				can.setBackground(new Color(235, 111, 49));
				fr.getContentPane().add(pan5);
				fr.setVisible(true);
				can.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						fr.setVisible(false);
					}
				});
				
				
			}
				
				
				
		});
				
	

		JButton re_choice_button = new JButton("다시선택");
		re_choice_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 다시선택하기 이벤트 처리 부분 
			}
		});
		re_choice_button.setBounds(860, 465, 117, 29);
		re_choice_button.setFont(new java.awt.Font("나눔고딕",Font.BOLD,40));
		re_choice_button.setForeground(Color.white);
		re_choice_button.setBackground(new Color(235, 111, 49));
		re_choice_button.setBorderPainted(false);
		pan1.add(re_choice_button);		
		
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
}//class

public class Swing_BusInfoMain {
	static Swing_BusInfoMain bus;
	public static void main(String[] args) {
		new BusManag();
	}//main
}//class
