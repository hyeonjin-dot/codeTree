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

        // dp[n - 1][0] = matrix[n - 1][0];

        for (int i = n - 1; i >= 0; i--){
            for (int j = 0; j < n; j++){
                if (i < n - 1 && j > 0)
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
                else if (i == n - 1 && j > 0)
                    dp[i][j] = dp[i][j - 1];
                else if (j == 0 && i < n - 1)
                    dp[i][j] = dp[i + 1][j];
                dp[i][j] += matrix[i][j];
            }
        }

        System.out.print(dp[0][n - 1]);
    }
}