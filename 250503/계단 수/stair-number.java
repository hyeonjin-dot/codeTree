import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000000007;
        
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i < 10; i++)
            dp[1][i] = 1; // 1자리

        for (int i = 1; i <= n; i++){ // 몇자리?
            for (int j = 0; j < 10; j++){ //해당 수
                if (j <= 8)
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i][j]) % mod;
                if (j >= 1)
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i][j]) % mod;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum = (sum + dp[n][i]) % mod;
        
        System.out.print(sum);
    }
}