package org.leetcode.arrays;

/*Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 */


/*Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */


public class Palindrome9 {
	
	public boolean isPalindrome(int x) {
        boolean output = false;
        if(x>=0){
            int num = x;
            int temp= 0;
            while(num>0){
                int rem = num%10;
                temp = (temp*10)+rem;
                num= num/10;
            }
            if(x==temp){
                output = true;
            }
        }

    return output;
    }

	public static void main(String[] args) {
		
	}

}
