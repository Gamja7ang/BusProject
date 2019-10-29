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

	private static final long serialVersionUID = 1L; //동일하게 1로 변경
	JPanel pan = new JPanel(new GridLayout(2, 2)); //GridLayout은 모눈종이 2줄 2칸짜리 Grid를 생성해라
	JPanel pan1 = new JPanel(); //panel은 그냥 판
	JLabel lab1 = new JLabel("ID"); //Label은 글자이기 때문에 메소드 안에 글자가 들어가야 함
	JLabel lab2 = new JLabel("PW");
	JTextField tx1 = new JTextField(10); //입력상자에 글자를 몇 자 찍을건지
	JPasswordField tx2 = new JPasswordField(10); //마찬가지로 크기 입력
	JButton bt = new JButton("로그인"); // 로그인 버튼
	
	static String path = "D:\\JAVA_LAB\\miniproject\\src\\mini\\AdminInfo\\"; 
	//직렬화되어진 파일들을 폴더에 담을 것, 소스코드 구분 위해서, 관리자 계정을 직렬화 시키려고 하는 것
	String id, pw;
	public Administrator() {
		this.setBounds(300, 100, 380, 300); //크기 지정
		init(); //새로운 메소드, 판넬 위에 컴포넌트를 얹겠다
		this.setVisible(true);
	}
	
	public void init() {
		pan1.setLayout(null);
		pan1.add(lab1); //ID
		pan1.add(tx1); //ID옆에 텍스트
		
		lab1.setBounds(50, 50, 40, 40); //크기 지정
		lab1.setFont(new Font(" 굴림", Font.BOLD, 30)); //굴림체, 굵게, 크기 30
		tx1.setBounds(120, 50, 200, 40);
		//여기까지 ID
		
		pan1.add(lab2);
		pan1.add(tx2);
		lab2.setBounds(50, 110, 50, 50);
		lab2.setFont(new Font("굴림",	Font.BOLD, 30));
		tx2.setBounds(120, 120, 200, 40);
		//패스워드
		
		
		//로그인, pan1에 붙이겠다
		pan1.add(bt);
		bt.setBounds(150, 180, 90,50);
		bt.addActionListener(this);
		pan.add(pan1);
		this.getContentPane().add(pan1);
		
	} //End of init method

	@Override
	public void actionPerformed(ActionEvent arg0) {
		id = tx1.getText();
		pw = tx2.getText(); //줄 그어진 것 사용 가능
		
		if (check()) {
			//objectInputStream을 해줘야 함, oi는 무조건 try/catch문을 넣어주어야 함
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+id+".ser"));
				Member mem = (Member)ois.readObject();
				ois.close();
					if(mem.pw.equals(this.pw)) {
						MainInterfaceMain.main.setVisible(false);
						this.setVisible(false);
					} else {
						System.out.println("패스워드가 틀립니다.");
					} //End of else
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("아이디가 없습니다.");
		} //outer else end
		
	}
	
	public static void main(String[] args) {
		new Administrator();
		
	}
	
	
	//로그인 버튼을 눌렀을 때 사용할 메서드 생성
	private boolean check() {
		boolean flag = false;
		File dir = new File(path);
		File [] files = dir.listFiles();
		for(int i = 0; i < files.length; i++) {
			if (!(files[i].isDirectory()) && (id + ".ser").equals(files[i].getName())) {//isDirectory : 디렉토리인가 물어봄, 디렉토리가 아님
				// (id + ".ser").equals(files[i].getName()) : 파일 안에있는 이름을 가져와 같은 것인지 확인
				flag = true; //같은 이름이 있으면  true(로그인 구현, 로그인 시 해당 아이디가 파일 안에 동일한 값이 있는지)
			}//End of if
		}//End of for
		return flag;
	} //End of check method
	

}
