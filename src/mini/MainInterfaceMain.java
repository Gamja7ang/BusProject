package mini;


//��� import �ڵ� ����(�����޼���â���� import ����)
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
//������ JFrame���� ���� �߻�, java���� javax.swing,JFrame���� ����Ǿ��ٴ� ���� �޼��� �ȳ� Ŭ��
//JFrame�� javax.swing.JFrame���� �����ϰڴٴ� �޼��� Ŭ���Ͽ� ����
class MainInterface extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L; //�ø��� 14�� �� MainInterface ���ٿ��� �ڵ������� �Ϳ� 1L�� ����
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JButton admin, b1, b2, b3;
	ImageIcon logo;
	JLabel picLabel, l1, l2, l3;
	boolean flag = true;
	String name;
	
	public MainInterface() {
		this.setTitle("Bus Manager"); //Ÿ��Ʋ��
		this.setBounds(300, 100, 1400, 800); //ũ�� ����
		pan2.setLayout(null); //Layout�� null������ �ϰڴ�.
		control(); //control �޼ҵ�
	}
	
	//control �޼ҵ� ����
	private void control() {
		logo = new ImageIcon("D:\\JAVA_LAB\\miniproject\\src\\mini\\IMG\\logo.jpg"); // ��ư �������� �̹����� ����
		picLabel = new JLabel(logo);
		picLabel.setBounds(550, 0, 300, 300);
		
		//������ �α���
		admin = new JButton("ADMIN");
		admin.setBounds(1000, 13, 100, 50); //ũ�� ����
		admin.setBackground(Color.GREEN); //���� ������� ����
		admin.setBorder(BorderFactory.createEtchedBorder(1)); 
		admin.setHorizontalAlignment(SwingConstants.CENTER); //��� ����
		admin.setBorderPainted(false); //BorderPainted ����
		
		//��ư
		b1 = new JButton(new ImageIcon("D:\\JAVA_LAB\\miniproject\\src\\mini\\IMG\\bus1.jpg"));
		b1.setBounds(300, 250, 210, 210);
		b1.setBackground(Color.WHITE);
		b1.setBorderPainted(false);
		b1.addActionListener(this); //ActionListener�� ����
		
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
		
		//Label �۾�
		l1 = new JLabel("BUS"); //Label �� ����
		l1.setBounds(350, 470, 100, 50); //��ġ �� ũ�� ����
		l1.setFont(new Font("�������", Font.BOLD, 30)); //���� ��Ʈ ����, BOLD�β���
		l1.setHorizontalAlignment(SwingConstants.CENTER); //��� ����

		l2 = new JLabel("TICKET");
		l2.setBounds(630, 470, 150, 50); //��ȣ ���� ���� �� ���ڴ� x, y ��ǥ ��, ���� �� ���ڴ� ���̿� �ʺ� ũ�� ����
		l2.setFont(new Font("�������", Font.BOLD, 30));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
	
		l3 = new JLabel("TERMINAL");
		l3.setBounds(910, 470, 180, 50);
		l3.setFont(new Font("�������", Font.BOLD, 30));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		
		pan2.setBackground(Color.WHITE); //pan2�� ���� ����
		pan2.add(picLabel); //pan2�� picLabel�� ���̰ڴ�
		pan2.add(admin); //pan2�� admin�� ���̰ڴ�
		pan2.add(b1); pan2.add(b2); pan2.add(b3); //pan2�� ��ư���� ���̰ڴ�
		pan2.add(l1); pan2.add(l2); pan2.add(l3); //pan2�� �󺧵��� ���̰ڴ�
		
		admin.addActionListener(this);
		this.getContentPane().add(pan2); //admin ��ư�� ������ �� pan2�� �ִ� ������ �ҷ����� �޼ҵ�getContentPane().add()
		
	}

	//���� �޴�
	//ActionEvent�� ���콺�� ���� �Է¹޴� ����
	//�ش� �κ��� �������� ������ ������ ���� ����
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

