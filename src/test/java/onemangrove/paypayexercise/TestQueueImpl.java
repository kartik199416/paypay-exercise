package onemangrove.paypayexercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestQueueImpl {

    @Test
    public void testIsEmptyToStart() {
        Queue<Integer> queue = new QueueImpl<Integer>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testHeadIsNullToStart() {
        Queue<Integer> queue = new QueueImpl<Integer>();
        assertEquals(queue.head(), null);
    }

    @Test
    public void testEnqueue() {
        Queue<Integer> queue = new QueueImpl<Integer>();
        final Integer value = 5;
        queue = queue.enQueue(value);
        assertEquals(queue.head(), value);
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new QueueImpl<Integer>();
        final Integer value = 5;
        queue = queue.enQueue(value);
        queue = queue.deQueue();
        assertEquals(queue.head(), null);
    }

    @Test
    public void testEnqueueMultiple() {
        Queue<Integer> queue = new QueueImpl<Integer>();
        final Integer valueOne = 5, valueTwo = 6;
        queue = queue.enQueue(valueOne);
        queue = queue.enQueue(valueTwo);
        queue = queue.deQueue();
        assertEquals(queue.head(), valueTwo);
    }

}