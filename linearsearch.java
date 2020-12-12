import java.util.Scanner;
public class linearsearch{

	static int search(int array[], int n, int x){
		for (int i=0;i<n;i++){
			if(array[i]==x){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int array[] = {5,6,8,7,9,4,3,2};
		int n = array.length;
		System.out.println("Given Array: ");
		for (int y=0;y<n;y++){
			System.out.print(" "+array[y]);
		}
		System.out.println(" ");
		Scanner cin = new Scanner(System.in);
		System.out.println("Enter Element to search: ");
		int x = cin.nextInt();

		int index = search(array, n, x);
		if (index== -1){
			System.out.println("Element is not present in an given array");
		}
		else{
			System.out.println("Element found at index: "+ index);
		}

	}
}