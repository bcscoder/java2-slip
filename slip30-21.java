1. Write a java program for the implementation of synchronization.
-----------------------------------------------------------------------------------
public class SynchronizationExample {
    public static void main(String[] args) {
    Counter counter = new Counter();
    Thread thread1 = new Thread(new IncrementTask(counter));
    Thread thread2 = new Thread(new IncrementTask(counter));
    thread1.start();
    thread2.start();
    try {
    thread1.join();
    thread2.join();
    } catch (InterruptedException e) {
    e.printStackTrace();
    }
    System.out.println("Final Count: " + counter.getCount());
    }
    static class Counter {
    private int count;
    public Counter() {
    this.count = 0;
    }
    public void increment() {
    synchronized (this) {
    count++;
    }
    }
    public int getCount() {
    return count;
    }
    }
    static class IncrementTask implements Runnable {
    private final Counter counter;
    public IncrementTask(Counter counter) {
    this.counter = counter;
    }
    @Override
    public void run() {
    for (int i = 0; i < 10000; i++) {
    counter.increment();
    }
    }
    }
   }

   



   Q2. Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher table with 
   attributes (TID, TName, Salary) is already created.
   ------------------------------------------------------------------------------------------------
   import java.sql.*;
public class ScrollableResultSetExample {
 public static void main(String[] args) {
 try {
 String url = "jdbc:postgresql://localhost:5432/your_database";
 String username = "your_username";
 String password = "your_password";
 Connection conn = DriverManager.getConnection(url, username, password);
 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);
 String query = "SELECT * FROM Teacher";
 ResultSet rs = stmt.executeQuery(query);
 if (!rs.isBeforeFirst()) {
 System.out.println("ResultSet is not scrollable.");
 } else {
 rs.last();
 System.out.println("Teacher Details (in reverse order):");
 System.out.println("==================================");
 do {
 int tid = rs.getInt("TID");
 String tname = rs.getString("TName");
 double salary = rs.getDouble("Salary");
 System.out.println("TID: " + tid + ", TName: " + tname + ", Salary: " + salary);
 } while (rs.previous());
 }
 rs.close();
 stmt.close();
 conn.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
}