package BusProJect;

import java.io.Serializable;

public class Revarate implements Serializable {
	String name,pass,phon,start,finish,stime,etime,year,month,day,grade,bt;
	String seat1,seat2,seat3,seat4,seat5,seat6,seat7,seat8;
	int price;
	
	public Revarate(String name,String pass,String phon,String start,String finish,String stime,String etime,String year,String month,String day,String grade,String set1, String set2, String set3, String set4, String set5, String set6, String set7,
			String set8,int price) {
		this.name = name;//�̸�
		this.pass = pass;//��й�ȣ
		this.phon = phon;//����
		this.start = start; //�������
		this.finish = finish; //��������
		this.stime = stime; //��߽ð�
		this.etime = etime; //�����ð�
		this.year = year; //�⵵
		this.month = month; //��
		this.day = day; //��
		this.grade = grade; //���
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
