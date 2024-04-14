1. Write a java program to accept ‘N’ Integers from a user store them into LinkedList Collection and 
display only negative integers.
----------------------------------------------------------------------------------------
import java.util.LinkedList;
import java.util.Scanner;
public class NegativeIntegers {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 LinkedList<Integer> numbers = new LinkedList<>();
 System.out.print("Enter the number of integers (N): ");
 int n = scanner.nextInt();
 System.out.println("Enter " + n + " integers:");
 for (int i = 0; i < n; i++) {
 int num = scanner.nextInt();
 numbers.add(num);
 }
 System.out.println("Negative Integers:");
 for (int number : numbers) {
 if (number < 0) {
 System.out.println(number);
 }
 }
 scanner.close();
 }
}

2.Write a SERVLET application to accept username and password, search them into database,
 if found then display appropriate message on the browser otherwise display error message.


 import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (validateLogin(username, password)) {
            out.println("<html><head><title>Login Successful</title></head><body>");
            out.println("<h1>Login Successful</h1>");
            out.println("<p>Welcome, " + username + "!</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><head><title>Login Error</title></head><body>");
            out.println("<h1>Login Error</h1>");
            out.println("<p>Invalid username or password.</p>");
            out.println("</body></html>");
        }

        out.close();
    }

    private boolean validateLogin(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                return rs.next(); // If a record is found, login is valid
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false in case of any database error
        }
    }
}
