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
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import javafx.scene.layout.Border;

class AlignedTable extends DefaultTableCellRenderer {
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

public class Swing_BInPut extends BasicFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static String path = "C:\\workspace\\src\\BusProJect\\TimeInfo\\";
	boolean flag = false;
	String names;
	JPanel pan = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel gpan = new JPanel(new GridLayout(1, 2));
	JButton bt1 = new JButton("운행정보관리");
	JButton bt2 = new JButton("매출정보관리");
	JButton bt3 = new JButton("배차정보등록");
	JButton bt4 = new JButton("배차정보삭제");
	JButton bt5 = new JButton("배차정보조회");
	JButton bt6 = new JButton("배차전체조회");
	JButton back = new JButton("뒤로가기");
	JLabel lab = new JLabel("<관리자모드>", JLabel.CENTER);
	JLabel lab1 = new JLabel("출발지", JLabel.CENTER);
	JLabel lab2 = new JLabel("도착지", JLabel.CENTER);
	JLabel lab3 = new JLabel("등급", JLabel.CENTER);
	JLabel lab4 = new JLabel("소요시간", JLabel.CENTER);
	JTextField tx = new JTextField(JTextField.CENTER);
	String[] start = { "울산", "부산", "대구", "대전", "광주", "서울" };
	String[] finish = { "울산", "부산", "대구", "대전", "광주", "서울" };
	// 선택에대한결과값
	String[] eng = { "ul", "bu", "da", "dj", "gw", "se" };
	String[] engs = { "ul", "bu", "da", "dj", "gw", "se" };
	String[] grade = { "일반", "우등" };

	String[] stime = new String[55];
	String[] str = new String[55];
	String[] end = new String[55];
	String[] ftime = new String[55];
	int[] satime = new int[4];
	int cnt = 0;
	JComboBox<String> st = new JComboBox<String>(start);
	JComboBox<String> fn = new JComboBox<String>();
	JComboBox<String> gr = new JComboBox<String>(grade);
	String[] cdata = { "시간", "출발지", "도착지", "등급", "소요시간" };
	String[][] rdata = new String[102][102];
	JTable table = new JTable(rdata, cdata);
	JScrollPane span = new JScrollPane(table);
	int idx1, idx2, idx3, nidx;
	int cnts=0;
	AlignedTable align = new AlignedTable();

	public Swing_BInPut() {
		table.setDefaultRenderer(table.getColumnClass(0), align);
		init();
		this.setVisible(true);
	}

	private void init() {
		// pan
		pan1.setLayout(null);
		back.setLocation(1080, 10);
		pan.add(back);
		back.setBounds(1080, 5, 300, 60);
		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		pan1.add(bt4);
		pan1.add(bt5);
		pan1.add(bt6);
		pan1.add(lab1);
		pan1.add(lab2);
		pan1.add(lab3);
		pan1.add(lab4);
		pan1.add(tx);
		pan1.add(st);
		pan1.add(fn);
		pan1.add(gr);
		bt6.addActionListener(this);
		back.addActionListener(this);
		// Size
		bt1.setBounds(40, 20, 300, 80);
		bt2.setBounds(350, 20, 300, 80);
		bt3.setBounds(40, 510, 300, 80);
		bt4.setBounds(350, 510, 300, 80);
		bt5.setBounds(40, 610, 300, 80);
		bt6.setBounds(350, 610, 300, 80);
		lab.setBounds(550, 5, 300, 50);
		lab1.setBounds(40, 120, 270, 100);
		lab2.setBounds(40, 220, 270, 100);
		lab3.setBounds(40, 320, 270, 100);
		lab4.setBounds(40, 420, 270, 100);
		tx.setBounds(350, 445, 300, 50);
		st.setBounds(350, 120, 300, 100);
		fn.setBounds(350, 220, 300, 100);
		gr.setBounds(350, 320, 300, 100);
		table.setRowHeight(30);
		gpan.add(pan1);
		gpan.add(span);

		// 버튼디자인
		bt1.setForeground(Color.white);
		bt1.setFont(new Font("굴림", Font.BOLD, 20));
		bt1.setBackground(new Color(235, 111, 49));
		bt2.setForeground(Color.white);
		bt2.setFont(new Font("굴림", Font.BOLD, 20));
		bt2.setBackground(new Color(235, 111, 49));
		bt3.setForeground(Color.white);
		bt3.setFont(new Font("굴림", Font.BOLD, 20));
		bt3.setBackground(new Color(235, 111, 49));
		bt4.setForeground(Color.white);
		bt4.setFont(new Font("굴림", Font.BOLD, 20));
		bt4.setBackground(new Color(235, 111, 49));
		bt5.setForeground(Color.white);
		bt5.setFont(new Font("굴림", Font.BOLD, 20));
		bt5.setBackground(new Color(235, 111, 49));
		bt6.setForeground(Color.white);
		bt6.setFont(new Font("굴림", Font.BOLD, 20));
		bt6.setBackground(new Color(235, 111, 49));
		back.setForeground(Color.white);
		back.setFont(new Font("굴림", Font.BOLD, 20));
		back.setBackground(new Color(235, 111, 49));
		lab1.setFont(new Font("굴림", Font.BOLD, 20));
		lab1.setBackground(new Color(235, 111, 49));
		lab2.setFont(new Font("굴림", Font.BOLD, 20));
		lab2.setBackground(new Color(235, 111, 49));
		lab3.setFont(new Font("굴림", Font.BOLD, 20));
		lab3.setBackground(new Color(235, 111, 49));
		lab4.setFont(new Font("굴림", Font.BOLD, 20));
		lab4.setBackground(new Color(235, 111, 49));
		st.setForeground(Color.white);
		st.setFont(new Font("굴림", Font.BOLD, 20));
		st.setBackground(new Color(235, 111, 49));
		fn.setForeground(Color.white);
		fn.setFont(new Font("굴림", Font.BOLD, 20));
		fn.setBackground(new Color(235, 111, 49));
		gr.setForeground(Color.white);
		gr.setFont(new Font("굴림", Font.BOLD, 20));
		gr.setBackground(new Color(235, 111, 49));
		// action
		back.setForeground(Color.white);
		back.setFont(new Font("굴림", Font.BOLD, 20));
		back.setBackground(new Color(91, 155, 213));
		st.addActionListener(this);
		fn.addActionListener(this);
		gr.addActionListener(this);
		bt5.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt2.addActionListener(this);
		
		this.getContentPane().add(pan, BorderLayout.NORTH);
		this.getContentPane().add(gpan);
		// this.getContentPane().add(pan);
	}// init

