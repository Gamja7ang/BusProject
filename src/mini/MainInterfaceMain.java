package mini;


//모든 import 자동 생성(에러메세지창에서 import 설정)
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//public class MainInterface extends JFrame implements ActionListener
//위에서 JFrame에서 에러 발생, java에서 javax.swing,JFrame으로 변경되었다는 에러 메세지 안내 클릭
//JFrame을 javax.swing.JFrame으로 변경하겠다는 메세지 클릭하여 변경
class MainInterface extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L; //시리얼 14번 줄 MainInterface 밑줄에서 자동생성된 것에 1L로 변경
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JButton admin, b1, b2, b3;
	ImageIcon logo;
	JLabel picLabel, l1, l2, l3;
	boolean flag = true;
	String name;
	
	public MainInterface() {
		this.setTitle("Bus Manager"); //타이틀명
		this.setBounds(300, 100, 1400, 800); //크기 지정
		pan2.setLayout(null); //Layout을 null값으로 하겠다.
		control(); //control 메소드
	}
	
	//control 메소드 지정
	private void control() {
		logo = new ImageIcon("D:\\JAVA_LAB\\miniproject\\src\\mini\\IMG\\logo.jpg"); // 버튼 아이콘을 이미지로 지정
		picLabel = new JLabel(logo);
		picLabel.setBounds(550, 0, 300, 300);
		
		//관리자 로그인
		admin = new JButton("ADMIN");
		admin.setBounds(1000, 13, 100, 50); //크기 지정
		admin.setBackground(Color.GREEN); //배경색 녹색으로 지정
		admin.setBorder(BorderFactory.createEtchedBorder(1)); 
		admin.setHorizontalAlignment(SwingConstants.CENTER); //가운데 정렬
		admin.setBorderPainted(false); //BorderPainted 없음
		
		//버튼
		b1 = new JButton(new ImageIcon("D:\\JAVA_LAB\\miniproject\\src\\mini\\IMG\\bus1.jpg"));
		b1.setBounds(300, 250, 210, 210);
		b1.setBackground(Color.WHITE);
		b1.setBorderPainted(false);
		b1.addActionListener(this); //ActionListener를 지정
		
		b2 = new JButton(new ImageIcon("D:\\JAVA_LAB\\miniproject\\src\\mini\\IMG\\ticket.jpg"));
		b2.addActionListener(this);
		b2.setBounds(600, 250, 210, 210);
		b2.setBackground(Color.WHITE);
		b2.setBorderPainted(false);
		
		b3 = new JButton(new ImageIcon("D:\\JAVA_LAB\\miniproject\\src\\mini\\IMG\\terminal.jpg"));
		b3.addActionListener(this);
		b3.setBounds(900, 250, 210, 210);
		b3.setBackground(Color.WHITE);
		b3.setBorderPainted(false);
		
		//Label 작업
		l1 = new JLabel("BUS"); //Label 명 설정
		l1.setBounds(350, 470, 100, 50); //위치 및 크기 지정
		l1.setFont(new Font("나눔고딕", Font.BOLD, 30)); //글자 폰트 설정, BOLD두껍게
		l1.setHorizontalAlignment(SwingConstants.CENTER); //가운데 정렬

		l2 = new JLabel("TICKET");
		l2.setBounds(630, 470, 150, 50); //괄호 안의 앞의 두 숫자는 x, y 좌표 값, 뒤의 두 숫자는 높이와 너비 크기 지정
		l2.setFont(new Font("나눔고딕", Font.BOLD, 30));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
	
		l3 = new JLabel("TERMINAL");
		l3.setBounds(910, 470, 180, 50);
		l3.setFont(new Font("나눔고딕", Font.BOLD, 30));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		
		pan2.setBackground(Color.WHITE); //pan2의 배경색 설정
		pan2.add(picLabel); //pan2에 picLabel을 붙이겠다
		pan2.add(admin); //pan2에 admin을 붙이겠다
		pan2.add(b1); pan2.add(b2); pan2.add(b3); //pan2에 버튼들을 붙이겠다
		pan2.add(l1); pan2.add(l2); pan2.add(l3); //pan2에 라벨들을 붙이겠다
		
		admin.addActionListener(this);
		this.getContentPane().add(pan2); //admin 버튼을 눌렀을 때 pan2에 있는 내용을 불러오는 메소드getContentPane().add()
		
	}

	//메인 메뉴
	//ActionEvent가 마우스를 통해 입력받는 내용
	//해당 부분이 구현되지 않으면 실행이 되지 않음
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == admin) {
			Administrator ad = new Administrator();
			
		} else if(e.getSource() ==b1) {
			BusManager bm = new BusManager();
			this.setVisible(false);
		} else if(e.getSource() == b2) {
			Swing_ReservationInfo sr = new Swing_ReservationInfo();
			this.setVisible(false);
		} else if(e.getSource() == b3) {
			Swing_TerminalInfo st = new Swing_TerminalInfo();
			this.setVisible(false);
		}

	}
	
}

//End of MainInterface


	public class MainInterfaceMain{
		static MainInterface main;
		public static void main(String[] args) {
			main = new MainInterface();
		} //End of Main Method

	} //End of Class

