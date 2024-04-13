1. Write a java program to display name and priority of a Thread.
-------------------------------------------------------------------------------
public class Main {
 public static void main(String[] args) {
 Thread thread = Thread.currentThread();
 System.out.println("Current Thread: " + thread.getName());
 System.out.println("Thread Priority: " + thread.getPriority());
 }
}




Q2. Write a SERVLET program which counts how many times a user has visited a web page. If user is 
visiting the page for the first time, display a welcome message. If the user is revisiting the page, display 
the number of times visited. (Use Cookie)
--------------------------------------------------------------------------------------
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 Cookie[] cookies = request.getCookies();
 Cookie visitCookie = null;
 int visitCount = 0;
 if (cookies != null) {
 for (Cookie cookie : cookies) {
 if (cookie.getName().equals("visitCount")) {
 visitCookie = cookie;
 break;
 }
}
}
if (visitCookie != null) {
visitCount = Integer.parseInt(visitCookie.getValue());
}
visitCount++;
visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
response.addCookie(visitCookie);
out.println("<html><head><title>Visit Counter Servlet</title></head><body>");
if (visitCount == 1) {
out.println("<h2>Welcome! This is your first visit.</h2>");
} else {
out.println("<h2>You have visited this page " + visitCount + " times.</h2>");
}
out.println("</body></html>");
}
}
