import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); // m-1개 뺄 예정
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, 1001);

        dp[1][1] = arr[1];

        for (int i = 2; i <= n - 2; i++) { // 맨 앞/뒤 제외
            for (int k = 1; k < m; k++) {
                // 선택 안함
                if (k == 1)
                    dp[i][k] = Math.min(dp[i - 1][k], arr[i]);
                else
                    dp[i][k] = dp[i - 1][k];
                // 선택함 (i번째 선택, i-1은 건너뛰었어야 함)
                if (i >= 3 && dp[i - 2][k - 1] < 1001)
                    dp[i][k] = Math.min(dp[i][k], dp[i - 2][k - 1] + arr[i]);
            }
        }
        
        System.out.println(sum - dp[n - 2][m - 1]);
    }
}
