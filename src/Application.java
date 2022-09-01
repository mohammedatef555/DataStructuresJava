import stackArrayBasedImp.Stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        int counter = 1;
        while(counter <= 100)
            stack.push(counter++);

//         System.out.println(stack.top());
//        System.out.println(stack.size());
//        stack.clearStack();
//        System.out.println(stack.size());
//        stack.traverseStack( integer -> System.out.println(integer));
//        stack.traverseStack( integer -> System.out.println(integer * 2));


        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Stack<String> stringStack = new Stack<>(10);
        List<String> list = Arrays.asList("Hello", "From", "The", "up", "side", "down");
        Iterator<String> it = list.iterator();
        while (!stringStack.isFull() && it.hasNext())
            stringStack.push(it.next());

        while(!stringStack.isEmpty())
            System.out.println(stringStack.pop());

    }
}
