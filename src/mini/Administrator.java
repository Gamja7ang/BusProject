package mini;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Administrator extends BasicFrame implements ActionListener {

	private static final long serialVersionUID = 1L; //�����ϰ� 1�� ����
	JPanel pan = new JPanel(new GridLayout(2, 2)); //GridLayout�� ������ 2�� 2ĭ¥�� Grid�� �����ض�
	JPanel pan1 = new JPanel(); //panel�� �׳� ��
	JLabel lab1 = new JLabel("ID"); //Label�� �����̱� ������ �޼ҵ� �ȿ� ���ڰ� ���� ��
	JLabel lab2 = new JLabel("PW");
	JTextField tx1 = new JTextField(10); //�Է»��ڿ� ���ڸ� �� �� ��������
	JPasswordField tx2 = new JPasswordField(10); //���������� ũ�� �Է�
	JButton bt = new JButton("�α���"); // �α��� ��ư
	
	static String path = "D:\\JAVA_LAB\\miniproject\\src\\mini\\AdminInfo\\"; 
	//����ȭ�Ǿ��� ���ϵ��� ������ ���� ��, �ҽ��ڵ� ���� ���ؼ�, ������ ������ ����ȭ ��Ű���� �ϴ� ��
	String id, pw;
	public Administrator() {
		this.setBounds(300, 100, 380, 300); //ũ�� ����
		init(); //���ο� �޼ҵ�, �ǳ� ���� ������Ʈ�� ��ڴ�
		this.setVisible(true);
	}
	
	public void init() {
		pan1.setLayout(null);
		pan1.add(lab1); //ID
		pan1.add(tx1); //ID���� �ؽ�Ʈ
		
		lab1.setBounds(50, 50, 40, 40); //ũ�� ����
		lab1.setFont(new Font(" ����", Font.BOLD, 30)); //����ü, ����, ũ�� 30
		tx1.setBounds(120, 50, 200, 40);
		//������� ID
		
		pan1.add(lab2);
		pan1.add(tx2);
		lab2.setBounds(50, 110, 50, 50);
		lab2.setFont(new Font("����",	Font.BOLD, 30));
		tx2.setBounds(120, 120, 200, 40);
		//�н�����
		
		
		//�α���, pan1�� ���̰ڴ�
		pan1.add(bt);
		bt.setBounds(150, 180, 90,50);
		bt.addActionListener(this);
		pan.add(pan1);
		this.getContentPane().add(pan1);
		
	} //End of init method

	@Override
	public void actionPerformed(ActionEvent arg0) {
		id = tx1.getText();
		pw = tx2.getText(); //�� �׾��� �� ��� ����
		
		if (check()) {
			//objectInputStream�� ����� ��, oi�� ������ try/catch���� �־��־�� ��
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+id+".ser"));
				Member mem = (Member)ois.readObject();
				ois.close();
					if(mem.pw.equals(this.pw)) {
						MainInterfaceMain.main.setVisible(false);
						this.setVisible(false);
					} else {
						System.out.println("�н����尡 Ʋ���ϴ�.");
					} //End of else
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("���̵� �����ϴ�.");
		} //outer else end
		
	}
	
	public static void main(String[] args) {
		new Administrator();
		
	}
	
	
	//�α��� ��ư�� ������ �� ����� �޼��� ����
	private boolean check() {
		boolean flag = false;
		File dir = new File(path);
		File [] files = dir.listFiles();
		for(int i = 0; i < files.length; i++) {
			if (!(files[i].isDirectory()) && (id + ".ser").equals(files[i].getName())) {//isDirectory : ���丮�ΰ� ���, ���丮�� �ƴ�
				// (id + ".ser").equals(files[i].getName()) : ���� �ȿ��ִ� �̸��� ������ ���� ������ Ȯ��
				flag = true; //���� �̸��� ������  true(�α��� ����, �α��� �� �ش� ���̵� ���� �ȿ� ������ ���� �ִ���)
			}//End of if
		}//End of for
		return flag;
	} //End of check method
	

}
