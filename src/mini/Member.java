package mini;

import java.io.Serializable;

//����ȭ ����� �Ǵ� Member Ŭ����
public class Member implements Serializable {
	private static final long serialVersionUID = 100L; //�ڵ� ������ serialNumber�� �ٸ� ���ڷ� ����
	String name, id, pw;
	public Member(String name, String id, String pw) {
		this.name=name; this.id=id; this.pw=pw;
	}
	boolean chech(String id, String pw) {
		boolean flag = false;
		if(id.equals(this.id)&&pw.equals(this.pw)) { 
			flag = true;
			//id�� ���� this�� id�� ����, pw�� ���� this�� pw�� ���� ���ٸ� flag�� ���� true�� �ְڴ�
		}
		return flag;
	}

}
