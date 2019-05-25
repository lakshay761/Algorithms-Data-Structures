package march16;


//import LinkedList;
public class linkedlistImplement {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList l1 = new LinkedList();
//		
//		System.out.println(l1.isEmpty());
//		l1.addLast(10);	//0
//		l1.addLast(20);	//1	
//		l1.addLast(30);	//2
//		l1.display();
//		System.out.println(l1.getFirst());
//		System.out.println(l1.getLast());
//		System.out.println(l1.getSize());
//		System.out.println(l1.isEmpty());
//		System.out.println(l1.getAt(4));
//		l1.addAt(25,2);
//		l1.display();
//		System.out.println(l1.removeAt(2));
//		System.out.println();
//		System.out.println(l1.removeLast());
//		l1.display();
//		l1.addFirst(5);
//		l1.display();
//		System.out.println(l1.removeFirst());
//		l1.display();
		
		LinkedList l = new LinkedList();
		
		l.addLast(10);
		l.addLast(20);
		l.addLast(30);
		
		l.display();
		
		l.addFirst(40);
		l.addFirst(50);
		l.display();
		l.addAt(100, 3);
		l.display();
		System.out.println();
		l.removeFirst();
		l.removeFirst();
		l.display();
		l.removeLast();
		l.display();
		l.addLast(200);
		l.display();
		l.removeAt(2);
		l.display();
		
		l.revData();
		l.addFirst(300);
		l.addFirst(400);
		l.display();
		l.revPointer();
		l.display();
		l.dispRev();
		l.display();
		l.revPointRecursion();
		l.display();
		l.revDataRecursion();
		l.display();

		LinkedList l2 = new LinkedList();
		l2.addLast(10);
		l2.addLast(20);
		l2.addLast(30);
		l2.addLast(20);
		l2.addLast(10);
//		l2.display();
		//System.out.println(l2.IsPalindrome());
		l.fold();
		l.display();
//		System.out.println(l.getLast());
//		l.addLast(23);
//		l.display();
//		l.fold();
//		l.display();
//		l.addLast(25);
//		l.display();
		l.unfold();
		l.display();
		l.addLast(30);
		l.addLast(35);
		l.display();
		l.kReverse(3);
		l.display();
		l.oddEven();
		l.display();
//		l.addFirst(35);
//		l.addFirst(35);
//		l.addFirst(35);
//		l.addFirst(100);
//		l.addFirst(400);
//		l.display();
//		l.removeDuplicate();
//		l.display();
		LinkedList l3 = new LinkedList();
		l3.addFirst(1);
		l3.addFirst(1);
		l3.addFirst(1);
		l3.addFirst(1);
		l3.addFirst(2);
		l3.addFirst(2);
		l3.addFirst(2);
		l3.addFirst(3);
		l3.addFirst(3);
		l3.addFirst(3);
		l3.display();
		l3.removeDuplicate();
		l3.display();
		l3.addLast(25);
		l3.addFirst(35);
		l3.display();
	}

}
