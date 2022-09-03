package Stacks;

import java.util.function.Consumer;

public interface Stack<T> {
    boolean isFull();
    boolean isEmpty();
    T top();
    int size();
    void clearStack();
    void traverseStack(Consumer<T> consumer);
    void push(T element);
    T pop();
}
