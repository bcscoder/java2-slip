1. Write a java program to read ‘N’ names of your friends, store it into HashSet and display them in 
ascending order
-------------------------------------------------------------------------------------------------
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
public class FriendNamesAscending {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the number of friends: ");
 int n = scanner.nextInt();
 scanner.nextLine(); // Consume newline character
 HashSet<String> friendSet = new HashSet<>();
 for (int i = 0; i < n; i++) {
 System.out.print("Enter name of friend " + (i + 1) + ": 
");
 String name = scanner.nextLine();
 friendSet.add(name);
 }
 TreeSet<String> sortedFriends = new TreeSet<>(friendSet);
 System.out.println("\nList of Friends in Ascending Order:");
 for (String friend : sortedFriends) {
 System.out.println(friend);
 }
 scanner.close();
 }
}

2.Design a servlet that provides information about a HTTP request from a client, such as 
IP-Address and browser type. The servlet also provides information about the server on 
which the servlet is running, such as the operating system type, and the names of 
currently loaded servlets.



 import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfoServlet")
public class RequestInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Request Information</title></head><body>");
        out.println("<h1>Client Request Information</h1>");
        out.println("<p>IP Address: " + request.getRemoteAddr() + "</p>");
        out.println("<p>Browser Type: " + request.getHeader("User-Agent") + "</p>");
        
        out.println("<h1>Server Information</h1>");
        out.println("<p>Operating System: " + System.getProperty("os.name") + "</p>");
        
        out.println("<h1>Loaded Servlets</h1>");
        String[] servletNames = getServletContext().getServletRegistrationNames().toArray(new String[0]);
        out.println("<ul>");
        for (String servletName : servletNames) {
            out.println("<li>" + servletName + "</li>");
        }
        out.println("</ul>");
        
        out.println("</body></html>");
        out.close();
    }
}

