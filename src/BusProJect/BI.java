package BusProJect;

import java.io.Serializable;

public class BI implements Serializable{
	private static final long serialVersionUID = 1L;

	String start,end,num,grade,stime,etime;
	int time;
	public BI(String n,String g,String s, String e,String st,String et,int t) {
		num = n; 	start = s;		end = e; 		time=t;		grade=g;	stime=st;	etime=et;
	}//const
	public void prt(){
		System.out.println(start+" ���� " + stime +"�ÿ� ����Ͽ�  "+time+"�ð� �ҿ� �Ͽ� "+end+" �� "+ etime+" �ÿ� ������ �����Դϴ�." );
	}
}//class