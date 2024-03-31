package javaPrograms;

public class PrintPrimeOddEven {

	
	public static void checkNumber(int a) {
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
			
			// here check the condition, the boolean value  is still true and reminder is not equal to zero then it is both odd and prime 
			if(flag&&(a%2!=0)) {
				System.out.println("The number "+a+" is odd and prime");
			}else if(a%2!=0) {// the reminder is not zero then it is odd
				System.out.println("The number "+a+" is odd");
			}else { // all condition are not satisfied then the number is even
				System.out.println("The number "+a+" is even");
			}
		}else if(a%2!=0) {
			System.out.println("The number "+a+" is odd");
		}else {
			System.out.println("The number "+a+" is even");
		}
		
	}
	
	/*Print the prime number from 2 to some range*/
	public static void printTillInput(int x) {
		// iterate the loop from 1 to the given input
		for (int i = 1; i <=x ; i++) {
			// call check number
			checkNumber(i);		
		}
	}
	
	
	/*Print the prime number from particular range*/
	public static void printFromToRange(int start, int end) {
		// iterate the loop from starting range and till end range
		for (int i = start; i <=end; i++) {
			// call the check number
			checkNumber(i);
		}
	}
	
	
	
	public static void main(String[] args) {
		checkNumber(13);
		printTillInput(50);
		printFromToRange(100, 120);
	}
	
}
