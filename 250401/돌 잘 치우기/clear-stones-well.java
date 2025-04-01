import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int m;
    public static int[][] grid;
    public static int[][] startPoints;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();
    public static List<int[]> lst = new ArrayList<>();
    public static List<int[]> rock;
    public static int cnt;

    public static void find(int idx){
        if (rock.size() == m){
            for (int i = 0; i < k; i++){
                q.add(new int[]{startPoints[i][0], startPoints[i][1]});
                visited = new boolean[n][n];
                visited[startPoints[i][0]][startPoints[i][1]] = true;
                bfs();
                cnt = Math.max(cnt, countVisited());
            }
            return ;
        }

        if (idx == lst.size())
            return;
        

        rock.add(lst.get(idx));
        find(idx + 1);
        rock.remove(rock.size() - 1);
        find(idx + 1);
    }

    public static void foundRock(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1)
                    lst.add(new int[]{i, j});
            }
        }
    }

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static boolean canGo(int x, int y){
        // if (lst.size() == m){
        //     if (grid[x][y] == 1)
        //         return false;
        // }else {
        //     if (grid[x][y] == 1)
        //         lst.add(new int[]{x, y});
        // }

        if (grid[x][y] == 1){
            for (int[] r : rock) {
                if (r[0] == x && r[1] == y)
                    return true;
            }
        }else
            return true;

        return false;
    }

    public static int countVisited(){
        int res = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j])
                    res++;
            }
        }

        return res;
    }

    public static void bfs(){
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && canGo(nx, ny)){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt() - 1;
            startPoints[i][1] = sc.nextInt() - 1;
        }

        foundRock();
        rock = new ArrayList<>();
        cnt = 0;
        find(0);
        
        // int cnt = 0;

        // for (int i = 0; i < k; i++){
        //     q.add(new int[]{startPoints[i][0], startPoints[i][1]});
        //     visited = new boolean[n][n];
        //     visited[startPoints[i][0]][startPoints[i][1]] = true;
        //     rock = new ArrayList<>();
        //     bfs();
        //     cnt = Math.max(cnt, countVisited());
        // }

        System.out.print(cnt);

    }
}