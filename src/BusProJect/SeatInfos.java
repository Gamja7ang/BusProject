package BusProJect;

import java.io.Serializable;

public class SeatInfos implements Serializable {
	private static final long serialVersionUID = 1L;
	String seat1,seat2,seat3,seat4,seat5,seat6,seat7,seat8;


	public SeatInfos(String set1, String set2, String set3, String set4, String set5, String set6, String set7,
			String set8) {
		seat1 = set1;
		seat2 = set2;
		seat3 = set3;
		seat4 = set4;
		seat5 = set5;
		seat6 = set6;
		seat7 = set7;
		seat8 = set8;
	}
}
