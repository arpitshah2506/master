import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    /** Initialize your data structure here. */
    Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
    int curr_size;

    public StackUsingQueue()
    {
        curr_size = 0;
    }

    void remove()
    {
        if (q1.isEmpty())
            return;

        // Leave one element in q1 and
        // push others in q2.
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // Pop the only left element
        // from q1
        q1.remove();
        curr_size--;

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    void add(int x)
    {
        q1.add(x);
        curr_size++;
    }

    int top()
    {
        if (q1.isEmpty())
            return -1;

        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // last pushed element
        int temp = q1.peek();

        // to empty the auxiliary queue after
        // last operation
        q1.remove();

        // push last element to q2
        q2.add(temp);

        // swap the two queues names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }

    int size()
    {
        return curr_size;
    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.add(1);
        stackUsingQueue.add(2);

        System.out.println(stackUsingQueue.top());
        stackUsingQueue.remove();
        System.out.println(stackUsingQueue.size());
        /*System.out.println(stackUsingQueue.remove());
        System.out.println(stackUsingQueue.pop());*/

        //System.out.println(stackUsingQueue.empty());
        //System.out.println(stackUsingQueue.pop());
        //System.out.println(stackUsingQueue.pop());
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

