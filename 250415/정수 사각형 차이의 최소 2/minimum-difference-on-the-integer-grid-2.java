import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][][] dp;
    public static int min;
    public static int max;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void findDP(int x, int y){
        if (dp[x][y] == null)
            dp[x][y] = new int[]{grid[x][y], grid[x][y]};

        for (int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inRange(nx, ny)) continue;

            // 현재까지 min/max
            int curMin = dp[x][y][0];
            int curMax = dp[x][y][1];

            int nextVal = grid[nx][ny];
            int newMin = Math.min(curMin, nextVal);
            int newMax = Math.max(curMax, nextVal);

            int[] next = dp[nx][ny];
            if (next == null || newMax - newMin < next[1] - next[0]) {
                dp[nx][ny] = new int[]{newMin, newMax};
                findDP(nx, ny);
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

        findDP(0, 0);

        int[] tmp = dp[n - 1][n - 1];
        System.out.print(Math.abs(tmp[0] - tmp[1]));

    }
}