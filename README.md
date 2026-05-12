package ucr.algoritmos.pg04algoritmos.model.Queue;

import org.junit.jupiter.api.Test;

import java.util.Random;

class HeaderLinkedQueueTest {
    @Test
    void HeaderlinkedQueuetest() {
        HeaderLinkedQueue<Integer> queue = new HeaderLinkedQueue<>();
        try {
            for (int i = 0; i < 10; i++) {
                int value = new Random().nextInt(50);
                System.out.println("enQueue( " + value + ")");
                queue.enQueue(value);
            }

            System.out.println("-------------------------");
            System.out.println("Queue size: " + queue.size());
            System.out.println("-------------------------");
            System.out.println("Peek / Top: " + queue.peek());
            System.out.println(queue);
            System.out.println("-------------------------");

            //Hacemos una busqueda aleatoria
            for (int i = 0; i < 10; i++) {
                int value = new Random().nextInt(50);
                System.out.println(queue.contains(value)
                ?"Value ["+ value + "] exists. Pos="+queue.indexOf(value)
                :"Value [" + value + "] don´t exists.");
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("deQueue: " + queue.deQueue());
                System.out.println(queue);
            }

        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
    }

}


















---------------------------------------------------------------------------------------------------
class priorityLinkedQueueTest {
    @Test
    void prioritylinkedQueuetest() {
        priorityLinkedQueue<Integer> queue = new priorityLinkedQueue<>();
        try {
            for (int i = 0; i < 10; i++) {
                int value = new Random().nextInt(50);
                int priority = new Random().nextInt(1,3);
                System.out.println("enQueue( " + value + ", "  + priority + ")");
                queue.enQueue(value, priority);
            }

            System.out.println("-------------------------");
            System.out.println("Queue size: " + queue.size());
            System.out.println("-------------------------");
            System.out.println("Peek / Top: " + queue.peek());
            System.out.println(queue);
            System.out.println("-------------------------");

            for (int i = 0; i < 5; i++) {
                System.out.println("deQueue: " + queue.deQueue());
                System.out.println(queue);
            }

        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
    }

}
