import java.util.Scanner;

public class vasya {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt();
		while(t-->0){
			long s = sc.nextInt();
			long a = sc.nextInt();
			long b = sc.nextInt();
			long c = sc.nextInt();
			
			System.out.println(s/c/a*b +s/c);
			
			
		}
		

	}

}
