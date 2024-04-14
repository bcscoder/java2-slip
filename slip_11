1. Design an HTML page which passes customer number to a search servlet. The servlet searches for the 
customer number in a database (customer table) and returns customer details if found the number 
otherwise display error message.
----------------------------------------------------------------------------
[ main.HTML ] file
<!DOCTYPE html>
<html>
<head>
 <title>Search Customer</title>
</head>
<body>
 <h2>Search Customer</h2>
 <form action="SearchCustomerServlet" method="get">
 <label for="custNumber">Customer Number:</label>
 <input type="text" id="custNumber" name="custNumber" required>
 <br><br>
 <input type="submit" value="Search">
 </form>
</body>
</html

[serchsudtomer.java] file

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SearchCustomerServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 String custNumber = request.getParameter("custNumber");
 String url = "jdbc:postgresql://localhost:5432/your_database";
 String username = "username";
 String password = "password";
 try {
 Connection conn = DriverManager.getConnection(url, username, password);
 Statement stmt = conn.createStatement();
 String query = "SELECT * FROM customer WHERE custNumber = '" + custNumber + "'";
 ResultSet rs = stmt.executeQuery(query);
 if (rs.next()) {
 out.println("<h2>Customer Details</h2>");
 out.println("<p>Customer Number: " + rs.getString("custNumber") + "</p>");
 out.println("<p>Name: " + rs.getString("name") + "</p>");
 out.println("<p>Email: " + rs.getString("email") + "</p>");
 out.println("<p>Phone: " + rs.getString("phone") + "</p>");
 } else {
 out.println("<h2>Error</h2>");
 out.println("<p>Customer with number " + custNumber + " not found.</p>");
 }
 rs.close();
 stmt.close();
 conn.close();
 } catch (SQLException e) {
 out.println("<h2>Error</h2>");
 out.println("<p>Database Error: " + e.getMessage() + "</p>");
 }
 out.close();
 }
}





Q2) 2. Write a Java program to display information about all columns in the DONAR table using 
ResultSetMetaData.
----------------------------------------------------------------------------
import java.sql.*;
public class DONOR {
 public static void main(String[] args) 
 {
    try {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
       "postgres", "dsk");
        Statement stmt = null;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from donor");
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("\t-------------------------------------------------");
        int count = rsmd.getColumnCount();
        System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
        System.out.println("\t-------------------------------------------------");
        for (int i = 1; i <= count; i++)
        {
        System.out.println("\t\tColumn No : " + i);
        System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
        System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
        System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
        System.out.println();
        }
        System.out.println("\t--------------------------------------------------");
        rs.close();
        stmt.close();
        conn.close();
        }
        catch (Exception e) {
        System.out.println(e);
        }
        }
       }


t------------------------------------------------
  Sql file
    --> create table donor(did int, dname char(22),daddr varchar(22));
insert into donor VALUES(1,'AAA','zzz');
insert into donor VALUES(2,'BBB','yyy');
insert into donor VALUES(3,'CCC','xxx');
insert into donor VALUES(4,'DDD','www');

