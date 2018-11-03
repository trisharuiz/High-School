import java.util.Scanner;
public class equality{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int k = scan.nextInt();
		String str = scan.next();
		int min = x;
		int cur = 0;
		int[] arr = new int[k];
		for(int i = 0; i<x; i++){
		    arr[str.charAt(i)-'A']++;
		}
		for(int j=0; j<k; j++){
		    if(arr[j]<min){
		        min=arr[j];
		    }
		}
		System.out.println(min*k);
		
	}
}