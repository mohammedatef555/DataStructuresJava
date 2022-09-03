package Stacks;

import java.util.List;
import java.util.function.Consumer;

public class LinkedListStack<T> implements Stack<T> {

    class ListNode {
        public ListNode(T element){
            this.element = element;
        }
        T element;
        ListNode next;
    }


    private int size;
    private ListNode head;

    public LinkedListStack(int capacity) {
        head = null;
        size = 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T top() {
        if (!isEmpty())
            return head.element;
        throw new RuntimeException("Empty Stack");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clearStack() {
        head = null;
        size = 0;
    }

    @Override
    public void traverseStack(Consumer<T> consumer) {
        ListNode node = head;
        while (node != null) {
            consumer.accept(node.element);
            node = node.next;
        }
    }

    @Override
    public void push(T element) {
        ListNode node = new ListNode(element);
        if (!isEmpty()) {
            node.next = head;
            head = node;
        } else {
            head = node;
        }
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new RuntimeException("Empty Stack");
        T element = head.element;
        head = head.next;
        return element;
    }
}
