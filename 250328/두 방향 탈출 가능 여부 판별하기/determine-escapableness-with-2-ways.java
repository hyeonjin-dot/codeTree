import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int res;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void dfs(int x, int y){
        if (!inRange(x, y) || visited[x][y] || grid[x][y] == 0)
            return ;
        
        if (x == n - 1 && y == m - 1){
            res = 1;
            return ;
        }

        visited[x][y] = true;
        dfs(x, y + 1);
        dfs(x + 1, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        visited = new boolean[n][m];
        res = 0;
        dfs(0, 0);
        System.out.print(res);
    }
}
