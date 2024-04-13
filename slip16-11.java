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
