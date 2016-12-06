package cue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class CueHarness {
    Cue<String> testQueue;

    public abstract Cue<String> getQueue();

    @Before
    public void setUp() {
        testQueue = getQueue();
    }

    @Test
    public void testReturnsElementsInFifoOrder() throws Exception {
        testQueue.enqueue("a");
        testQueue.enqueue("b");
        testQueue.enqueue("c");
        assertEquals(testQueue.dequeue(), "a");
        assertEquals(testQueue.dequeue(), "b");
        assertEquals(testQueue.dequeue(), "c");
    }

    @Test
    public void testIsEmptyReturnsTrueInitially() throws Exception {
        assertEquals(testQueue.isEmpty(), true);
    }

    @Test
    public void testIsEmptyReturnsTrueAfterEqualEnqueueAndDequeue() throws Exception {
        testQueue.enqueue("a");
        testQueue.enqueue("b");
        testQueue.dequeue();
        testQueue.dequeue();
        assertEquals(testQueue.isEmpty(), true);
    }

    @Test
    public void testIsEmptyReturnsFalseAfterEnqueue() throws Exception {
        testQueue.enqueue("a");
        assertEquals(testQueue.isEmpty(), false);
    }

    @Test(expected = EmptyQueueException.class)
    public void testThrowsEmptyQueueExceptionInitiallyOnDequeue() throws Exception {
        testQueue.dequeue();
    }

    @Test(expected = EmptyQueueException.class)
    public void testThrowsEmptyQueueExceptionAfterEnqueueAndDequeue() throws Exception {
        testQueue.enqueue("a");
        testQueue.dequeue();
        testQueue.dequeue();
    }
}
