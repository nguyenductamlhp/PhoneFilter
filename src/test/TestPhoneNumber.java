package test;

import com.data.PhoneNumber;

public class TestPhoneNumber {

	public static void main(String[] args) {
		String S = "1659921517";
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setPhoneNum(S);
		if (phoneNumber.isPhoneNumber()) {
			System.out.println("This is Phone number");
		} else {
			System.out.println("This is not Phone number");
		}

	}

}
