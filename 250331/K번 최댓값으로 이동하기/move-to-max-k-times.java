import java.util.*;
public class Main {
    public static int n;
    public static int k;
    public static int[][] grid;
    public static int r;
    public static int c;
    public static Queue<int[]> q = new LinkedList<>();
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean[][] visited;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int[] bfs(){
        int max = 0;
        int[] res = q.peek();
        int num = grid[res[0]][res[1]];
        // System.out.println(num);

         List<int[]> candi = new ArrayList<>();
        
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            // int num = grid[x][y];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] < num){
                    if (max < grid[nx][ny]){
                        candi.clear();
                        max = Math.max(max, grid[nx][ny]);
                        candi.add(new int[]{nx, ny});
                    }else if (max == grid[nx][ny])
                        candi.add(new int[]{nx, ny});
                    visited[x][y] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if (candi.size() == 0)
            return res;
        else {
            Collections.sort(candi, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) return a[0] - b[0];  // x 좌표 기준
                    return a[1] - b[1];                    // x가 같다면 y 기준
                }
            });
            return candi.get(0);
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
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        for (int i = 0; i < k; i++){
            q.add(new int[]{r, c});
            visited = new boolean[n][n];
            visited[r][c] = true;
            int[] fir = bfs();
            r = fir[0];
            c = fir[1];
        }

        System.out.print(r + 1 + " " + (c+ 1));

    }
}