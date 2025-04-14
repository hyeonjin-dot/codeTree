import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][] dp = new int[n][n];
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean[][] visited;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int findDP(int x, int y){
        if (dp[x][y] > -1)
            return dp[x][y];

        dp[x][y] = 1;

        int origin = grid[x][y];

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny)){
                int forCheck = grid[nx][ny];
                if (origin < forCheck)
                    dp[x][y] = Math.max(dp[x][y], findDP(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        
        int max = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                max = Math.max(max, findDP(i, j));
            }
        }

        System.out.print(max);
    }
}