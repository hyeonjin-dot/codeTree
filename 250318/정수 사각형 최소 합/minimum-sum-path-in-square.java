import java.util.Scanner;
public class Main {
    public static int n;
    public static int[][] matrix;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        
        dp = new int[n][n];

        dp[n - 1][0] = matrix[n - 1][0];
        dp[n - 1][1] = matrix[n - 1][1] + dp[n - 1][0];
        dp[n - 1][2] = matrix[n - 1][2] + dp[n - 1][1];

        for (int i = n - 2; i >= 0; i--){
            dp[i][0] = dp[i + 1][0] + matrix[i][0];
            for (int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + matrix[i][j];
        }

        System.out.print(dp[0][n - 1]);
    }
}