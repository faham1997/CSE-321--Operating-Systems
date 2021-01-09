import java.util.Scanner;
import java.io.*;
public class Lab04{
  public static void main (String[] args) throws IOException  {
     File file = new File("C:\\Users\\Kaneki\\Desktop\\LABS\\CSE420\\src\\input.txt");
     Scanner sc = new Scanner(file);
     
     System.out.println("Methods: ");
     while(sc.hasNext()){
       String str = sc.nextLine();
       String str1 = sc.next();
       if (str.contains("(") && str1.contains("{")){
        String[] array1 = str.split("\\(");    
        String[] array2 = array1[0].split(" ");    
        String p2 = "("+array1[1];
        System.out.println(array2[array2.length-1]+p2+", return type: "+array2[array2.length-2]);
       }
     }
  }
}