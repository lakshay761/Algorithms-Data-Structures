package recursion3march;

import java.util.ArrayList;

public class stairs2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stairs(7));
	}
public static ArrayList<String> stairs(int n){
	if(n==0) {
		ArrayList<String> pfnb = new ArrayList<>();
		pfnb.add("");
		return pfnb;
	}
	if(n<0) {
		ArrayList<String> pfnb = new ArrayList<>();
		return pfnb;
	}
	
	ArrayList<String> pfnm1 = stairs(n-1);
	ArrayList<String> pfnm2 = stairs(n-2);
	ArrayList<String> pfnm3 = stairs(n-3);
	ArrayList<String> pfn = new ArrayList<>();
	
	for(int i=0;i<pfnm1.size();i++) {
		pfn.add("1" + pfnm1.get(i));
	}
	for(int i=0;i<pfnm2.size();i++) {
		pfn.add("2" + pfnm2.get(i));
	}
	for(int i=0;i<pfnm3.size();i++) {
		pfn.add("3" + pfnm3.get(i));
	}
	return pfn;
	
}
}
