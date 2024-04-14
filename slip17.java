1. Write a java program to accept ‘N’ integers from a user. Store and display integers in sorted order 
having proper collection class. The collection should not accept duplicate elements.
---------------------------------------------------------------------------------------------
import java.util.Scanner;
import java.util.TreeSet;
public class SortedIntegers {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 TreeSet<Integer> numbers = new TreeSet<>();
 System.out.print("Enter the number of integers (N): ");
 int n = scanner.nextInt();
 System.out.println("Enter " + n + " integers:");
 for (int i = 0; i < n; i++) {
 int num = scanner.nextInt();
 numbers.add(num);
 }
 System.out.println("Integers in sorted order without duplicates:");
 for (int number : numbers) {
 System.out.println(number);
 }
 scanner.close();
 }
}

2.Write a Multithreading program in java to display the number’s between 1 to 100 continuously in a TextField by clicking on button. (Use Runnable Interface).




 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberDisplayApp extends JFrame {
    private JTextField textField;
    private JButton startButton, stopButton;
    private Thread numberThread;
    private volatile boolean running;

    public NumberDisplayApp() {
        super("Number Display App");

        textField = new JTextField(10);
        textField.setEditable(false);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        startButton.addActionListener(e -> startDisplay());
        stopButton.addActionListener(e -> stopDisplay());

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void startDisplay() {
        if (numberThread == null) {
            numberThread = new Thread(new NumberRunnable());
            running = true;
            numberThread.start();
        }
    }

    private void stopDisplay() {
        running = false;
        numberThread = null;
    }

    private class NumberRunnable implements Runnable {
        @Override
        public void run() {
            int count = 1;
            while (running && count <= 100) {
                SwingUtilities.invokeLater(() -> textField.setText(String.valueOf(count)));
                try {
                    Thread.sleep(500); // Adjust the delay as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberDisplayApp::new);
    }
}
