class QueueLinkListDemo {
	Node front;
	Node tail;
	int size;
	//Constructor
	public QueueLinkListDemo() {
		front = null;
		tail = null;
		size = 0;
	}
	public void enQueue(int e) {
		Node newest = new Node(e, null);
		if(size == 0) {
			front = newest;
			tail = newest;
			System.out.println("Push " +e);
		}
		else {
			tail.setNext(newest);
			tail = newest;
			System.out.println("Push " +e);
		}
		size = size + 1;
	}
	public int deQueue() {
		int deletedElement = front.getElement();
		if(isEmpty()) {
			return 1;
		}
		else {
			front = front.getNext();
			size -= 1;
			System.out.println("Pop : " +deletedElement);
		}
		return deletedElement;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	public int printFrontElement() {
		int frontElement = front.getElement();
		if(size == 0) {
			System.out.println("QueueUnderFlowError");
		}
		else {
			return frontElement;
		}
		return printFrontElement();
	}
	public int len() {
		if(isEmpty()) {
			return 1;
		}
		return size;
	}
}
class Node{
	//Variable declaration
	private int element;
	private Node next;
	//constructor
	public Node(int element, Node next) {
		this.element = element;
		this.next = next;
	}
	//getElement
	public int getElement() {
		return element;
	}
	//getNext
	public Node getNext() {
		return next;
	}
	//setElement
	public void setElement(int e) {
		element = e;
	}
	//setNext
	public void setNext(Node e) {
		next = e;
	}
}