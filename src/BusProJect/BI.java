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
		System.out.println(start+" 에서 " + stime +"시에 출발하여  "+time+"시간 소요 하여 "+end+" 에 "+ etime+" 시에 도착할 예정입니다." );
	}
}//class