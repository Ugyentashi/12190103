import java.util.Scanner;
public class binarysearch{
	
	static int search(int array[],int first, int last, int x ){
		if (last>=first){
			int mid = first + (last - first) / 2;

			if (array[mid]==x){
				return mid;
			}
			else if(array[mid]>x){
				return search(array, first, mid - 1, x);
			}
			else{
				return search(array, mid + 1, last, x);
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int array[] = {2,3,4,5,6,7,8,9,10};
		int n = array.length;
		System.out.println("Given Array: ");
		for (int y=0;y<n;y++){
			System.out.print(" "+array[y]);
		}
		System.out.println(" ");
		Scanner cin = new Scanner(System.in);
		System.out.println("Enter Element to search: ");
		int x = cin.nextInt();

		int result = search(array,0,n-1,x);
		if (result== -1){
			System.out.println("Element is not present in an given array");
		}
		else{
			System.out.println("Element found at index: "+ result);
		}
	}
}