package ip1_n;
import java.util.*;
import java.io.*;

public class encodewithK {
	  	   public static String decodeIndex(String S, int k) {
	  	  // Write your code here only
	  	    int size = 0;
	  	    for(int i = 0 ; i<S.length() ; i++){
	            // System.out.print(size + " ");
	            if(S.charAt(i) >= '0' && S.charAt(i) <= '9'){
	                size = size * (S.charAt(i)-'0');
	            }else{
	                size++;
	            }
	  	    }
	  	 //   System.out.print(size);
	        for(int i = S.length()-1 ; i>=0 ; i--){
	            char ch = S.charAt(i);
//	   	  	    System.out.print(ch);
		   	  	if(ch >= '0' && ch <= '9'){
	                size = size/(ch-'0');  
	            }
	   	  	    
	            else{
	            	if((k+1)%size == 0){
		                  return ch + "";
		                }
	                 size--;
	                }
	                k = k%size;
	        }
	        return "";
	  	  }
	  
	  
	  
	  	  
	  
	  	  // Dont make changes here
	  	  public static void main(String[] args) {
	  	  	  Scanner sc=new Scanner(System.in);
	  	  	  String s=sc.next();
	  	  	  int k=sc.nextInt();
	  	  	  System.out.println(decodeIndex(s,k));
	  	  }
	  
	  
}
