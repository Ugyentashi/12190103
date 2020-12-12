public class arr{

	public static void main(String[] args){

		int[] array = {10,20,30};

		int value = 40; 
 
        int[] copyarray = resize( array, value);

        for(int i = 0; i<copyarray.length;i++){
        	System.out.println(copyarray[i]);
        } 			
	}

	public static int[] resize( int array[], int value){


		int newArray[] = new int[array.length + 1]; 

		for (int i = 0; i < array.length; i++){
			newArray[i] = array[i]; 
		}

		newArray[array.length] = value;

		return newArray;
	


	}
}