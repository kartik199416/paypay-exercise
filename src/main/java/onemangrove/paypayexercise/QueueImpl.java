package onemangrove.paypayexercise;

public class QueueImpl<T> implements Queue<T> {

    static <T> QueueImpl<T> copy(final QueueImpl<T> other) {
        return new QueueImpl(other);
    }

    QueueImpl() {}

    QueueImpl(QueueImpl<T> other) {
        insertAll(other);
    }

    public Queue<T> enQueue(T t) {
        final QueueImpl<T> copy = copy(this);
        copy.insert(t);
        return copy;
    }

    public Queue<T> deQueue() {
        final QueueImpl<T> copy = copy(this);
        copy.removeHead();
        return copy;
    }

    public T head() {
        return head == null ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    class Element {

        private T data;

        private Element next = null;

        Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }

        Element(T data) {
            this(data, null);
        }

    }

    private Element head = null;

    private Element tail = null;

    private Queue<T> insertAll(QueueImpl<T> other) {
        Element next = other.head;
        while (next != null) {
            insert(next.data);
            next = next.next;
        }
        return this;
    }

    private void insert(T data) {
        if (this.head == null) {
            this.head = new Element(data);
            return;
        }
        Element next = head, prev = null;
        while (next != null) {
            prev = next;
            next = prev.next;
        }
        prev.next = new Element(data);
    }

    private void removeHead() {
        if (this.head == null)
            return;
        this.head = head.next;
    }

}
