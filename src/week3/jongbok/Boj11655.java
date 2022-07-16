import java.util.*;

public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String str = sc.nextLine();
    	
    	int len = str.length();
    	String answer ="";
    	
    	for(int i=0; i<len; i++){
    	   char c = str.charAt(i);
    	   
    	   if(Character.isAlphabetic(c)){
    	       int num = (int)c;
    	       
    	       if(65<= num && num <= 90){
    	           num += 13;
    	           
    	           if(num > 90){
    	               num -= 26;
    	           }
    	           
    	           answer += Character.toString((char)num);
    	           
    	       }else if(97<= num && num <= 122){
    	           num += 13;
    	           
    	           if(num > 122){
    	               num -= 26;
    	           }
    	           
    	           answer += Character.toString((char)num);
    	       }
    	       
    	   }else{
    	       answer += Character.toString(c);
    	   }
    	    
    	}
    	
    	System.out.println(answer);
	}
}
