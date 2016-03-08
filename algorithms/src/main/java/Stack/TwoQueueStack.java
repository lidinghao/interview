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
        //数学模式与优化课上的蚂蚁相遇问题，由于蚂蚁是一样的，所以相遇可以想象成穿越，这里两个队列
        // 也相同，可以想象另外队列只是一个临时存储，其实操作一直在一个队列中进行
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
