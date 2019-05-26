package graph1;

public class fire {
	public void spread(int[][] arr, int time) {
		if(time == 3) {
			return;
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j] == 2) {
					
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{0,1,1,1,1,0},
				{0,1,0,0,1,0},
				{0,0,0,1,0,2},
				{0,1,0,1,0,0},
				{2,0,1,1,0,0},
		};
		
	}

}
