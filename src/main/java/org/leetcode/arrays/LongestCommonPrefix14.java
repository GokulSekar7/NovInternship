package org.leetcode.arrays;

	/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".*/


/*Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

public class LongestCommonPrefix14 {
	
	public String longestCommonPrefix(String[] strs) {
        String output ="";
        try{
        for(int i=0; i< strs[0].length(); i++){
            int arrayLength = strs.length;
            int k =0;
            for(int j=0; j<arrayLength; j++){
                if(strs[0].charAt(i)==strs[j].charAt(i)){
                    k++;
                }   
            }
            if(k==arrayLength){
                    output = output + strs[0].charAt(i);
                }else{
                    break;
                }
        }
        }catch(Exception e){
            
        }
        return output;
    }

	public static void main(String[] args) {
		
	}
	
	
	
	
	
	/**
	 * 
        if(strs.length ==1 ){
            output = strs[0];
        }else if(strs.length == 2){
        
        String firstStr = strs[0];
        String secondStr = strs[1];
        

        int firstLen = firstStr.length();
        int secondLen = secondStr.length();
        
        
        if(firstLen<=secondLen){
            for(int i=0; i<firstLen; i++){
                if(firstStr.charAt(i)==secondStr.charAt(i)){
                    output = output + firstStr.charAt(i);
                }else{
                    break;
                }

            }
        }else if(secondLen<=firstLen){
            for (int i=0; i<secondLen; i++){
                if(secondStr.charAt(i)==firstStr.charAt(i)){
                        output = output + secondStr.charAt(i);
                }else{
                    break;
                }
            }
        }

        }else if (strs.length == 3){
        
        String firstStr = strs[0];
        String secondStr = strs[1];
        String thirdStr = strs[2];

        int firstLen = firstStr.length();
        int secondLen = secondStr.length();
        int thirdLen = thirdStr.length();
        
        if((firstLen<=secondLen)&&(firstLen<=thirdLen)){
            for(int i=0; i<firstLen; i++){
                if((firstStr.charAt(i)==secondStr.charAt(i))&&(firstStr.charAt(i)==thirdStr.charAt(i))){
                    output = output + firstStr.charAt(i);
                }else{
                    break;
                }

            }
        }else if((secondLen<=firstLen)&&(secondLen<=thirdLen)){
            for (int i=0; i<secondLen; i++){
                if((secondStr.charAt(i)==firstStr.charAt(i))&&(secondStr.charAt(i)==thirdStr.charAt(i))){
                        output = output + secondStr.charAt(i);
                }else{
                    break;
                }
            }
        }else{
            for(int i=0; i<thirdLen; i++){
                if((thirdStr.charAt(i)==secondStr.charAt(i))&&(thirdStr.charAt(i)==firstStr.charAt(i))){
                        output = output + thirdStr.charAt(i);
                }else{
                    break;
                }
            }
        }
        }else if(strs.length==4){

        String firstStr = strs[0];
        String secondStr = strs[1];
        String thirdStr = strs[2];
        String fourthStr = strs[3];

        int firstLen = firstStr.length();
        int secondLen = secondStr.length();
        int thirdLen = thirdStr.length();
        int fourthLen = fourthStr.length();
        
        if((firstLen<=secondLen)&&(firstLen<=thirdLen)&&(firstLen<=fourthLen)){
            for(int i=0; i<firstLen; i++){
                if((firstStr.charAt(i)==secondStr.charAt(i))&&(firstStr.charAt(i)==thirdStr.charAt(i))&&(firstStr.charAt(i)==fourthStr.charAt(i))){
                    output = output + firstStr.charAt(i);
                }else{
                    break;
                }

            }
        }else if((secondLen<=firstLen)&&(secondLen<=thirdLen)&&(secondLen<=fourthLen)){
            for (int i=0; i<secondLen; i++){
                if((secondStr.charAt(i)==firstStr.charAt(i))&&(secondStr.charAt(i)==thirdStr.charAt(i))&&(secondStr.charAt(i)==fourthStr.charAt(i))){
                        output = output + secondStr.charAt(i);
                }else{
                    break;
                }
            }
        }else if((thirdLen<=firstLen)&&(thirdLen<=secondLen)&&(thirdLen<=fourthLen)){
            for(int i=0; i<thirdLen; i++){
                if((thirdStr.charAt(i)==secondStr.charAt(i))&&(thirdStr.charAt(i)==firstStr.charAt(i))&&(thirdStr.charAt(i)==fourthStr.charAt(i))){
                        output = output + thirdStr.charAt(i);
                }else{
                    break;
                }
            }
        }else{
            for(int i=0; i<fourthLen; i++){
                if((fourthStr.charAt(i)==firstStr.charAt(i))&&(fourthStr.charAt(i)==secondStr.charAt(i))&&(fourthStr.charAt(i)==thirdStr.charAt(i))){
                    output = output + fourthStr.charAt(i);
                }else{
                    break;
                }
            }
        }


        }
	 * **/

}
