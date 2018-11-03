import java.util.Scanner;
public class function{
public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    long n = scan.nextLong();
    long k = scan.nextLong();
    
    long x = k/n;
    if((k%n !=0)) x++;
    System.out.println(x);
}
}
