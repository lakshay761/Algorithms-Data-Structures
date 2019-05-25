package recursion10march;

import java.util.ArrayList;

public class targetsumArlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> mystr = new ArrayList<>();
		int[] mylist = { 10, 20, 30, 40, 50, 60, 70 };
		tarsum(mylist,0,70,mystr);
	}
	public static void tarsum(int[] arr,int idx,int tar,ArrayList<Integer> str) {
		if (idx >= arr.length) {
			if (tar == 0) {
				System.out.println(str);
			}
			return;
		}
		tarsum(arr, idx + 1, tar, str);
		str.add(arr[idx]);
		tarsum(arr, idx + 1, tar - arr[idx], str);
		str.remove(str.lastIndexOf(arr[idx]));
		
	}
	
}
