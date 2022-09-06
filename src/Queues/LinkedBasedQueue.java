package Queues;

import java.util.function.Consumer;

public class LinkedBasedQueue<T> implements Queue<T> {

    private class ListNode {
        T element;
        ListNode next;

        public ListNode(T element) {
            this.element = element;
        }
    }

    private ListNode front;
    private ListNode rear;
    private int size;

    public LinkedBasedQueue(int capacity) {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void append(T element) {
        ListNode node = new ListNode(element);
        if (isEmpty()) {
            front = node;
            rear = front;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    @Override
    public T serve() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Queue");
        }
        size--;
        T element = front.element;
        front = front.next;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void clearQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public int queueSize() {
        return size;
    }

    @Override
    public void traverseQueue(Consumer<T> consumer) {
//        ListNode temp = front;
//        while (temp != null){
//            consumer.accept(temp.element);
//            temp = temp.next;
//        }
        for (ListNode node = front; node != null; node = node.next){
            consumer.accept(node.element);
        }

    }
}
