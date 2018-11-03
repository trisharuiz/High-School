import java.util.ArrayList;
import java.util.Scanner;

public class doggo {

	public static void main(String[] args) {
		    Scanner s = new Scanner(System.in);
		    int pupNum = s.nextInt();

		    s.nextLine();
		    String pup = s.nextLine();

		    boolean ans = false;
		    ArrayList<String> pups = new ArrayList <String>();
		    for(int i = 0; i < pupNum; i++) {
		    	pups.add(pup.substring(i,i+1));
		    }
		    if(pups.size() == 1) {
		    	System.out.println("YES");
		    	System.exit(0);
		    }
		    for(int i = 0; i< pupNum; i++) {
		        if (ans) break;
		        for(int j = i+1; j<pupNum; j++){
	               
	                if(pups.get(i).equals(pups.get(j))) {
		    		System.out.println("YES");
		    		ans = true;
		    		break;
		         }
		        	    	}
		    }
		    if (ans == false) System.out.println("NO");
		    
	}

}