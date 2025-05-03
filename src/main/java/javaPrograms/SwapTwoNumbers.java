package javaPrograms;

public class SwapTwoNumbers {

	/* swap two numbers without using third variables */
	
	public static void swapTwoNum(int a, int b) {
		System.out.println("Before swap the values are "+a+" "+b);
		a = a+b; /*Assume a is 2 and b is 3. so a+b is 5*/
		b = a-b; // Here a value is 5 and b value is 3. So 5-3 (a-b) is 2. Now  i got swaped one number
		a = a-b;// Now a is 5 and b is 2. so if we do 5-2 (a-b) is 3. Another value also swaped  
		System.out.println("After swap the values are "+a+" "+b);
	}
	
	public static void main(String[] args) {
		swapTwoNum(2, 3);
		swapTwoNum(5, 7);
		swapTwoNum(3, 40);
	}
}
