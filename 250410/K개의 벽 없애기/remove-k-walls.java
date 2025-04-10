import java.util.*;

public class Main {
    public static int n;
    public static int k; // k번까지 부셔도 댐
    public static int[][] grid;
    public static int r1;
    public static int c1;
    public static int r2;
    public static int c2;
    public static Queue<int[]> q = new LinkedList<>();
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int bfs(){
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int move = tmp[2];
            int broken = tmp[3];
            
            if (x == r2 && y == c2 && broken <= k)
                return move;
            
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny]){
                    if (grid[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, move + 1, broken});
                    }else if (broken < k){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, move + 1, broken + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;
        
        visited = new boolean[n][n];
        q.add(new int[]{r1, c1, 0, 0});

        System.out.print(bfs());
    }
}