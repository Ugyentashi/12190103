public class lsdsorting{
	public static void sort() {

		String array[] = {"sonam","dorji","lhamo","tashi"};
		int W = array[0].length();//gives index length of the name 
		int N = array.length;
		int R = 256;
		String[] aux = new String[N];

		//Printing Array Before
		for (int x=0;x<N;x++){
			System.out.print(" "+array[x]);
		}
		System.out.println(" ");

		
		for (int d = W-1; d>=0; d--){
	        int[] count = new int [R+1];

			
			//Computing frequency counts.
			for (int i=0;i<N;i++){
				count[array[i].charAt(d) + 1]++;
			}
			//Transform counts to indices.
			for (int r=0;r<R;r++){
				count[r+1] += count[r];
			}
			//Distribute the records
			for (int i=0;i<N;i++){
				aux[count[array[i].charAt(d)]++] = array[i];
			}
			//Copy Back
			for (int i=0;i<N;i++){
				array[i]=aux[i];
			}

		}

		//Printing Array After
			for (int x=0;x<N;x++){
				System.out.print(" "+array[x]);
			}
	}

	public static void main(String[] args) {
			sort();
		}
}