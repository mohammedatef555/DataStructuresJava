package Stacks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UseArrayStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>(10);

        int counter = 1;
        while(counter <= 100)
            stack.push(counter++);

        stack.traverseStack(System.out::println);
        stack.traverseStack( integer -> System.out.println(integer * 2));

        System.out.printf("Stack Top = %s \n", stack.top());
        System.out.printf("Stack Size = %s \n", stack.size());
        System.out.println("Start Clearing Stack");
        stack.clearStack();
        System.out.println("Finished Clearing Stack");
        System.out.printf("Stack Size = %s \n", stack.size());




        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Stack<String> stringStack = new ArrayStack<>(10);
        List<String> list = Arrays.asList("Hello", "From", "The", "up", "side", "down");
        Iterator<String> it = list.iterator();
        while (!stringStack.isFull() && it.hasNext())
            stringStack.push(it.next());

        while(!stringStack.isEmpty())
            System.out.println(stringStack.pop());

    }
}
