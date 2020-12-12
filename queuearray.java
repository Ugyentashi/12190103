public class queuearray{
	int front = -1;
	int rear = -1;
	int len = 0;
	int first = -1;
	int [] array = new int[10];
public void enqueue(int e){
	if (len==0){
		array[0] = e;
		front = 0;
		rear = 0;
		first = array[0];
	}
	else{
		array[rear + 1] = e;
		rear = rear + 1;
	}
	len = len + 1;
	System.out.println(e);
}
public int dequeue(){
	if (len==0) {
		System.out.println("queue is already empty!!");
	}
	else{
		front = front + 1;
	}
	len = len - 1;
	return array[front-1];
}

public int first(){
	if (len==0) {
		return 0;
	}
	else{
		return array[front];	
	}
	
}
public boolean is_Empty(){
	if (len==0){
		return true;
	}
	return false;
}
public int len(){
	return len;
}

public static void main(String[] args) {
		queuearray obj = new queuearray();
		obj.enqueue(3);
		obj.enqueue(5);
		obj.enqueue(8);

		System.out.println("Removed element:"+obj.dequeue());
		System.out.println("First Element is:"+obj.first());
		System.out.println(obj.is_Empty());
		System.out.println("Number of element:"+obj.len());
	}
}