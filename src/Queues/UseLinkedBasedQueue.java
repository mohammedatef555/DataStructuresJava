package Queues;

public class UseLinkedBasedQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedBasedQueue<>(10);

        int counter = 1;
        while (counter != 11) {
            queue.append(counter++);
        }

//        queue.traverseQueue(System.out::println);
//        queue.clearQueue();
//        queue.traverseQueue(integer -> System.out.println(integer * 100));

        while (!queue.isEmpty())
            System.out.println(queue.serve());


    }
}
