package javaPrograms;

public class ReverseSentence {

	public static void reverseSentence(String input) {
		//Declare string to store output
		String output = "";
		// Split the string into Array by using space( )
		String[] eachWords = input.split(" ");
		// Iterate the Array in reverse order
		for (int i =eachWords.length-1 ; i>=0 ; i--) {
			if(i!=0) {
				output = output + eachWords[i] + " ";
			}else {
				output = output + eachWords[i];
			}
		}
		
		System.out.println(output);
	}
	
	
	
	
	
	public static void main(String[] args) {
		reverseSentence("Hello are you there!!");
	}
	
	
}
