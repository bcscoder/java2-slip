1. Write a JSP script to accept a String from a user and display it in reverse order
--------------------------------------------------------------------------------------
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
 <title>Reverse String</title>
</head>
<body>
 <h1>Reverse String</h1>
 
 <form method="post">
 Enter a string: <input type="text" name="inputString">
 <input type="submit" value="Reverse">
 </form>
 <%
 if (request.getMethod().equals("POST")) {
 // Retrieve the input string from the form
 String inputString = request.getParameter("inputString");
 // Check if the input string is not null
 if (inputString != null && !inputString.isEmpty()) {
 // Reverse the input string
 String reversedString = new StringBuilder(inputString).reverse().toString();
 // Display the reversed string
 %>
 <p>Original String: <%= inputString %></p>
 <p>Reversed String: <%= reversedString %></p>
 <%
 } else {
 %>
 <p>Please enter a valid string.</p>
 <%
 }
 }
 %>
</body>
</html>



Q2. Write a java program to display name of currently executing Thread in multithreading.
-------------------------------------------------------------------------
public class CurrentThreadName {
    public static void main(String[] args) {
    Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
    Thread thread2 = new Thread(new MyRunnable(), "Thread-2");
    thread1.start();
    thread2.start();
    String mainThreadName = Thread.currentThread().getName();
    System.out.println("Main thread name: " + mainThreadName);
    }
    static class MyRunnable implements Runnable {
    @Override
    public void run() {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println("Current thread name: " + currentThreadName);
    }
    }
   }