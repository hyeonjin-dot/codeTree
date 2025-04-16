import java.util.*;
public class Main {
    public static int n;
    public static int[][] matrix;
    public static int[][] dp;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        dp = new int[n][n];
        dp[n - 1][n - 1] = matrix[n - 1][n - 1];

        for (int i = n - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if (i == j && i == n - 1)
                    continue;

                int leftX = i + dx[0];
                int leftY = j + dy[0];
                int upX = i + dx[1];
                int upY = j + dy[1];

                if (inRange(leftX, leftY) && inRange(upX, upY)){
                    int num = Math.min(dp[leftX][leftY], dp[upX][upY]);
                    dp[i][j] = Math.max(matrix[i][j], num);
                }
                else if (inRange(leftX, leftY))
                    dp[i][j] = Math.max(matrix[i][j], dp[leftX][leftY]);
                else if (inRange(upX, upY))
                    dp[i][j] = Math.max(matrix[i][j], dp[upX][upY]);
            }
        }

        System.out.print(dp[0][0]);
    }
}