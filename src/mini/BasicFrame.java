package mini;

import javax.swing.JFrame;

public class BasicFrame extends JFrame{

		public BasicFrame() {
			this.setTitle("BusGo");
			this.setBounds(300, 100, 1400, 800);
			this.setVisible(true); //true값을 주었으므로 실행시 아무것도 없는 창이 뜸
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼을 누르면 닫혀져라
		}
		public static void main(String[] args) {
			new BasicFrame();
			
		}


}
