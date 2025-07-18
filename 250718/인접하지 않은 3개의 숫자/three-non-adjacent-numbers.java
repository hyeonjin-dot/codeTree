import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++){
            dp[i][0] = arr[i];
            if (i == 0 || i == 1)
                continue;
            for (int j = 1; j < 3; j++){
                dp[i][j] = Math.max(dp[i - 2][j - 1] + arr[i] , dp[i - 1][j]);
            }
        }

        System.out.print(dp[n - 1][2]);

    }
}