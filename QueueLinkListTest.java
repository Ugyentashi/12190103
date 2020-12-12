public class QueueLinkListTest{

	public static void main(String[] args) {
		QueueLinkListDemo obj = new QueueLinkListDemo();
		obj.enQueue(8);
		obj.enQueue(4);
		obj.enQueue(5);
		obj.enQueue(6);
		obj.deQueue();
		assert(obj.isEmpty() == false);
		assert(obj.printFrontElement() == 4);
		assert(obj.len() == 3);
		System.out.println("The first Element of stack is : " +obj.printFrontElement());
		System.out.println("All are tested correctly");
	}
}