import java.util.*;
public class Main {
    public static int[] dp = new int[1001];

    public static int fibo(int n){
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for (int i = 4; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print(fibo(n));
    }
}
