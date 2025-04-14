import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][] dp = new int[n][n];
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();
    public static boolean[][] visited;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int bfs(){
        int move = 0;
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            move = tmp[2];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && grid[x][y] < grid[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, move + 1});
                }
            }
        }

        return move;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dp = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                visited = new boolean[n][n];
                q.add(new int[]{i, j, 1});
                visited[i][j] = true;
                dp[i][j] = bfs();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                max = Math.max(max, dp[i][j]);
        }

        System.out.print(max);
    }
}