package mini;

import javax.swing.JFrame;

public class BasicFrame extends JFrame{

		public BasicFrame() {
			this.setTitle("BusGo");
			this.setBounds(300, 100, 1400, 800);
			this.setVisible(true); //true���� �־����Ƿ� ����� �ƹ��͵� ���� â�� ��
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�ݱ� ��ư�� ������ ��������
		}
		public static void main(String[] args) {
			new BasicFrame();
			
		}


}
