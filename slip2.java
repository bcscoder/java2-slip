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