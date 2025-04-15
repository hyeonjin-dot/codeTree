import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][][] dp;
    public static int[][][] revDp;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};
    public static boolean[][] visited;
    public static int result;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void findDP(int x, int y){
        if (dp[x][y] == null)
            dp[x][y] = new int[]{grid[x][y], grid[x][y]};

        for (int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny))
                continue;

            // 현재까지 min/max
            int curMin = dp[x][y][0];
            int curMax = dp[x][y][1];

            int nextVal = grid[nx][ny];
            int newMin = Math.min(curMin, nextVal);
            int newMax = Math.max(curMax, nextVal);

            int[] next = dp[nx][ny];
            if (next == null || newMax - newMin < next[1] - next[0]
             || (newMax - newMin == next[1] - next[0]
                     && (newMin != next[0] || newMax != next[1]))) {
                dp[nx][ny] = new int[]{newMin, newMax};
                findDP(nx, ny);
            }
        }
    }

    public static void reverseDP(int x, int y){
        if (revDp[x][y] == null)
            revDp[x][y] = new int[]{grid[x][y], grid[x][y]};

        for (int i = 0; i < 2; i++){
            int nx = x - dx[i];
            int ny = y - dy[i];

            if (!inRange(nx, ny))
                continue;

            // 현재까지 min/max
            int curMin = revDp[x][y][0];
            int curMax = revDp[x][y][1];

            int nextVal = grid[nx][ny];
            int newMin = Math.min(curMin, nextVal);
            int newMax = Math.max(curMax, nextVal);

            int[] next = revDp[nx][ny];
            if (next == null || newMax - newMin < next[1] - next[0]
                || (newMax - newMin == next[1] - next[0]
                     && (newMin != next[0] || newMax != next[1]))) {
                revDp[nx][ny] = new int[]{newMin, newMax};
                reverseDP(nx, ny);
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

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                findDP(i, j);
        }

        // findDP(0, 0);

        revDp = new int[n][n][];

        for (int i = n - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--)
                reverseDP(i, j);
        }
        // reverseDP(n - 1, n - 1);


        int forward = dp[n - 1][n - 1][1] - dp[n - 1][n - 1][0];
        int reverse = revDp[0][0][1] - revDp[0][0][0];
        System.out.print(Math.min(forward, reverse));
    }
}