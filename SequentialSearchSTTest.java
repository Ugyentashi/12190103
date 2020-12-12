public class SequentialSearchSTTest{
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> obj = new SequentialSearchST<String, Integer>();

		obj.put("A",5);
		obj.put("B",7);
		obj.put("C",8);
		// System.out.println(obj.size());
		// System.out.println(obj.isEmpty());
		// System.out.println(obj.contains("A"));
		// System.out.println(obj.get("A"));
		// obj.delete("B");
		// obj.delete("A");
		// System.out.println(obj.size());
		// System.out.println(obj.get("A"));



		assert(obj.isEmpty() == false);
		assert(obj.size() == 3);
		obj.delete("B");
		obj.delete("A");
		assert(obj.size() == 1);
		System.out.println("All Test Cases Passed");
	}
}