1. Write a java program to accept a String from a user and display each vowel from a String after every 3 
seconds
-------------------------------------------------------------
import java.util.Scanner;
public class DisplayVowels {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter a string: ");
 String input = scanner.nextLine();
 scanner.close();
 char[] characters = input.toCharArray();
 for (char ch : characters) {
 if (isVowel(ch)) {
 System.out.println(ch);
 try {
 Thread.sleep(3000);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 }
 }
 private static boolean isVowel(char ch) {
 ch = Character.toUpperCase(ch);
 return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
 }
}



Q2. Write a java program to accept ‘N’ student names through command line, store them into the 
appropriate Collection and display them by using Iterator and ListIterator interface
---------------------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
public class StudentNames {
 public static void main(String[] args) {
 if (args.length < 1) {
 System.out.println("Usage: java StudentNames <name1> <name2> <name3> ...");
 return;
 }
 ArrayList<String> studentNames = new ArrayList<>();
 for (String arg : args) {
 studentNames.add(arg);
 }
 System.out.println("Student Names (Using Iterator):");
 Iterator<String> iterator = studentNames.iterator();
 while (iterator.hasNext()) {
 System.out.println(iterator.next());
 }
 System.out.println("\nStudent Names (Using ListIterator in Reverse):");
 ListIterator<String> listIterator = studentNames.listIterator(studentNames.size());
 while (listIterator.hasPrevious()) {
 System.out.println(listIterator.previous());
 }
 }
}
