1. Write a Java program to display information about the database and list all the tables in the database. (Use DatabaseMetaData).
---------------------------------------------------------------------------------------
import java.sql.*;
public class Metadata {
public static void main(String[] args) {
try {
Class.forName("org.postgresql.Driver");
Connection conn =
DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
DatabaseMetaData dbmd = conn.getMetaData();
System.out.println("\t-----------------------------------------------");
System.out.println("\t\tDriver Name : " + dbmd.getDriverName());
System.out.println("\t\tDriver Version : " + dbmd.getDriverVersion());
System.out.println("\t\tUserName : " + dbmd.getUserName());
System.out.println("\t\tDatabase Product Name : " +
dbmd.getDatabaseProductName());
System.out.println("\t\tDatabase Product Version : " +
dbmd.getDatabaseProductVersion());
System.out.println("\t------------------------------");
String table[] = { "TABLE" };
ResultSet rs = dbmd.getTables(null, null, null, table);
System.out.println("\t\tTable Names:");
while (rs.next()) {
System.out.println(rs.getString("TABLE_NAME"));
}
rs.close();
conn.close();
}
catch (Exception e) {
System.out.println(e);
}
}
}



Q2. Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program should print 
randomly the name of thread and value of sleep time. The name of the thread should be hard coded 
through constructor. The sleep time of a thread will be a random integer in the range 0 to 4999.
-------------------------------------------------------------------------------------------------------
import java.util.Random;
public class ThreadLifecycleDemo {
 public static void main(String[] args) {
 Thread thread1 = new MyThread("Thread 1");
 Thread thread2 = new MyThread("Thread 2");
 thread1.start();
 thread2.start();
 }
 static class MyThread extends Thread {
 private String threadName;
 private Random random = new Random();
 public MyThread(String name) {
 this.threadName = name;
 }
 @Override
 public void run() {
 System.out.println("Thread " + threadName + " created.");
 try {
 int sleepTime = random.nextInt(5000);
 System.out.println("Thread " + threadName + " will sleep for " + sleepTime + " 
milliseconds.");
 Thread.sleep(sleepTime);
 } catch (InterruptedException e) {
 System.out.println("Thread " + threadName + " interrupted.");
 }
 System.out.println("Thread " + threadName + " is dead.");
 }
 }
}
