package mini;

import java.io.Serializable;

//직렬화 대상이 되는 Member 클래스
public class Member implements Serializable {
	private static final long serialVersionUID = 100L; //자동 생성된 serialNumber를 다른 숫자로 변경
	String name, id, pw;
	public Member(String name, String id, String pw) {
		this.name=name; this.id=id; this.pw=pw;
	}
	boolean chech(String id, String pw) {
		boolean flag = false;
		if(id.equals(this.id)&&pw.equals(this.pw)) { 
			flag = true;
			//id의 값이 this의 id와 같고, pw의 값이 this의 pw의 값과 같다면 flag의 값을 true로 주겠다
		}
		return flag;
	}

}
