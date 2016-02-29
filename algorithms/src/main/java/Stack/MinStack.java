package Stack;

import java.util.Stack;

/**
 * Created by mandy on 2016/2/29.
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int num) {
        if (minStack.isEmpty()) {
            minStack.push(num);
        } else {
            Integer min = minStack.peek();
            if (num <= min)
                minStack.push(num);
        }

        this.dataStack.push(num);
    }
    public void push2(int num) {
        if (minStack.isEmpty()) {
            minStack.push(num);
        } else {
            Integer min = minStack.peek();
            if (num <= min)
                minStack.push(num);
            else
                minStack.push(min);
        }

        this.dataStack.push(num);
    }


    public int pop( ) {
        Integer num = dataStack.pop();
        Integer min = minStack.peek();
        if (num == min) {
            minStack.pop();
        }
        return num;
    }
    public int pop2( ) {
        Integer num = dataStack.pop();
        minStack.pop();
        return num;
    }

    public int getMin() {
        return minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }
}
