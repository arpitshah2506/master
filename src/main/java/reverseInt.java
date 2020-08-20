import java.util.Stack;

public class reverseInt {
    public static void main(String[] args) {
        MaintainanceStack maintainanceStack = new MaintainanceStack();
        MinStack minStack = new MinStack(maintainanceStack);
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.getMin());
    }
}

class MinStack extends Stack<Integer> {
    private final MaintainanceStack maintainanceStack;

    public MinStack(MaintainanceStack maintainanceStack) {
        this.maintainanceStack = maintainanceStack;
    }

    @Override
    public Integer push(Integer item) {
        if (maintainanceStack.empty()  || item <= maintainanceStack.peek()) {
            maintainanceStack.push(item);
        }
        return super.push(item);
    }

    public int getMin() {
        if (maintainanceStack.empty() == false) {
            return maintainanceStack.peek();
        }
        return 0;
    }

    @Override
    public synchronized Integer pop() {
        if (maintainanceStack.empty() == false && this.peek() == maintainanceStack.peek()) {
            maintainanceStack.pop();
        }
        return super.pop();
    }
}

class MaintainanceStack extends Stack<Integer> {

}