public class keyindexcount{
	public static void main(String[] args) {
		int array[] = {5,6,8,7,9,4,3,2};
		int N = array.length;
		int R = 256;
		int[] aux = new int[N];
		int[] count = new int [R+1];

		//Printing Array Before
		for (int x=0;x<N;x++){
			System.out.print(" "+array[x]);
		}
		System.out.println(" ");

		//Computing frequency counts.
		for (int i=0;i<N;i++){
			count[array[i] + 1]++;
		}
		//Transform counts to indices.
		for (int r=0;r<R;r++){
			count[r+1] += count[r];
		}
		//Distribute the records
		for (int i=0;i<N;i++){
			aux[count[array[i]]++] = array[i];
		}
		//Copy Back
		for (int i=0;i<N;i++){
			array[i]=aux[i];
		}
		//Printing Array After
		for (int x=0;x<N;x++){
			System.out.print(" "+array[x]);
		}
	}
}