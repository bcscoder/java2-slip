1. Write a java program to accept ‘N’ integers from a user. Store and display integers in sorted order 
having proper collection class. The collection should not accept duplicate elements.
---------------------------------------------------------------------------------------------
import java.util.Scanner;
import java.util.TreeSet;
public class SortedIntegers {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 TreeSet<Integer> numbers = new TreeSet<>();
 System.out.print("Enter the number of integers (N): ");
 int n = scanner.nextInt();
 System.out.println("Enter " + n + " integers:");
 for (int i = 0; i < n; i++) {
 int num = scanner.nextInt();
 numbers.add(num);
 }
 System.out.println("Integers in sorted order without duplicates:");
 for (int number : numbers) {
 System.out.println(number);
 }
 scanner.close();
 }
}
