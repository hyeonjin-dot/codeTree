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
    public static List<int[]> lst = new ArrayList<>();
    public static boolean[][] visited;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int[] bfs(){
        int max = 0;
        int[] res = q.peek();
        int num = grid[res[0]][res[1]];
        // System.out.println(num);
        
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            // int num = grid[x][y];
            visited[x][y] = true;

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] < num){
                    max = Math.max(max, grid[nx][ny]);
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] > max)
                    break ;
                if (grid[i][j] == max){
                    return (new int[]{i, j});
                }
            }
        }

        return res;
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
        
        q.add(new int[]{r, c});
        visited = new boolean[n][n];
        lst.add(bfs());

        for (int i = 1; i < k; i++){
            visited = new boolean[n][n];
            q.add(lst.get(lst.size() - 1));
            lst.add(bfs());
        }

        int[] tmp = lst.get(lst.size() - 1);
        System.out.print(tmp[0] + 1 + " " + (tmp[1] + 1));

    }
}