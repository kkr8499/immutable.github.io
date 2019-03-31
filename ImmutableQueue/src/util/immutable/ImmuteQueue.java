package util.immutable;

public interface ImmuteQueue<T> {
    public ImmuteQueue<T> enQueue(T t);
    //Removes the element at the beginning of the immutable queue, and returns the new queue.
    public ImmuteQueue<T> deQueue();
    public T head();
    public boolean isEmpty();
}
