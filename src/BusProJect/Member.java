package BusProJect;

import java.io.Serializable;

class Member implements Serializable{
	private static final long serialVesionUID = 100L;
	String name,id,pw;
	public Member(String name,String id,String pw) {
		this.name = name;		this.id = id;		this.pw = pw;
	}//const	
	boolean check(String id,String pw){
		boolean flag = false;
		if (id.equals(this.id) && pw.equals(this.pw)) {
			flag = true;
		}//if
		return flag;		
	}//check
}//class