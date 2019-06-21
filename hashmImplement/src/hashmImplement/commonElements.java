package hashmImplement;
import java.util.HashMap;
import java.util.ArrayList;
public class commonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2,1,5,1,3,2,1};
		int[] arr2 = {4,5,2,1,2,1,2};
		pce1(arr1,arr2);
		System.out.println();
		pce2(arr1,arr2);
	}
	public static void pce1(int[] arr1,int[] arr2) {
		HashMap<Integer,Integer> hm1= new HashMap<>();
	
		for(int a :arr1) {
			if(hm1.containsKey(a)) {
				hm1.put(a, hm1.get(a)+1);
			}
			else {
				hm1.put(a, 1);
			}
		}
		for(int a:arr2) {
			if(hm1.containsKey(a)== true) {
				System.out.print(a + " ");
				hm1.remove(a);
			}
		}
	}
	public static void pce2(int[] arr1,int[] arr2) {
		HashMap<Integer,Integer> hm1= new HashMap<>();
	
		for(int a :arr1) {
			if(hm1.containsKey(a)) {
				hm1.put(a, hm1.get(a)+1);
			}
			else {
				hm1.put(a, 1);
			}
		}
		for(int a:arr2) {
			if(hm1.containsKey(a)== true) {
				System.out.print(a + " ");
				hm1.put(a,hm1.get(a)-1);
				if(hm1.get(a) == 0) {
					hm1.remove(a);
				}
			}
		}
	}

}
