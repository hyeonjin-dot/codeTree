import java.util.*;
public class Main {
    public static int n;
    public static int m;
    public static int[][] a;
    public static int[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<int[]> q = new LinkedList<>();

    public static boolean canGo(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m 
            && a[x][y] == 1 && visited[x][y] == 0);
    }

    public static int dfs(){
        if (a[0][0] == 0)
            return -1;
        visited[0][0] = 1;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx, ny)){
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return visited[n - 1][m - 1] - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        visited = new int[n][m];
        System.out.print(dfs());
    }
}