import java.util.*;
public class Main {
    public static int n;
    public static int r2;
    public static int c2;
    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static boolean[][] visited;
    public static Queue<int[]> q = new LinkedList<>();

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int bfs(){
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int move = tmp[2];

            if (x == r2 && y == c2)
                return move;

            for (int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, move + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        visited = new boolean[n][n];
        q.add(new int[]{r1, c1, 0});


        System.out.print(bfs());
    }   
}