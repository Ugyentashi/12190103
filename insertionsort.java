import java.util.*;
public class insertionsort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int length = sc.nextInt();
		int array[] = new int[length];
			for(int i = 0; i < length; i++) {
				System.out.print("Enter elements of array : ");
				int element = sc.nextInt();
				array[i] = element;
			}
			System.out.println("Before sorting: ");
			for (int j=0;j<array.length;j++) {
				System.out.print(" "+array[j]);
			}

		insertionsort obj = new insertionsort();
		obj.sort(array);
		System.out.println();
		obj.printarray(array);
	}

	// void swap(){
	// 	int temp[];
	// 	temp = array[i];
	// 	array[i-1] = temp;
	// }

	void sort(int array[]){

		int n = array.length;
		for (int i=1; i<n ;i++) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > key){
				array[j + 1] = array[j]; 
                j = j - 1; 
			}
			array[j+1] = key;
		}
	}

	void printarray(int array[]){
		System.out.println("After sorting: ");
		int n = array.length;
		for (int i=0;i<n ;i++ ) {
			System.out.print(" "+array[i]);
			
		}
	}


}