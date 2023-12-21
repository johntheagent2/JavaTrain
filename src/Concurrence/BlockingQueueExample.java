package Concurrence;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueExample {
    BlockingQueueExample(){}

    public void run(){
        BlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>(5) {
        };

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    blockingQueue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int item = blockingQueue.take();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the producer and consumer threads
        producer.start();
        consumer.start();
    }
}
