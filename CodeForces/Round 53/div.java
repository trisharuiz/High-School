import java.util.Scanner;

public class div {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		if(str.length() == 1){
			System.out.println("NO");
			return;
		}
		for(int i = 0; i< str.length()-1; i++){
			String s = str.substring(i, i+2);
			if(s.charAt(0) != s.charAt(1)){
				System.out.println("YES");
				System.out.println(s);
				return;
			}
		}
		System.out.println("NO");
		
		

	}

}
