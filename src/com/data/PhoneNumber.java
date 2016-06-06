package com.data;

public class PhoneNumber {

	private String PhoneNum;
	
	public PhoneNumber() {
		PhoneNum = "";
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	public boolean isPhoneNumber() {
		boolean flag = true;
		if (PhoneNum.length() >= 10 && PhoneNum.length() <= 13) {
			flag = true;
		}
		else {
			flag = false;
			return flag;
		}
		for (int i = 0; i < PhoneNum.length(); i++) {
			if ((PhoneNum.charAt(i) >= '0' && PhoneNum.charAt(i) <= '9') || PhoneNum.charAt(i) == '+') {
				flag = true;
			}
			else {
				flag = false;
				return flag;
			}
		}
		if (PhoneNum.charAt(0) != '0' || PhoneNum.charAt(0) != '+') {
			flag = false;
		}
		return flag;
	}
}
