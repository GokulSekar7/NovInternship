package javaPrograms;

public class ReverseOddSentence {

	public static void revreseOddString(String input) {
		// Declare String to store output
		String output ="";
		// Split the sentence by using space
		String[] eachWords = input.split(" ");
		// iterate the Array
		for (int i = 0; i < eachWords.length; i++) {
			
			//Check for odd sentence
			if(i%2==0) {
				
				//Iterate the odd sentence in reverse order
				for (int j= eachWords[i].length()-1 ; j>=0 ; j--) {
					// add each characters into the output string  
					if(j!=0) {
						output = output + eachWords[i].charAt(j);
					}else if((i==eachWords.length-1)&&(j==0)) {
						output = output + eachWords[i].charAt(j);
					}else {
						output = output + eachWords[i].charAt(j)+" ";
					}
				}
			}else {
				// If it is not odd sentence add it into the output directly
				if(i!=eachWords.length-1) {
					output = output+ eachWords[i]+" ";
				}else {
					output = output+ eachWords[i];
				}
			}
				
		}
		System.out.println(output);
	}
	
	
	
	
	public static void main(String[] args) {
		revreseOddString("Welcome to Testleaf");
	}
	
	
}
