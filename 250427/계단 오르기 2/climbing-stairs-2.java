import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        
        int[][] dp = new int[n + 1][4];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        dp[n][0] = coins[n];

        for (int i = n; i >= 0; i--){
            for (int cnt = 0; cnt <= 3; cnt++) {
                if (dp[i][cnt] == -1)
                    continue;

                // 1칸 이동
                if (i - 1 >= 0 && cnt < 3) {
                    dp[i - 1][cnt + 1] = Math.max(dp[i - 1][cnt + 1], dp[i][cnt] + coins[i - 1]);
                }
                // 2칸 이동
                if (i - 2 >= 0) {
                    dp[i - 2][cnt] = Math.max(dp[i - 2][cnt], dp[i][cnt] + coins[i - 2]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < 3; i++)
            max = Math.max(dp[0][i], max);

        System.out.print(max);
    }
}