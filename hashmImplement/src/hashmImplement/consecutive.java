package hashmImplement;
import java.util.HashMap;
public class consecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,10,11,12,5,15,9,25,20,16,2,6,8};
		con(arr);
	}
	public static void con(int[] arr) {
		HashMap<Integer,Boolean> hm = new HashMap<>();
		int ol = 0;
		int os = -1;
		for(int a : arr) {
			hm.put(a,true);
		}
//		for(
		for(int a : arr) {
			if(hm.get(a) == true) {
				int tl = 1;
				
				while(hm.containsKey(a + tl)) {
					tl++;
				}
				
				if(tl>ol) {
					ol = tl;
					os = a;
				}
			}
		}
		System.out.println(os + " to " + (os+ol-1));
	}

}
