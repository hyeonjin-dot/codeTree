import java.util.*;

public class Main {
    public static int n;

    public static int fibo(int n){
        if (n == 1)
            return n;
        else if (n <= 4)
            return n - 1;
        else
            return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.print(fibo(n));
    }
}