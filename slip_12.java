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


  2.Write a Java Program to create a PROJECT table with field’s project_id, Project_name, Project_description, Project_Status. 
  Insert values in the table. Display all the details of the PROJECT table in a tabular format on the screen.(using swing)



  import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ProjectManagementSystem extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    private JLabel labelProjectId, labelProjectName, labelProjectDesc, labelProjectStatus;
    private JTextField textFieldProjectId, textFieldProjectName, textFieldProjectDesc, textFieldProjectStatus;
    private JButton buttonInsert, buttonDisplay;
    private JTextArea textArea;

    public ProjectManagementSystem() {
        super("Project Management System");

        labelProjectId = new JLabel("Project ID:");
        labelProjectName = new JLabel("Project Name:");
        labelProjectDesc = new JLabel("Project Description:");
        labelProjectStatus = new JLabel("Project Status:");

        textFieldProjectId = new JTextField(10);
        textFieldProjectName = new JTextField(20);
        textFieldProjectDesc = new JTextField(30);
        textFieldProjectStatus = new JTextField(10);

        buttonInsert = new JButton("Insert");
        buttonDisplay = new JButton("Display");

        textArea = new JTextArea(15, 50);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(labelProjectId);
        inputPanel.add(textFieldProjectId);
        inputPanel.add(labelProjectName);
        inputPanel.add(textFieldProjectName);
        inputPanel.add(labelProjectDesc);
        inputPanel.add(textFieldProjectDesc);
        inputPanel.add(labelProjectStatus);
        inputPanel.add(textFieldProjectStatus);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonInsert);
        buttonPanel.add(buttonDisplay);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        buttonInsert.addActionListener(e -> insertProject());
        buttonDisplay.addActionListener(e -> displayProjects());

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void insertProject() {
        String projectId = textFieldProjectId.getText();
        String projectName = textFieldProjectName.getText();
        String projectDesc = textFieldProjectDesc.getText();
        String projectStatus = textFieldProjectStatus.getText();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertQuery = "INSERT INTO PROJECT (project_id, project_name, project_description, project_status) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, projectId);
            pstmt.setString(2, projectName);
            pstmt.setString(3, projectDesc);
            pstmt.setString(4, projectStatus);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Project inserted successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting project: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayProjects() {
        textArea.setText("");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectQuery = "SELECT * FROM PROJECT";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                String projectId = rs.getString("project_id");
                String projectName = rs.getString("project_name");
                String projectDesc = rs.getString("project_description");
                String projectStatus = rs.getString("project_status");

                String projectDetails = String.format("Project ID: %s\nProject Name: %s\nProject Description: %s\nProject Status: %s\n\n",
                        projectId, projectName, projectDesc, projectStatus);
                textArea.append(projectDetails);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching projects: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProjectManagementSystem::new);
    }
}
