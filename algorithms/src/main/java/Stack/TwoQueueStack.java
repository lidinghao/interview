package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mandy on 2016/2/29.
 */
public class TwoQueueStack {
    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();
    private int top;
    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int k = queue1.size();
        for (int i = 0; i < k - 1; i++) {
            queue2.add(queue1.poll());
        }
        queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2= temp;
    }

    // Get the top element.
    public int top() {
        int k = queue1.size();
        for (int i = 0; i < k -1; i++) {
            queue2.add(queue1.poll());
        }
        int top = queue1.peek();
        queue2.add(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2= temp;
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.size() == 0;
    }
}
