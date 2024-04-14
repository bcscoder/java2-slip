1. Write a Java program to delete the details of given employee (ENo EName Salary). Accept employee 
ID through command line. (Use PreparedStatement Interface
-----------------------------------------------------------------------------------------
[jsp file]
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
 <title>Voter Eligibility Result</title>
</head>
<body>
 <h1>Voter Eligibility Result</h1>
 <%
 String name = request.getParameter("name");
 int age = Integer.parseInt(request.getParameter("age"));
 boolean isEligible = (age >= 18);
 out.println("<p>Name: " + name + "</p>");
 out.println("<p>Age: " + age + "</p>");
 if (isEligible) {
 out.println("<p>Congratulations! You are eligible to vote.</p>");
 } else {
 out.println("<p>Sorry! You are not eligible to vote.</p>");
 }
 %>
</body>
</html>




[java file]
-->
import java.sql.*;
public class DeleteEmployee {
 public static void main(String[] args) {
 if (args.length < 1) {
 System.out.println("Usage: java DeleteEmployee <EmployeeID>");
 return;
 }
 int employeeId = Integer.parseInt(args[0]);
 String url = "jdbc:postgresql://localhost:5432/your_database_name";
 String username = "your_username";
 String password = "your_password";
 Connection conn = null;
 PreparedStatement pstmt = null;
 try {
 conn = DriverManager.getConnection(url, username, password);
 String sql = "DELETE FROM Employee WHERE ENo = ?";
 pstmt = conn.prepareStatement(sql);
 pstmt.setInt(1, employeeId);
 int rowsAffected = pstmt.executeUpdate();
 if (rowsAffected > 0) {
 System.out.println("Employee with ID " + employeeId + " deleted successfully.");
 } else {
 System.out.println("Employee with ID " + employeeId + " not found.");
 }
 } catch (SQLException e) {
 System.out.println("Error: " + e.getMessage());
 } finally {
 try {
 if (pstmt != null) {
 pstmt.close();
 }
 if (conn != null) {
 conn.close();
 }
 } catch (SQLException e) {
 System.out.println("Error closing resources: " + e.getMessage());
 }
 }
 }
}



Q2. Write a JSP program to calculate sum of first and last digit of a given number. Display sum in Red 
Color with font size 18.
---------------------------------------------------------------------------------------
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
 <title>Sum of First and Last Digit</title>
 <style>
 .red {
 color: red;
 font-size: 18px;
 }
 </style>
</head>
<body>
 <h1>Sum of First and Last Digit</h1>
 
 <form method="post">
 Enter a number: <input type="text" name="number">
 <input type="submit" value="Calculate">
 </form>
 <%
 if (request.getMethod().equals("POST")) {
 // Retrieve the number from the form
 String numberStr = request.getParameter("number");
 if (numberStr != null && !numberStr.isEmpty()) {
 // Parse the input number as an integer
 int number = Integer.parseInt(numberStr);
 // Calculate the first and last digits
 int firstDigit = 0;
 int lastDigit = number % 10;
 while (number != 0) {
 firstDigit = number % 10;
number /= 10;
 }
 // Calculate the sum of the first and last digits
 int sum = firstDigit + lastDigit;
 // Display the result in red color with font size 18
 %>
 <p>Number: <%= numberStr %></p>
 <p class="red">Sum of First and Last Digit: <%= sum %></p>
 <%
 } else {
 %>
 <p class="red">Please enter a valid number.</p>
 <%
 }
 }
 %>
</body>
</html>
