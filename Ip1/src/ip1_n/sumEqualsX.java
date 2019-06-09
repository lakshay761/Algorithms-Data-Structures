package ip1_n;
import java.util.*;

public class sumEqualsX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareString("zb#c", "zd#c"));
		
	}
	public static boolean compareString(String S, String T) {
	 	 //write your code here
	 	 Stack<Character> st1 = new Stack<>();
	 	 Stack<Character> st2 = new Stack<>();
	 	 for(int i=0;i<S.length();i++){
	 	    if(S.charAt(i) == '#'){
	 	        st1.pop();
	 	    }else{
	 	        st1.push(S.charAt(i));
	 	    }   
	 	 }
	 	 for(int i=0;i<T.length();i++){
	 	    if(S.charAt(i) == '#'){
	 	        st2.pop();
	 	    }else{
	 	        st2.push(T.charAt(i));
	 	    }   
	 	 }
	 	 if(st1.peek() == st2.peek()){
	 	    return true;
	 	 }else{
	 	     return false;
	 	 }
	 }
	public static void printBinary(String S) {
		
	}
}
