import java.util.*;

public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String str = sc.next();
    	
    	ArrayList<String> arr = new ArrayList<>();
    	int pos = str.length();
    	pos = pos-1;
    	
    	while(true){
    	    
    	    if(pos == -1){
    	        break;
    	    }
    	    
    	    String tmp = str.substring(pos--);
    	    arr.add(tmp);
    	}
    	
    	Collections.sort(arr);
    	
    	for(String tmp: arr){
    	    System.out.println(tmp); 
    	}
    	
    	
	}
}
