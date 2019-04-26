package onemangrove.paypayexercise;

/**
 * A simple FIFO queue.
 *
 * @param <T>
 */
public interface Queue<T> {

    /**
     *
     * @param t
     * @return
     */
    Queue<T> enQueue(T t);

    /**
     * Removes the element at the beginning of the immutable queue, and returns the new queue.
     *
     * @return
     */
    Queue<T> deQueue();

    /**
     *
     * @return
     */
    T head();

    /**
     *
     * @return
     */
    boolean isEmpty();

}

