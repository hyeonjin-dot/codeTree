import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int fromTop = (i > 0) ? Math.min(dp[i - 1][j], matrix[i][j]) : Integer.MIN_VALUE;
                int fromLeft = (j > 0) ? Math.min(dp[i][j - 1], matrix[i][j]) : Integer.MIN_VALUE;

                dp[i][j] = Math.max(fromTop, fromLeft);
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}