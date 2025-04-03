import java.util.*;
public class Main {
    public static int fibo(int n){
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else
            return (fibo(n - 1) + fibo(n - 2)) % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print(fibo(n));
    }
}