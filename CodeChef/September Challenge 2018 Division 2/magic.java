import java.util.Scanner;
public class magic {
	public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	int N = 0;
	int X = 0;
	int S = 0;
	int A = 0;
	int B = 0;
	
	for(int i = 0; i<T; i++) {
		N = sc.nextInt();
		X = sc.nextInt();
		S = sc.nextInt();
		for (int j = 0; j<S; j++) {
			A = sc.nextInt();
			B = sc.nextInt();
			if(A==X) {
				X = B;
			}else if(B==X) {
				X = A;
			}
			
		}
		System.out.println(X);
	}
}
}
