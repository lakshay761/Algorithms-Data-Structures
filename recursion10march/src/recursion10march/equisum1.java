package recursion10march;

public class equisum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mylist = { 10, 20, 30, 40, 50, 60, 70 };
		es(mylist,0,"",0,"",0);
	}

	public static void es(int[] arr, int id, String s1, int sos1, String s2, int sos2) {
		if(id == arr.length) {
			if(sos1 == sos2) {
				System.out.println("S1 -" + s1 + " S2 -" + s2);
			}
			return;
		}
		
		es(arr, id + 1, s1 + arr[id] + " ", sos1 + arr[id], s2, sos2);
		if(id!=0) {
		es(arr, id + 1, s1, sos1, s2 + arr[id] + " ", sos2 + arr[id]);
		}
	}
}
