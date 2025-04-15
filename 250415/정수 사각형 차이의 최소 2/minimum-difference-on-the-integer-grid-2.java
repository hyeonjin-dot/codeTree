import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][][] dp;
    // public static int min;
    // public static int max;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void findDP(int x, int y){
        for (int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny)){
                int[] tmp = dp[x][y];
                int min;
                int max;
                if (tmp == null){
                    min = Math.min(grid[x][y], grid[nx][ny]);
                    max = Math.max(grid[x][y],grid[nx][ny]);
                }
                else{
                    min = Math.min(tmp[0], grid[nx][ny]);
                    max = Math.max(tmp[1], grid[nx][ny]);
                }
                int[] check = dp[nx][ny];
                if (check == null || max - min < Math.abs(check[1] - check[0]))
                    dp[nx][ny] = new int[]{min, max};
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n][];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }

        // dp[n - 1][n - 1] = 0;
        // min = grid[n - 1][n - 1];
        // max = grid[n - 1][n - 1];

        dp[0][0] = new int[]{grid[0][0], grid[0][0]};

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                findDP(i, j);
        }
        int[] tmp = dp[n - 1][n - 1];
        System.out.print(Math.abs(tmp[0] - tmp[1]));
    }
}