import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][][] dp = new long[n + 1][3][3];

        dp[1][0][0] = 1; // g
        dp[1][1][0] = 1; // b
        dp[1][0][1] = 1; // t

        long mod = 1000000007;

        for (int i = 2; i <= n; i++){
            // dp[i][0][0] = dp[i - 1][0][0];
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++){
                    dp[i][0][k] = (dp[i][0][k] + dp[i - 1][j][k]) % mod; // g
                    
                    if (j + 1 < 3)
                        dp[i][j + 1][k] = (dp[i][j + 1][k] + dp[i - 1][j][k]) % mod;
                    
                    if (k + 1 < 3)
                        dp[i][0][k + 1] = (dp[i][0][k + 1] + dp[i - 1][j][k]) % mod;
                
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++)
                sum += (dp[n][i][j]);
        }
        System.out.print(sum % 1000000007);
    }
}