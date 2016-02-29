package Stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/2/29.
 */
public class TwoQueueStackTest {

    @Test
    public void testPush() throws Exception {
        TwoQueueStack twoQueueStack = new TwoQueueStack();
        twoQueueStack.push(1);
        twoQueueStack.push(3);
        twoQueueStack.push(2);
        twoQueueStack.push(5);
        assertEquals(5, twoQueueStack.top());
        twoQueueStack.pop();
        assertEquals(2, twoQueueStack.top());
        twoQueueStack.push(6);
        assertEquals(6, twoQueueStack.top());



    }

    @Test
    public void testPop() throws Exception {

    }

    @Test
    public void testTop() throws Exception {

    }

    @Test
    public void testEmpty() throws Exception {

    }
}