import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[] boom = new int[101];
    public static boolean[][] visited;
    public static int cnt;
    public static int max;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void dfs(int x, int y, int check){
        if (!inRange(x, y) || visited[x][y] || grid[x][y] != check)
            return ;
        
        visited[x][y] = true;
        cnt++;

        dfs(x + 1, y, check);
        dfs(x - 1, y, check);
        dfs(x, y + 1, check);
        dfs(x, y - 1, check);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];
        max = 0;
        int boomCnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visited[i][j]){
                    cnt = 0;
                    dfs(i, j, grid[i][j]);
                    if (cnt >= 4)
                        boomCnt++;
                    max = Math.max(max, cnt);
                }
            }
        }

        if (max < 4){
            System.out.print("0 " + max);
            return ;
        }

        System.out.print(boomCnt + " " + max);
    }
}