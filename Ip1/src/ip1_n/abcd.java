package ip1_n;

	import java.util.LinkedList;
	 import java.util.Queue;
	 import java.util.Scanner;
	 
	public class abcd{
	 	 // Complete the functions
	 	 static class RecentFetch {
	     	 
	     	 public int ping(int t) {
	     	     if(q.size() == 0){
	     	         q.add(t);
	     	     }
	     	     else{
	         	     while(q.peek() < t-3000 && q.size()>0){
	         	         q.remove();
	         	     }
	         	     q.add(t);
	     	     }
	     	     return q.size();
	     	 }
	 	 }
	     
	 
	 
	     static Queue<Integer> q= new LinkedList<>(); 
	 
	 
	 	 // Dont make changes here 
	 	 public static void main(String[] args){
	 	 	 RecentFetch rf=new RecentFetch();
	 	 	 Scanner sc=new Scanner(System.in);
	 	 	 int n=sc.nextInt();
	 	 	 for(int i=0;i<n;i++){
	 	 	 	 System.out.print(rf.ping(sc.nextInt())+" ");
	 	 	 }
	 	 }
	 
	 
	 }

