import java.util.Scanner;
/**
*
* The lab gives a hand on experience of the knowledge 
* of theory class of Lexical Analysis by creating web/email checker
* 
*
* @author  Nafid Faham
* @ID 	   18101107
* @since   2020-11-16 
*/
public class Lab02{
	
    public static boolean webChecker(String s){
        if(s.startsWith("www")){
            String [] s3 = s.split("\\.");
            for(int i = 0; i < s3.length; i++){
                char [] c2 = s3[i].toCharArray();
                for(int j = 0; j < c2.length; j++){
                if(c2[j] >= 'a' && c2[j] <= 'z' || c2[j] >= 'A' && c2[j] <= 'Z' ||
                        c2[j] >= '0' && c2[j] <= '9'){
                        return true;
                    }
                    else{
                        return false;
                    }  
                }
            }
        }
        return false;
    }
    
    public static boolean mailChecker(String s){
        String [] s2 = s.split("\\@");
        for(int i = 0; i < s2.length; i++){
            char [] c1 = s2[i].toCharArray();
            for(int j = 0; j < c1.length; j++){
                if(c1[j] >= 'a' && c1[j] <= 'z' || c1[j] >= 'A' && c1[j] <= 'Z' ||
                        c1[j] >= '0' && c1[j] <= '9'){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert an integer: ");
        int x1 = sc.nextInt();
        for(int i = 0; i < x1; i++){
            System.out.println("Insert a mail and/or web address: ");
            String string1 = sc.next();
            for(int j = 0; j < string1.length(); j++){
                if(string1.charAt(j) == '@'){
                    if(mailChecker(string1) == true){
                        System.out.println("Email, " + (i + 1));
                        break;
                    }
                }
                else{
                    if(webChecker(string1) == true){
                        System.out.println("Web, " + (i + 1));
                        break;
                    }
                }
            }
        }
    }
}
