package Queues;

public class UseArrayBasedQueue {
    public static void main(String[] args) {
        ArrayBasedQueue<Integer> queue = new ArrayBasedQueue<>(10);

        int counter = 1;
        while(counter < 11){
            queue.append(counter++);
        }

        // queue.traverseQueue(System.out::println);
        // queue.traverseQueue(integer -> System.out.println(integer*100));

        while (!queue.isEmpty())
            System.out.println(queue.serve());


    }
}
