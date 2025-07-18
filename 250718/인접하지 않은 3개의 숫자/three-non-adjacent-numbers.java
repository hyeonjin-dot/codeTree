import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[][] dp = new int[n][4]; // 0~3개 선택

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);

        dp[0][0] = 0;
        dp[0][1] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= 3; j++) {
                // 선택 안함
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                // 선택함
                if (i >= 2 && dp[i - 2][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j - 1] + arr[i]);
                }
                // 예외적으로 i == 1일 때는 i-2가 없으므로 따로 처리
                if (i == 1 && j == 1)
                    dp[i][j] = Math.max(dp[i][j], arr[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i][3]);

        System.out.println(ans);
    }
}
