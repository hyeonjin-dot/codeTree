import java.util.*;
public class Main {
    public static int n;
    public static int k;
    public static int u;
    public static int d;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();
    public static int max;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int cntVisited(){
        int res = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j])
                    res++;
            }
        }

        return res;
    }

public static boolean[][] copyVisited(boolean[][] original) {
    boolean[][] copy = new boolean[n][n];
    for (int i = 0; i < n; i++)
        copy[i] = original[i].clone();
    return copy;
}

public static void find(boolean[][] visited, int cnt, int kCnt) {
    if (kCnt == k + 1) {
        max = Math.max(max, cnt);
        return;
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j]) {
                // 방문 상태 복사
                boolean[][] nextVisited = copyVisited(visited);
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                nextVisited[i][j] = true;

                int localCnt = 1; // 현재 시작점 포함
                while (!q.isEmpty()) {
                    int[] tmp = q.poll();
                    int x = tmp[0];
                    int y = tmp[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if (inRange(nx, ny) && !nextVisited[nx][ny] && diff(x, y, nx, ny)) {
                            nextVisited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            localCnt++;
                        }
                    }
                }

                find(nextVisited, cnt + localCnt, kCnt + 1); // 백트래킹 재귀
            }
        }
    }
}


    public static boolean diff(int x, int y, int nx, int ny){
        int a = grid[x][y];
        int b = grid[nx][ny];

        return (Math.abs(a - b) >= u && Math.abs(a - b) <= d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        visited = new boolean[n][n];
        max = 0;

        find(visited, 0, 1);

        System.out.print(max);
    }
}