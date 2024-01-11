package com.learn.threadLocal;

public class LearnEncapsulation {
	static String cardPinNumber;
	public static void setCardPin(String pinNum) {
		cardPinNumber = pinNum;
	}
	
	public static String getCardPin() {
		return cardPinNumber;
	}
	

	public static void main(String[] args) {
		setCardPin("1234");
		String cardPin = getCardPin();
		System.out.println("cardPin : " + cardPin);
	}

}
