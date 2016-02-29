package Stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/2/29.
 */
public class TwoStackQueueTest {

    @Test
    public void testPush() throws Exception {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.push(1);
        twoStackQueue.push(4);
        twoStackQueue.push(2);
        assertEquals(1,twoStackQueue.peek());
        twoStackQueue.pop();
        assertEquals(4,twoStackQueue.peek());
        twoStackQueue.push(5);
        twoStackQueue.push(6);

        twoStackQueue.pop();
        assertEquals(2,twoStackQueue.peek());
        twoStackQueue.pop();
        assertEquals(5,twoStackQueue.peek());
        assertFalse(twoStackQueue.empty());
        twoStackQueue.pop();
        twoStackQueue.pop();
        assertTrue(twoStackQueue.empty());
    }

    @Test
    public void testPop() throws Exception {

    }

    @Test
    public void testPeek() throws Exception {

    }

    @Test
    public void testEmpty() throws Exception {

    }
}