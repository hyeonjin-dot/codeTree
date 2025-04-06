import java.util.Scanner;
public class Main {
    public static long[] dp = new long[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
        
        long MOD = 1000000007;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2]) % MOD;

            for (int j = i - 3; j >= 0; j--) {
                dp[i] = (dp[i] + 2 * dp[j]) % MOD;
            }
        }
        
        System.out.print(dp[n]);
    }
}