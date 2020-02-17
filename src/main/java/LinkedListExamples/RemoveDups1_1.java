package LinkedListExamples;

public class RemoveDups1_1 {

	public static void main(String[] args) {
		LinkedListData data = new LinkedListData();
		data.add(10);
		data.add(20);
		data.add(30);
		data.add(15);
		data.add(25);
		data.add(35);
		data.add(40);
		
		data.displayNodes();
		
		//data.removeDups();
		
		data.kthElement(2);
	}

}
