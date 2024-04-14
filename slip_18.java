1. Write a java program to display name and priority of a Thread.
------------------------------------------------------------------------------
public class ThreadInfo {
    public static void main(String[] args) {
    Thread thread = Thread.currentThread();
    System.out.println("Current Thread Name: " + thread.getName());
    System.out.println("Current Thread Priority: " + thread.getPriority());
    }
   }
