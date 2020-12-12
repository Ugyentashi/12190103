public class StackLinkListTest{
	public static void main(String[] args) {
		StackLinkListDemo obj = new StackLinkListDemo();
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.pop();
		assert(obj.isEmpty() == false);
		assert(obj.size() == 2);
		System.out.println("Checking Linklist is empty or not : " +obj.isEmpty());
		System.out.println("The size of stack is : " +obj.size());
		System.out.println("All are tested correctly");
	}
}