/*Check Palindrome (recursive)
Send Feedback
Check whether a given String S is a palindrome using recursion. Return true or false.
Input Format :
String S
Output Format :
'true' or 'false'
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
racecar
Sample Output 1:
true
Sample Input 2 :
ninja
Sample Output 2:
false*/


public class solution {
	public static boolean solve(String str,int start,int end){
		if(start>=end){
			return true;
		}
		if(str.charAt(start)!=str.charAt(end)){
			return false;
		}
		return solve(str, start+1, end-1);
	}

	public static boolean isStringPalindrome(String input) {
		// Write your code here
		return solve(input, 0, input.length()-1);
	}
}
