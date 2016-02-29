package Stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/2/29.
 */
public class MinStackTest {

    @Test
    public void testPush() throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(3);
        minStack.push(1);
        minStack.push(5);
        assertEquals(5,minStack.pop());
        assertEquals(1,minStack.pop());
        assertEquals(3,minStack.pop());
        assertEquals(1,minStack.pop());
    }

    @Test
    public void testPop() throws Exception {

    }

    @Test
    public void testGetMin() throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(3);
        assertEquals(3,minStack.getMin());

        minStack.push(2);
        assertEquals(2,minStack.getMin());

        minStack.push(5);
        assertEquals(2,minStack.getMin());

        minStack.push(1);
        assertEquals(1,minStack.getMin());

        minStack.pop();

        assertEquals(2,minStack.getMin());


    }

    @Test
    public void testPush2() throws Exception {
        MinStack minStack = new MinStack();
        minStack.push2(1);
        minStack.push2(3);
        minStack.push2(1);
        minStack.push2(5);
        assertEquals(5,minStack.pop2());
        assertEquals(1,minStack.pop2());
        assertEquals(3,minStack.pop2());
        assertEquals(1,minStack.pop2());
    }

    @Test
    public void testPop2() throws Exception {
        MinStack minStack = new MinStack();
        minStack.push2(3);
        assertEquals(3,minStack.getMin());

        minStack.push2(2);
        assertEquals(2,minStack.getMin());

        minStack.push2(5);
        assertEquals(2,minStack.getMin());

        minStack.push2(1);
        assertEquals(1,minStack.getMin());

        minStack.pop2();

        assertEquals(2,minStack.getMin());
    }
}