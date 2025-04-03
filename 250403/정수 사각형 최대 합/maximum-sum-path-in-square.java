import java.util.*;

public class Main {
    public static int n;
    public static int[][] matrix;
    public static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dp = new long[n][n];
        
        dp[n -1][n - 1] = matrix[n - 1][n - 1];

        for (int i = n - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if (i == n - 1 && j == n - 1)
                    continue;
                else{
                    if (i == n - 1)
                        dp[i][j] = dp[i][j + 1] + matrix[i][j];
                    else if (j == n - 1)
                        dp[i][j] = dp[i + 1][j] + matrix[i][j];
                    else
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + matrix[i][j];
                }
            }
        }

        System.out.print(dp[0][0]);

    }
}