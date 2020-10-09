import java.util.*;
public class bubblesort{
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

		bubblesort obj = new bubblesort();
		obj.sort(array);
		System.out.println();
		obj.printarray(array);
	}

	void sort(int array[]){

		int n = array.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (array[j] > array[j+1]) 
                { 
                    // swap array[j+1] and array[j] 
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
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