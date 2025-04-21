import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        
        int[] dp = new int[m + 1];
        for (int i = 1; i < m + 1; i++)
            dp[i] = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                if (dp[j - coin[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }

        System.out.print(dp[m]);
    }
}