package mini;

import java.io.Serializable;

public class BI implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String start, end, num, grade, stime, etime;
	int time;
	
	public BI(String start, String end, String num, String grade, String stime, String etime, int time) {
		super();
		this.start = start;
		this.end = end;
		this.num = num;
		this.grade = grade;
		this.stime = stime;
		this.etime = etime;
		this.time = time;
	}
	
	public void prt() {
		System.out.println(start + " ���� " +stime+"�ÿ� ����Ͽ� " + time + "�ð� �ҿ��Ͽ� " + end + "��" + "�ÿ� ������ �����Դϴ�.");
	}
	
}
