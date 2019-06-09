package ip1_n;

import java.util.Scanner;

public class vowelLL {
	 
	 
	     public static void main(String args[]) {
	         Scanner sc = new Scanner(System.in);
	             
	         int n = sc.nextInt();
	         char h = sc.next().charAt(0);
	         insert(h);
	 
	         for (int i = 1; i < n; i++) {
	             char ch = sc.next().charAt(0);
	             insert(ch);
	         }
	         
	         head = arcv(head);
	         display();
	         
	     }
	 
	     //---------------------------------------------------------------
	     //This is a functional problem. Only this function has to be written.
	     // This function should return the head of node after sorting.
	     public static Node arcv(Node head) {
	         Node cn = head;
	        //  Node v = null;
	         Node vh = null;
	         Node vt = null;
	        //  Node c = null;
	         Node ch = null;
	         Node ct = null;
	        //  Node p = 
	         while(cn != null){
	             if(cn.data == 'a' || cn.data == 'e' ||cn.data == 'i' ||cn.data == 'o' ||cn.data == 'u'){
	                 Node n = new Node(cn.data,null);
	                //  n.data = cn.data;
	                 if(vh == null){
	                     vh = n;
	                     vt = n;
	                     n.next = null;
	                 }
	                 else{
	                     vt.next = n;
	                     vt = n;
	                 }
	             }
	             else{
	                 Node n = new Node(cn.data,null);
	                 n.data = cn.data;
	                 if(ch == null){
	                     ch = n;
	                     ct = n;
	                     n.next = null;
	                 }
	                 else{
	                     ct.next = n;
	                     ct = n;
	                 }
	             }
	         }
	         vt.next = ch;
	         vt = ct;
	         return vh;
	     }
	 //------------------------------------------------------------------
	 
	     
	     private static class Node {
	         char data;
	         Node next;
	 
	         public Node(char data, Node next) {
	             this.data = data;
	             this.next = next;
	         }
	 
	     }
	 
	     static Node head;
	     static Node tail;
	     static int size;
	 
	     public static void insert(char data) {
	 
	         Node nn = new Node(data, null);
	         if (head == null) {
	             head = nn;
	             tail = nn;
	         } else {
	             tail.next = nn;
	             tail = nn;
	         }
	         size++;
	     }
	 
	     public static void display() {
	         for (Node node = head; node != null; node = node.next) {
	             System.out.print(node.data+" ");
	         }
	     }
	 
	 }

