package BusProJect;

import java.io.Serializable;

public class Revarate implements Serializable {
	String name,pass,phon,start,finish,stime,etime,year,month,day,grade,bt;
	String seat1,seat2,seat3,seat4,seat5,seat6,seat7,seat8;
	int price;
	
	public Revarate(String name,String pass,String phon,String start,String finish,String stime,String etime,String year,String month,String day,String grade,String set1, String set2, String set3, String set4, String set5, String set6, String set7,
			String set8,int price) {
		this.name = name;//이름
		this.pass = pass;//비밀번호
		this.phon = phon;//폰번
		this.start = start; //출발지역
		this.finish = finish; //도착지역
		this.stime = stime; //출발시간
		this.etime = etime; //도착시간
		this.year = year; //년도
		this.month = month; //월
		this.day = day; //일
		this.grade = grade; //등급
		seat1 = set1;
		seat2 = set2;
		seat3 = set3;
		seat4 = set4;
		seat5 = set5;
		seat6 = set6;
		seat7 = set7;
		seat8 = set8;
		this.price = price;
	}
}
