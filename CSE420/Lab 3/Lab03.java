import java.util.regex.*;
import java.util.Scanner;

/**
 *
 * @author Nafid Faham
 */

public class Lab03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); //input int
        String [] string1 = new String[x];
        for(int i = 0; i < x; i++){
            string1[i] = sc.next(); //input Regex pattern
        }
        int y = sc.nextInt(); // input another int
        String [] string2 = new String[y];
        for(int i = 0; i < y; i++){
            string2[i] = sc.next();  // input string for validation
        }
        boolean b;
        for(int i = 0; i < y; i++){
            b = false;
            for(int j = 0; j < x; j++){
                 Pattern p = Pattern.compile(string1[j]);
                 Matcher m = p.matcher(string2[i]);
                 if(m.find()){
                     System.out.println("YES, " + (j + 1));
                     b = true;
                     break;
                 }
            }
            if(!b){
                System.out.println("NO, " + "0");
            }
        }
    }   
}