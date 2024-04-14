1. Write a java program to define a thread for printing text on output screen for ‘n’ number of times. 
Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor. Example:
i. First thread prints “COVID19” 10 times.
ii. Second thread prints “LOCKDOWN2020” 20 times
iii. Third thread prints “VACCINATED2021” 30 times [15 M]
-------------------------------------------------------------------------------------------------
public class A1 extends Thread {
    String str;
    int n;
    A1(String str, int n) {
    this.str = str;
    this.n = n;
    }
    
    public void run() {
    try {
    for (int i = 0; i < n; i++) {
    System.out.println(getName() + " : " + str);
    }
    } catch (Exception e) {
    e.printStackTrace();
    }
    }
    public static void main(String[] args) {
    A1 t1 = new A1("COVID19", 10);
    A1 t2 = new A1("LOCKDOWN2020", 20);
    A1 t3 = new A1("VACCINATED", 30);
    t1.start();
    t2.start();
    t3.start();
    }
   }

   

   Q2) 2.Write a JSP program to check whether a given number is prime or not. Display the result in red color.
-----------------------------------------------------------------------------
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>Prime Number Checker</title>
</head>
<body>
 <h1>Prime Number Checker</h1>
 <% String numberStr = request.getParameter("number"); %>
 <% if (numberStr != null && !numberStr.isEmpty()) { %>
    <%-- Convert the string number to an integer --%>
    <% int number = Integer.parseInt(numberStr); %>
    <% boolean isPrime = true; %>
    <% if (number <= 1) { %>
    <% isPrime = false; %>
    <% } else { %>
    <% for (int i = 2; i <= Math.sqrt(number); i++) { %>
    <% if (number % i == 0) { %>
    <% isPrime = false; %>
   <% break; %>
    <% } %>
    <% } %>
    <% } %>
    <p><font color="red"><%= number %> is <%= isPrime ? "prime" : "not prime" %></font></p>
    <% } else { %>
    <p>Please provide a number to check if it is prime.</p>
    <% } %>
    <form method="post" action="PrimeChecker.jsp">
    <label>Enter a number:</label>
    <input type="text" name="number">
    <input type="submit" value="Check">
    </form>
   </body>
   </html>
   
