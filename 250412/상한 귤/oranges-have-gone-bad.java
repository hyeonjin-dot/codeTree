import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] time;
    public static Queue<int[]> q = new LinkedList<>();
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y < n && y >= 0);
    }

    public static void bfs(){
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int move = tmp[2];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1){
                    q.add(new int[]{nx, ny, move + 1});
                    time[nx][ny] = time[nx][ny] == 0 ? move + 1 : (Math.min(move + 1, time[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        time = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    visited = new boolean[n][n];
                    visited[i][j] = true;
                    q.add(new int[]{i, j, 0});
                    bfs();
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0)
                    System.out.print("-1 ");
                else if (grid[i][j] == 1 && time[i][j] == 0)
                    System.out.print("-2 ");
                else
                    System.out.print(time[i][j] + " ");
            }
            System.out.println();
        }
    }
}