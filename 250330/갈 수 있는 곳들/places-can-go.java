import java.util.*;
public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[][] grid;
    public static int[][] starts;
    public static int cnt;
    public static Queue<int[]> que;
    public static boolean[][] visited;
    public static int[][] visitedCnt;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void dfs(){
        while (!que.isEmpty()){
            int[] tmp = que.poll();
            // System.out.println(tmp[0] + " " + tmp[1]);
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0){
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j]){
                    // System.out.println(i + " " + j);
                    visitedCnt[i][j]++;
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
        starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt() - 1;
            starts[i][1] = sc.nextInt() - 1;
        }

        cnt = 0;
        visitedCnt = new int[n][n];
        for (int i = 0; i < k; i++){
            que = new LinkedList<>();
            que.add(new int[]{starts[i][0], starts[i][1]});
            visited = new boolean[n][n];
            visited[starts[i][0]][starts[i][1]] = true;
            dfs();
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visitedCnt[i][j] > 0)
                    cnt++;
            }
        }

        System.out.print(cnt);
    }
}