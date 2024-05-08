package javaPrograms;

import java.util.Arrays;

public class SortArray {
	/*Sort an Array without using sort()*/
	
	public static void sortArray(int[] a) {
		//Declare a nested for loop 
		for (int i = 0; i < a.length; i++) { // here i starts from 0
			for(int j=i+1; j<a.length; j++) { // here j starts from i+1.
				// Compare the first number with rest of the numbers
				 // If first number is greater than rest of the number than interchange the numbers
				if(a[i]>a[j]) {
					// swap two number logic
					a[i] = a[i] + a[j];
					a[j] = a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
		}
		System.out.println(a);
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		int[]a ={1,5,4,2,3,1,4,5,2,3};
		sortArray(a);
	}
	
}
