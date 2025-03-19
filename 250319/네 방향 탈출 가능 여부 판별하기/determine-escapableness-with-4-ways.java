import java.util.*;
public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<int[]> que = new LinkedList<>();

    public static boolean canGo(int x, int y){
        return (x >= 0 && x < n && y < n && y >= 0
                && grid[x][y] == 1);
    }

    public static void bfs(){
        if (grid[0][0] == 0)
            return ;
        
        visited[0][0] = true;
        que.add(new int[]{0, 0});

        while (!que.isEmpty()){
            int[] tmp = que.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++){
                if (canGo(x + dx[i], y + dy[i]) && !visited[x + dx[i]][y + dy[i]]){
                    visited[x + dx[i]][y + dy[i]] = true;
                    que.add(new int[]{x + dx[i], y + dy[i]});
                }
            }
        }
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
        bfs();

        if (visited[n - 1][n - 1])
            System.out.print(1);
        else
            System.out.print(0);
    }
}