package CoreJavaDS;

import java.util.Stack;

public class StackFindMin {

	public static void main(String[] args) {
		StackMin stackMin = new StackMin();
		stackMin.push(10);
		stackMin.push(20);
		stackMin.push(8);
		stackMin.push(15);
		stackMin.pop();
		stackMin.pop();
		
		System.out.println(stackMin.minValue());
	}

}

class StackMin extends Stack<Integer> {
	private static final long serialVersionUID = 1L;
	
	Stack<Integer> stackMinValues;
	StackMin() {
		stackMinValues = new Stack<Integer>();
	}
	public Integer push(Integer item) {
		if (item < minValue()) {
			stackMinValues.push(item);
		}
		return super.push(item);
	}
	
	public Integer pop() {
		int pickedValue = super.pop();
		if (pickedValue == minValue()) {
			stackMinValues.pop();
		}
		return pickedValue;
	}
	
	public Integer minValue() {
		if (stackMinValues.empty()) {
			return Integer.MAX_VALUE;
		}
		return stackMinValues.peek();
	}
}