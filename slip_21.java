1. Write a java program to accept ‘N’ Subject Names from a user store them into LinkedList Collection 
and Display them by using Iterator interface.
-------------------------------------------------------------------------------------
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
public class SubjectNames {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 LinkedList<String> subjects = new LinkedList<>();
 System.out.print("Enter the number of subjects (N): ");
 int n = scanner.nextInt();
 scanner.nextLine();
 System.out.println("Enter " + n + " subject names:");
 for (int i = 0; i < n; i++) {
 String subject = scanner.nextLine();
 subjects.add(subject);
 }
 System.out.println("Subject Names:");
 Iterator<String> iterator = subjects.iterator();
 while (iterator.hasNext()) {
 System.out.println(iterator.next());
 }
 scanner.close();
 }
}


2.Write a java program to solve producer consumer problem in which a producer produces a value and
 consumer consume the value before producer generate the next value. (Hint: use thread synchronization)


 import java.util.LinkedList;

class ProducerConsumer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced: " + value);
                buffer.add(value++);
                notify();
                Thread.sleep(1000); // Simulating producer producing a value
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }
                int consumedValue = buffer.removeFirst();
                System.out.println("Consumer consumed: " + consumedValue);
                notify();
                Thread.sleep(2000); // Simulating consumer consuming a value
            }
        }
    }
}

public class ProducerConsumerApp {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer(5);

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}



 
