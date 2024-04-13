1. Write a java program that implements a multi-thread application that has three threads. First thread 
generates random integer number after every one second, if the number is even; second thread 
computes the square of that number and print it. If the number is odd, the third thread computes the of 
cube of that number and print it. [15 M]
---------------------------------------------------------------------------------------------------
import java.util.Random;
public class NumberProcessor {
 public static void main(String[] args) {
 NumberGenerator numberGenerator = new NumberGenerator();
 NumberSquareCalculator squareCalculator = new NumberSquareCalculator();
 NumberCubeCalculator cubeCalculator = new NumberCubeCalculator();
 Thread generatorThread = new Thread(numberGenerator);
 Thread squareThread = new Thread(squareCalculator);
 Thread cubeThread = new Thread(cubeCalculator);
 generatorThread.start();
 squareThread.start();
 cubeThread.start();
 }
 static class NumberGenerator implements Runnable {
 public void run() {
 Random random = new Random();
 while (true) {
 try {
 int randomNumber = random.nextInt(100); // Generate random number between 0 and 99
 System.out.println("Generated number: " + randomNumber);
 if (randomNumber % 2 == 0) {
 synchronized (NumberSquareCalculator.lock) {
 NumberSquareCalculator.number = randomNumber;
 NumberSquareCalculator.lock.notify();
 }
 } else {
 synchronized (NumberCubeCalculator.lock) {
 NumberCubeCalculator.number = randomNumber;
 NumberCubeCalculator.lock.notify();
 }
 }
 Thread.sleep(1000); // Sleep for 1 second
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 }
 }
 static class NumberSquareCalculator implements Runnable {
 static int number;
 static final Object lock = new Object();
 public void run() {
 while (true) {
 synchronized (lock) {
 try {
 lock.wait();
 int square = number * number;
 System.out.println("Square of " + number + ": " + square);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 }
 }
 }
 static class NumberCubeCalculator implements Runnable {
 static int number;
 static final Object lock = new Object();
 public void run() {
 while (true) {
 synchronized (lock) {
 try {
 lock.wait();
 int cube = number * number * number;
 System.out.println("Cube of " + number + ": " + cube);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 }
 }
 }
}



Q2) 2. Write a java program for the following
: i. To create a Product(Pid, Pname, Price) table
. ii. Insert at least five records into the table
. iii. Display all the records from a tabl
-------------------------------------------------------------------------------------
import java.sql.*;
public class ProductTableDemo {
 static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database";
 static final String USER = "username";
 static final String PASS = "password";
 public static void main(String[] args) {
 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
 if (conn != null) {
 System.out.println("Connected to the PostgreSQL database!");
 insertRecords(conn);
 displayRecords(conn);
 }
}
 catch (SQLException e) 
{
    e.printStackTrace();
 }
 }
 private static void insertRecords(Connection conn) throws SQLException {
 String[] products = {
 "('101', 'Product A', 50.00)",
 "('102', 'Product B', 75.50)",
 "('103', 'Product C', 100.25)",
 "('104', 'Product D', 120.75)",
 "('105', 'Product E', 90.99)"
 };
 String sql = "INSERT INTO Product (Pid, Pname, Price) VALUES ";
 try (Statement stmt = conn.createStatement()) {
 for (String product : products) {
 stmt.addBatch(sql + product);
 }
 stmt.executeBatch();
 System.out.println("Records inserted into Product table!");
 }
 }
 private static void displayRecords(Connection conn) throws SQLException {
 String sql = "SELECT * FROM Product";
 try (Statement stmt = conn.createStatement();
 ResultSet rs = stmt.executeQuery(sql)) {
 System.out.println("Product Table:");
 System.out.println("===============");
 System.out.println("Pid\tPname\tPrice");
 while (rs.next()) {
 int pid = rs.getInt("Pid");
 String pname = rs.getString("Pname");
 double price = rs.getDouble("Price");
 System.out.println(pid + "\t" + pname + "\t" + price);
 }
 }
 }
}
