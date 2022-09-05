package Queues;

import java.util.function.Consumer;

public class ArrayBasedQueue<T> implements Queue<T> {
    private int size;
    private int front;
    private int rear;
    private T[] array;

    public ArrayBasedQueue(int capacity) {
        array = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void append(T element) {
        if (!isFull()) {
            rear = (rear + 1) % array.length;
            array[rear] = element;
            size++;
        }
    }

    @Override
    public T serve() {
        if (isEmpty())
            throw new RuntimeException("Empty Queue");
        T element = array[front];
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public void clearQueue() {
        int capacity = array.length;
        array = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public int queueSize() {
        return size;
    }

    @Override
    public void traverseQueue(Consumer<T> consumer) {
        for (int pos = front, s =0; s<size; s++){
            consumer.accept(array[pos]);
            pos = (pos + 1) % array.length;
        }
    }
}
