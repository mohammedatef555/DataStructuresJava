package Queues;

import java.util.function.Consumer;

public interface Queue<T> {
    void append(T element);
    T serve();
    boolean isEmpty();
    boolean isFull();
    void clearQueue();
    int queueSize();
    void traverseQueue(Consumer<T> consumer);
}
