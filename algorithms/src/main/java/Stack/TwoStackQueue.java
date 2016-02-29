package Stack;

import java.util.Stack;

/**
 * Created by mandy on 2016/2/29.
 */
public class TwoStackQueue {
    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> popStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.peek());
                pushStack.pop();
            }
        }
            popStack.pop();


    }

    // Get the front element.
    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.peek());
                pushStack.pop();
            }
        }
        return popStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.peek());
                pushStack.pop();
            }
        }
        return popStack.isEmpty();
    }
}
