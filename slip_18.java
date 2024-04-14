1. Write a java program to display name and priority of a Thread.
------------------------------------------------------------------------------
public class ThreadInfo {
    public static void main(String[] args) {
    Thread thread = Thread.currentThread();
    System.out.println("Current Thread Name: " + thread.getName());
    System.out.println("Current Thread Priority: " + thread.getPriority());
    }
   }

2.Write a SERVLET program in java to accept details of student (SeatNo, Stud_Name, Class, Total_Marks).
    Calculate percentage and grade obtained and display details on page.



    import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String seatNo = request.getParameter("seatNo");
        String studName = request.getParameter("studName");
        String className = request.getParameter("className");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        double percentage = (double) totalMarks / 100 * 100;
        String grade = calculateGrade(percentage);

        out.println("<html><head><title>Student Details</title></head><body>");
        out.println("<h1>Student Details</h1>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Student Name: " + studName + "</p>");
        out.println("<p>Class: " + className + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body></html>");

        out.close();
    }

    private String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C";
        } else {
            return "Fail";
        }
    }
}
