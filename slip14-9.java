1. Write a Java program for a simple search engine. Accept a string to be searched. Search the string in 
all text files in the current folder. Use a separate thread for each file. The result should display the 
filename and line number where the string is found
-----------------------------------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class SimpleSearchEngine {
 private static final String SEARCH_STRING = "search";
 private static final String FILE_EXTENSION = ".txt";
 public static void main(String[] args) {
 File folder = new File(".");
 File[] files = folder.listFiles();
 List<SearchThread> searchThreads = new ArrayList<>();
 if (files != null) {
 for (File file : files) {
 if (file.isFile() && file.getName().toLowerCase().endsWith(FILE_EXTENSION)) {
 SearchThread searchThread = new SearchThread(file, SEARCH_STRING);
 searchThreads.add(searchThread);
 searchThread.start();
 }
 }
 }
 for (SearchThread thread : searchThreads) {
 try {
 thread.join();
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 }
 static class SearchThread extends Thread {
 private File file;
 private String searchString;
 public SearchThread(File file, String searchString) {
 this.file = file;
 this.searchString = searchString;
 }
 @Override
 public void run() {
 try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
 String line;
 int lineNumber = 1;
 while ((line = reader.readLine()) != null) {
 if (line.contains(searchString)) {
 System.out.println("Found in file: " + file.getName() + ", Line: " + lineNumber +
": " + line);
 }
lineNumber++;
}
} catch (IOException e) {
e.printStackTrace();
}
}
}
}




Q2. Write a JSP program to calculate sum of first and last digit of a given number. Display sum in Red 
Color with font size 18
---------------------------------------------------------------------------------------------
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
 <title>Sum of First and Last Digit</title>
</head>
<body>
 <h2>Calculate Sum of First and Last Digit</h2>
 
 <%
 String numberStr = request.getParameter("number");
 if (numberStr != null && !numberStr.isEmpty()) {
    try {
    int number = Integer.parseInt(numberStr);
    int lastDigit = number % 10;
    int firstDigit = 0;
    while (number != 0) {
    firstDigit = number % 10;
    number /= 10;
    }
    int sum = firstDigit + lastDigit;
    %>
    <p style="color: red; font-size: 18px;">
    Sum of First and Last Digit of <%= number %> is: <%= sum %>
    </p>
    <%
    } catch (NumberFormatException e) {
    %>
    <p style="color: red; font-size: 18px;">
    Invalid input. Please enter a valid number.
    </p>
    <%
    }
    }
    %>
    <form method="post">
    Enter a number: <input type="text" name="number">
    <input type="submit" value="Calculate">
    </form>
   </body>
   </html>