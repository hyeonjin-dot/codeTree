import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j <= n; j++){
                if (dp[j - (i + 1)] != -1)
                    dp[j] = Math.max(dp[j], dp[j - (i + 1)] + profit[i]);
            }
        }

        System.out.print(dp[n]);
    }
}