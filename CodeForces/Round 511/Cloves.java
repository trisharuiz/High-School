import java.util.Scanner;

public class Cloves {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long div  = n/3;
		long a,b,c;
		a = div;
		b = div;
		c = n-(a+b);
		while(a%3 == 0||b%3 ==0||c%3 ==0){
			if(a%3 ==0){
				a++;
				c--;
			}
			if(b%3 ==0){
				b++;
				c--;
			}
			if(c%3 ==0){
				c--;
				c--;
				a++;
				b++;
			}
		}

		System.out.println(a+" "+b+" "+c);
	}

}
