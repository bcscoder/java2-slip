1. Write a JSP program to check whether given number is Perfect or not. (Use Include directive)
-----------------------------------------------------------------------------------------
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
 <title>Perfect Number Checker</title>
</head>
<body>
 <h2>Perfect Number Checker</h2>
 
 <%
 boolean isPerfect(int num) {
 int sum = 1;
 for (int i = 2; i * i <= num; i++) {
 if (num % i == 0) {
 sum += i;
 if (i * i != num) {
 sum += num / i;
 }
 }
 }
 return sum == num && num != 1;
 }
 
 String numberStr = request.getParameter("number");
 if (numberStr != null && !numberStr.isEmpty()) {
 int number = Integer.parseInt(numberStr);
 if (isPerfect(number)) {
 out.println("<p>" + number + " is a Perfect Number.</p>");
 } else {
 out.println("<p>" + number + " is not a Perfect Number.</p>");
 }
 }
 %>
 <form method="post">
 Enter a number: <input type="text" name="number">
 <input type="submit" value="Check">
 </form>
</body>
</html>