	public static void main(String[] args) {
		new Swing_BInPut();
	}// main

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//매출정보가기
		if (arg0.getSource() == bt2) {
			Data dt = new Data();
			this.setVisible(false);
		}
		//배차정보등록
		if (arg0.getSource() == bt3) {
			BusInfos bi = new BusInfos();
		}
		//배차정보삭제
		if (arg0.getSource() == bt4) {
			BusInfosReMov bm = new BusInfosReMov();
		}
		// 버튼
		if (arg0.getSource() == back) {
			Swing_BusManager sb = new Swing_BusManager();
			this.setVisible(false);
		} // if
		if (arg0.getSource() == st) {
			flag = false;
			JComboBox<String> com = (JComboBox<String>) arg0.getSource();
			idx1 = com.getSelectedIndex();
			fn.removeAllItems();
			if (com.getSelectedIndex() != 0) {
				fn.addItem(finish[0]);
			} else {
				fn.addItem(finish[1]);
				fn.addItem(finish[2]);
				fn.addItem(finish[3]);
				fn.addItem(finish[4]);
				fn.addItem(finish[5]);
				flag = true;
			}
		} else if (arg0.getSource() == fn) {
			JComboBox<String> com = (JComboBox<String>) arg0.getSource();
			idx2 = 0;
			idx2 = com.getSelectedIndex();
			if (flag) {
				idx2 += 1;
			}

		} else if (arg0.getSource() == gr) {
			JComboBox<String> com = (JComboBox<String>) arg0.getSource();
			idx3 = com.getSelectedIndex();

		}
		// combobox
		// JComboBox<String> com = (JComboBox<String>) arg0.getSource();
		if (arg0.getSource() == bt5) {
			cnt = 0;
			this.getContentPane().add(gpan);
			//if (check()) {
			for (int i = 0; i <= 100; i++) {
				rdata[i][0] = ""; // 출발시간
				rdata[i][1] = ""; // 출발점
				rdata[i][2] = "";// 도착점
				rdata[i][3] = ""; // 등급
				rdata[i][4] ="";	
				}
				for (int i = 1; i <= 100; i++) {
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + i + ".ser"));
						BI mem = (BI) ois.readObject();
						ois.close();
						if (mem.start.equals(eng[idx1]) && mem.end.equals(engs[idx2])) {

							str[cnt] = mem.start;
							end[cnt] = mem.end;
							stime[cnt] = mem.stime;
							ftime[cnt] = mem.etime;
							// satime[cnt] = Integer.parseInt(mem.time);
							tx.setText(mem.time + "시간소요");
							rdata[cnt][0] = stime[cnt]; // 출발시간
							rdata[cnt][1] = str[cnt]; // 출발점
							rdata[cnt][2] = end[cnt]; // 도착점
							rdata[cnt][3] = grade[idx3]; // 등급
							rdata[cnt][4] = String.valueOf(mem.time + "시간");// 시간
							// rdata[cnt][4] =
							// Integer.parseInt(satime[cnt]);
							cnt++;
						} // if
					} catch (Exception ex) {

					} // catch
				} // for
			} // outif
			tx.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			tx.setFont(new Font("굴림", Font.BOLD, 20));
			
			if (arg0.getSource() == bt6) {
				
				File dir = new File(path);
				File[] files = dir.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (!(files[i].isDirectory())) {
						names = files[i].getName();
						//System.out.println(names);
						prt(names);
						
					} // if
				}
				
				tx.setHorizontalAlignment((int) CENTER_ALIGNMENT);
				tx.setFont(new Font("굴림", Font.BOLD, 20));
			}
		} // action

	 private void prt(String name) {
			try {
				ObjectInputStream oiss = new ObjectInputStream(new FileInputStream(path + names));
				BI mem = (BI) oiss.readObject();
					str[cnts] = mem.start;
					end[cnts] = mem.end;
					
					stime[cnts] = mem.stime;
					ftime[cnts] = mem.etime;
					tx.setText(mem.time + "시간소요");
					rdata[cnts][0] = stime[cnts]; // 출발시간
					rdata[cnts][1] = str[cnts]; // 출발점
					rdata[cnts][2] = end[cnts]; // 도착점
					rdata[cnts][3] = grade[idx3]; // 등급
					rdata[cnts][4] = String.valueOf(mem.time + "시간");
					oiss.close();
					cnts++;
					
					this.getContentPane().add(gpan);
			} catch (Exception ex) {
		} // catch
	 }

	private boolean check() {
		boolean flag = false;
			File dir = new File(path);
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
				if ((files[i].getName().equals(i + ".ser"))) {

					flag = true;
				} // if
			} // for
		return flag;
	}// check
}// class