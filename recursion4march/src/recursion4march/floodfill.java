package recursion4march;

public class floodfill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] myarr = {
				{0,1,0,0,0,0},
				{0,1,0,1,1,0},
				{0,0,0,0,0,0},
				{0,1,0,1,1,0},
				{0,1,0,0,0,0}
		};
		ff(myarr,0,0,"");
	}
	public static void ff(int[][] arr,int cr,int cc,String psf) {
		if(cr == arr.length-1 && cc== arr[0].length-1) {	//if element found
			System.out.println(psf);
			return;
		}
//		if(cr>= arr.length || cc >=arr[0].length || cr<0 || cc<0) {
//			return;
//		}
		if(arr[cr][cc] == 1) {			//obstacle or visited
			return;
		}
		
		if( cr>0) {					// not at top most row
			arr[cr][cc] = 1;		//visited
			ff(arr,cr-1,cc,psf + 'T');
			
		}
		if(cr<arr.length-1) {			//not at down most row
			arr[cr][cc]=1;
			ff(arr,cr+1,cc,psf + 'D');
		
		}
		if(cc>0) {						//not at left most row 
			arr[cr][cc] = 1;
			ff(arr,cr,cc-1,psf + 'L');
		}
		if(cc<arr[0].length-1) {			//not at right most row
			arr[cr][cc] = 1;
			ff(arr,cr,cc+1,psf + 'R');
		}
		
		arr[cr][cc] = 0;					//unvisited
	}
}
