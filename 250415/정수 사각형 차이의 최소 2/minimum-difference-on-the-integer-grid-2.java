import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][][] dp;
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
            if (next == null || newMax - newMin < next[1] - next[0]) {
                dp[nx][ny] = new int[]{newMin, newMax};
                findDP(nx, ny);
            }
        }
    }

    public static void dfs(int x, int y, int min, int max) {
        if (x == n - 1 && y == n - 1) {
            result = Math.min(result, max - min);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                int val = grid[nx][ny];
                dfs(nx, ny, Math.min(min, val), Math.max(max, val));
                visited[nx][ny] = false;
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

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < n; j++)
        //         findDP(i, j);
        // }

        // findDP(0, 0);

        result = Integer.MAX_VALUE;
        
        visited = new boolean[n][n];
        visited[0][0] = true;
        dfs(0, 0, grid[0][0], grid[0][0]);

        System.out.print(result);

        // int[] tmp = dp[n - 1][n - 1];
        // System.out.print(Math.abs(tmp[0] - tmp[1]));
    }
}