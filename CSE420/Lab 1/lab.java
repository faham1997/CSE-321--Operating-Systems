import java.io.File;
import java.util.*;

/**
*
*
* @author  Nafid Faham
* @since   2020-11-09 
*/

public class lab {
	
	public lab(File newFile) {
		file = newFile;
	}
	
	File file;
	String s = "";
	
    ArrayList<String> keywordsList = new ArrayList<String>(Arrays.asList("abstract","assert","boolean","break","byte","case","catch","char","class","const","continue","default","do","double","else","enum","extends","false","final","finally","float","for","goto","if","implements","import","instanceof","int","interface","long","native","new","null","package","private","protected","public","return","short","static","super","switch","synchronized","this","throw","throws","true","try","void","volatile","while")); 
    ArrayList<String> mathOperatorList = new ArrayList<String>(Arrays.asList("+", "-", "=", "/","%","*","++","--"));
    ArrayList<String> logcialOperatorList = new ArrayList<String>(Arrays.asList(">", "<", ">=", "<=","||","&&","^","|","&","!"));
    ArrayList<String> othersList = new ArrayList<String>(Arrays.asList(",", ";", "(",")","{","}","[","]"));
    
    ArrayList<String> keywords = new ArrayList<>();
    ArrayList<String> identifiers = new ArrayList<>();
    ArrayList<String> mathOperators = new ArrayList<>();
    ArrayList<String> logOperators = new ArrayList<>();
    ArrayList<String> others = new ArrayList<>();
    ArrayList<String> numerical = new ArrayList<>();
    
    public static boolean isStringInt(String s3){
        try{
          Integer.parseInt(s3);
          return true;
        }
        catch(NumberFormatException ex){
          return false;
        }
      }
    
    public static boolean isStringDouble(String s4){
        try{
          Double.parseDouble(s4);
          return true;
        }
        catch(NumberFormatException ex){
          return false;
        }
      }
    
    public void analyze() throws Exception {
    	Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            s=sc.nextLine().trim();
            String[] s1 = s.split(" "); 
            for(String s2:s1){
              if(keywordsList.contains(s2) && !keywords.contains(s2)){
                keywords.add(s2);
              }
              else if(mathOperatorList.contains(s2) && !mathOperators.contains(s2)){
                mathOperators.add(s2);
              }
              else if(logcialOperatorList.contains(s2) && !logOperators.contains(s2)){
                logOperators.add(s2);
              }
              else if(othersList.contains(s2) && !others.contains(s2)){
                others.add(s2);
              }
              else if(!others.contains(s2) && !mathOperators.contains(s2) && !logOperators.contains(s2)){
            	  if(s2.contains(",") ) {
            		 s2=s2.replace(",", "");
           		  	 if(!others.contains(",")) {
           		  		 others.add(",");
           		  	 }
            	  }
            	  else if(s2.contains(";")){
            	  s2=s2.replace(";", "");
        		  	 if(!others.contains(";")) {
           		  		 others.add(";");
           		  	 }
            	  }
                if(isStringInt(s2) && !numerical.contains(s2)){
                	numerical.add(s2);
                }
                else if(isStringDouble(s2) && !numerical.contains(s2)){
                	numerical.add(s2);
                }
                else if(!identifiers.contains(s2)){
                	identifiers.add(s2);
                }
              }
            }
          }    
    }
    
      public void printList() {
    	    System.out.print("Keywords: ");
    	    for(int i=0; i<keywords.size(); i++){
    	      System.out.print(keywords.get(i)+",");
    	    }
    	    System.out.println();
    	    
    	    System.out.print("Identifiers: ");
    	    for(int i=0; i<identifiers.size(); i++){
    	      System.out.print(identifiers.get(i)+",");
    	    }
    	    System.out.println();
    	    
    	    System.out.print("MathOperators: ");
    	    for(int i=0; i<mathOperators.size(); i++){
    	      System.out.print(mathOperators.get(i)+",");
    	    }
    	    System.out.println();
    	    
    	    System.out.print("LogicalOperators: ");
    	    for(int i=0; i<logOperators.size(); i++){
    	      System.out.print(logOperators.get(i)+",");
    	    }
    	    System.out.println();
    	    
    	    System.out.print("NumericalValues: ");
    	    for(int i=0; i<numerical.size(); i++){
    	      System.out.print(numerical.get(i)+",");
    	    }
    	    System.out.println();
    	    
    	    System.out.print("Others: ");
    	    for(int i=0; i<others.size(); i++){
    	      System.out.print(others.get(i)+" ");
    	    }
    	    System.out.println();
      }
	}
