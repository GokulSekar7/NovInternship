package javaPrograms;

public class ReverseString {

	
	public static void revreseString(String input) {
		//Declare String to store output
		String output ="";
		//iterate a reverse loop starts from length-1 and till zero
		for (int i =input.length()-1; i>=0; i--) {
			output = output + (input.charAt(i)); // Store the output and last char into the output
		}
		System.out.println(output);
	}
	
	
	
	public static void main(String[] args) {
		revreseString("Hello");
	}
	
}
