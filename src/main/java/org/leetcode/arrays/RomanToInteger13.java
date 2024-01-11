package org.leetcode.arrays;


/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.*/



/*Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.*/




public class RomanToInteger13 {
	
	

    public static int getNumber(char a){
        int x = 0;
            switch (a){

            case 'I':
                x = 1;
                break;

            case 'V':
                x = 5;
                break;

            case 'X':
                x = 10;
                break;

            case 'L':
                x = 50;
                break;

            case 'C':
                x = 100;
                break;

            case 'D':
                x = 500;
                break;

            case 'M':
                x = 1000;
                break;
            
            }

            return x;
        }


    public int romanToInt(String s) {
        

        int output =0;
        char[] eachChar = s.toCharArray();
        if(eachChar.length>1){
        for(int i=0; i<eachChar.length-1; i++){
            int firstIndex = getNumber(eachChar[i]);
            int secondIndex = getNumber(eachChar[i+1]);
            if((firstIndex>=secondIndex)&&(i==eachChar.length-2)){
                output = output + getNumber(eachChar[i]);
                output = output + getNumber(eachChar[i+1]);
            }else if(firstIndex>=secondIndex){
                output = output + getNumber(eachChar[i]);
            }else if((firstIndex<secondIndex)&&(i==eachChar.length-3)){
                output =output +(secondIndex-firstIndex);
                i++;
                output = output + getNumber(eachChar[eachChar.length-1]);
            }else if(firstIndex<secondIndex){
                output =output +(secondIndex-firstIndex);
                i++;
            }
            
            
        }
        }else{
            output = getNumber(eachChar[0]);
        }
    return output;
    }
    
    

	public static void main(String[] args) {
		
	}

}
