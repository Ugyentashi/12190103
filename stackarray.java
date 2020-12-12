public class stackarray{
	//declearing variable; where max is the size of array
	int max = 10;
	// initial the size and top will be zero 
	int top = -1;
	int size = 0;
	// creating array named array with the size 10 i.e. max.
	int [] array = new int[max];

// here it allow us to push element inside array
public void push(int e){
	if (size==0){
		array[0] = e;
		top = 0;
	}
	else{
		array[top + 1] = e;
		top = top + 1;

	}
	size = size + 1;
	System.out.println(e);
	
}
// remove element from top of array
public int pop(){
	if (size==0){
		System.out.println("Stack is already Empty!!");
	}
	else{
		top = top - 1;
		size = size - 1;
	}
	return array[top + 1];
}
//returning top of the element in stack
public int top(){
	return array[top];
}
// returning the size of the array
public int size(){
		return size;
	}
// checking weather the stack is empty or not

public boolean isEmpty(){
	if (size()==0){
		return true;
	}
	return false;
}

public static void main(String[] args) {
		stackarray obj = new stackarray();
		obj.push(50);
		obj.push(20);
		obj.push(70);

		System.out.println("Poped or Removed array is: "+obj.pop());
		System.out.println("Array Top is:"+obj.top());
		System.out.println("Size of Array:"+obj.size());
		System.out.println(obj.isEmpty());
		
		
	}
}