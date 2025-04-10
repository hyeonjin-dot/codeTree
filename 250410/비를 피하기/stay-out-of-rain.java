import java.util.*;

public class Main {
    public static int n;
    public static int h;
    public static int m;
    public static int[][] a;
    public static int[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();
    public static int[][] res;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static boolean canGo(int x, int y){
        if (a[x][y] == 1 || visited[x][y] > 0)
            return false;
        return true;
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
                if (inRange(nx, ny) && canGo(nx, ny)){
                    visited[nx][ny] = move + 1;
                    q.add(new int[]{nx, ny, move + 1});
                }
            }
        }
    }

    public static void upgradeRes(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (a[i][j] == 2){
                    if (res[i][j] > 0 && visited[i][j] > 0)
                        res[i][j] = Math.min(visited[i][j], res[i][j]);
                    else if (visited[i][j] > 0)
                        res[i][j] = visited[i][j];
                }
            }
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        
        res = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (a[i][j] == 3){
                    q.add(new int[]{i, j, 0});
                    visited = new int[n][n];
                    bfs();
                    upgradeRes();
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (a[i][j] == 2 && res[i][j] > 0)
                    System.out.print(res[i][j] + " ");
                else if (a[i][j] == 2 && res[i][j] == 0)
                    System.out.print("-1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }

    }
}