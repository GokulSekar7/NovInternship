package javaPrograms;

public class PrimeNumber {

	/*Number which is divide by 1 and the same number itself is prime number
	 *Prime numbers are 2,3,5,7,11,13,17,19,23,29,.......
	 *1 is not a prime number */
	
	public static void checkPrime(int a) {
		// Prime numbers are starts from 2, So check the number is greater than 1
		if(a>1) {
			// declare  a boolean as true
			boolean flag = true;
			// iterate from 2 to less than number
			for (int i = 2; i <a; i++) {
				
				// divide the number from 2 to less than number
				if(a%i==0) {
					// If the condition satisfied boolean as false
					flag = false;
				}
			}
			
			// here check the condition, the boolean value  is still true then the number is prime 
			if(flag) {
				System.out.println("The number "+a+" is prime");
			}else {
				System.out.println("The number "+a+" is not a prime");
			}
		}else {
			System.out.println("The number "+a+" is not a prime");
		}
		
	}
	
	
	
	/*Print the prime number from 2 to some range*/
	public static void printPrimeTill(int x) {
		// iterate the loop from 2 to the given input
		for (int i = 2; i <=x ; i++) {
			// call check prime logic
			checkPrime(i);			
		}
	}
	
	
	/*Print the prime number from particular range*/
	public static void printPrimeRange(int start, int end) {
		// iterate the loop from starting range and till end range
		for (int i = start; i <=end; i++) {
			// call the check prime 
			checkPrime(i);
		}
	}
	
	
	
	public static void main(String[] args) {
		checkPrime(13);
		printPrimeTill(100);
		printPrimeRange(1000, 2000);
	}
}
