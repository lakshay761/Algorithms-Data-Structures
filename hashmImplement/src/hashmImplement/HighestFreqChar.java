package hashmImplement;
import java.util.ArrayList;
import java.util.HashMap;
public class HighestFreqChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abbccddaccbdacdcba";
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i = 0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch)+1);
			}
			else {
				hm.put(ch, 1);
			}
		}
		ArrayList<Character> keys = new ArrayList<>(hm.keySet());
		int max= Integer.MIN_VALUE;
		char k = 0;
		for(char key : keys) {
			if(max<hm.get(key)) {
				max = hm.get(key);
				k = key;
			}
		}
		System.out.println(k + " " + max);
	}

}
