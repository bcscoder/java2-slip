1. Write a java program to create a TreeSet, add some colors (String) and print out the content of 
TreeSet in ascending order.
---------------------------------------------------------------------------------------
import java.util.TreeSet;
public class TreeSetExample {
 public static void main(String[] args) {
 TreeSet<String> colors = new TreeSet<>();
 colors.add("Red");
 colors.add("Green");
 colors.add("Blue");
 colors.add("Yellow");
 colors.add("Orange");
 System.out.println("Colors in ascending order:");
 for (String color : colors) {
 System.out.println(color);
 }
 }
}


2.Write a Java program to accept the details of Teacher (TNo, TName, Subject).
 Insert at least 5 Records into Teacher Table and display the details of Teacher who is teaching “JAVA” Subject.
 (Use PreparedStatement Interface)




 import java.sql.*;

public class TeacherManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Create table if not exists
            createTeacherTable(conn);

            // Insert records
            insertTeacher(conn, "101", "John Doe", "JAVA");
            insertTeacher(conn, "102", "Jane Smith", "C++");
            insertTeacher(conn, "103", "Mike Johnson", "JAVA");
            insertTeacher(conn, "104", "Emily Brown", "Python");
            insertTeacher(conn, "105", "Chris Wilson", "JAVA");

            // Display teachers teaching JAVA
            displayTeachers(conn, "JAVA");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void createTeacherTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Teacher (TNo VARCHAR(10) PRIMARY KEY, TName VARCHAR(50), Subject VARCHAR(50))";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableSQL);
            System.out.println("Teacher table created successfully.");
        }
    }

    private static void insertTeacher(Connection conn, String tNo, String tName, String subject) throws SQLException {
        String insertSQL = "INSERT INTO Teacher (TNo, TName, Subject) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, tNo);
            pstmt.setString(2, tName);
            pstmt.setString(3, subject);
            pstmt.executeUpdate();
            System.out.println("Teacher record inserted successfully.");
        }
    }

    private static void displayTeachers(Connection conn, String subject) throws SQLException {
        String selectSQL = "SELECT * FROM Teacher WHERE Subject = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setString(1, subject);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Teachers teaching " + subject + ":");
            while (rs.next()) {
                String tNo = rs.getString("TNo");
                String tName = rs.getString("TName");
                String subj = rs.getString("Subject");
                System.out.println("TNo: " + tNo + ", TName: " + tName + ", Subject: " + subj);
            }
        }
    }
}
