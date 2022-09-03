package Stacks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ArrayStack<T> implements Stack<T> {
    public T[] array;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = (T[])new Object[capacity];
        top = 0;
    }

    public boolean isFull() {
        return top == capacity;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public T top() {
        if (!isEmpty())
            return array[top - 1];
        throw new RuntimeException("Empty Stack");
    }

    public int size() {
        return top;
    }

    public void clearStack() {
        top = 0;
    }

    private void traverseStack(int index,Consumer<T> consumer) {
        if (index < top - 1)
            traverseStack(index + 1, consumer);
        if (top > 0)
            consumer.accept(array[index]);
    }

    public void traverseStack(Consumer<T> consumer) {
        traverseStack(0, consumer);
    }

    public void push(T element) {
        if (!isFull()) {
            array[top++] = element;
        } else {
            System.out.println("Start extending the stack");
            System.out.println("The capacity now is " + capacity);
            capacity = array.length * 2;
            array = Arrays.copyOf(array, array.length * 2);
            System.out.println("The capacity now is " + capacity);
            array[top++] = element;
        }
//        throw new RuntimeException("Full Stack");
    }

    public T pop() {
        if (!isEmpty()) {
            return array[--top];
        }
        throw new RuntimeException("Empty Stack");
    }

}
