/*Replace pi (recursive)
Send Feedback
Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
Constraints :
1 <= |S| <= 50
where |S| represents the length of string S. 
Sample Input 1 :
xpix
Sample Output :
x3.14x
Sample Input 2 :
pipi
Sample Output :
3.143.14
Sample Input 3 :
pip
Sample Output :
3.14p
Constraints:-
1<=|S|<=50*/

public class solution {

	// Return the changed string
	public static String replace(String input){
		String output;
        if(input.length() <= 1){
            return input;
        }
        String small = replace(input.substring(1));
        if(input.charAt(0)== 'p' && small.charAt(0)== 'i'){
            output = "3.14" + small.substring(1);
        }
        else{
            output = input.charAt(0) + small;
        }
        return output;

	}
}
