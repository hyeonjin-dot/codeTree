import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static int[][] dp;
    public static int max;

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void dfs(int x, int y){
        if (!inRange(x, y) || x == n - 1 || y == m - 1)
            return ;

        for (int i = x + 1; i < n; i++){
            for (int j = y + 1; j < m; j++){
                if (grid[x][y] < grid[i][j]){
                    dp[i][j] = Math.max(dp[x][y] + 1, dp[i][j]);
                    max = Math.max(max, dp[i][j]);
                    dfs(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int x = 0; x < i; x++){
                    for (int y = 0; y < j; y++){
                        if (dp[x][y] == -1)
                            continue;
                        
                        if (grid[i][j] > grid[x][y])
                            dp[i][j] = Math.max(dp[x][y] + 1, dp[i][j]);
                    }
                }
            }
        }

        max = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                max = Math.max(max, dp[i][j]);
        }

        System.out.print(max);

    }
}