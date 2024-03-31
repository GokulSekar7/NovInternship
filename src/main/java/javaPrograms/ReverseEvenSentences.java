package javaPrograms;

public class ReverseEvenSentences {

	public static void reverseEvenString(String input){
		//Declarte the String to store output
		String output ="";
		
		// Split the string by space
		String[] eachWords = input.split(" ");
		//iterate the Array
		for (int i = 0; i < eachWords.length; i++) {
			
			//Check for even Sentence
			if(i%2==1) {
				
				//Iterate the even sentence in reverse order
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
				// If it is not even sentence add it into the output directly
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
		reverseEvenString("Learn java and selenium");
	}
	
}
