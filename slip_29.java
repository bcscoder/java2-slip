1. Write a Java program to display information about all columns in the DONAR table using ResultSetMetaData.
--------------------------------------------------------------------------------
import java.sql.*;
public class DONOR {
 public static void main(String[] args) {
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
 } // for
 System.out.println("\t--------------------------------------------------");
 rs.close();
 stmt.close();
 conn.close();
 } // try
 catch (Exception e) {
 System.out.println(e);
 } // catch
 }
}


----------------------------------------------------
     create table donor(did int, dname char(22),daddr varchar(22));
    insert into donor VALUES(1,'AAA','zzz');
     insert into donor VALUES(2,'BBB','yyy');
     insert into donor VALUES(3,'CCC','xxx');
     insert into donor VALUES(4,'DDD','www');
    SELECT * from donor
--------------------------------------------------------




Q2. Write a Java program to create LinkedList of integer objects and perform the following
---------------------------------------------------------------------------------------------
import java.util.LinkedList;
public class LinkedListOperations {
 public static void main(String[] args) {
 LinkedList<Integer> linkedList = new LinkedList<>();
 linkedList.addFirst(10);
 linkedList.addFirst(20);
 linkedList.addFirst(30);
 System.out.println("LinkedList after adding elements at first position:");
 displayLinkedList(linkedList);
 if (!linkedList.isEmpty()) {
    linkedList.removeLast();
    }
    System.out.println("\nLinkedList after deleting last element:");
    displayLinkedList(linkedList);
    System.out.println("\nSize of the LinkedList: " + linkedList.size());
    }
    private static void displayLinkedList(LinkedList<Integer> list) {
    for (Integer element : list) {
    System.out.print(element + " ");
    }
    System.out.println();
    }
   }
   
