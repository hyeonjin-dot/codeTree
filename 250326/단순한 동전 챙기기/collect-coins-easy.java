import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static List<Point> coin = new ArrayList<>();
    public static int[] lst = new int[3];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int min;
    public static boolean[][][] visited;
    public static int[] distance = new int[3];

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int find(int sx, int sy, int tx, int ty) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new Point(sx, sy, 0));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == tx && cur.y == ty)
                return cur.dist;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (inRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, cur.dist + 1));
                }
            }
        }
        return -1; // 도달 불가능
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        int x = 0;
        int y = 0;
        int ex = 0;
        int ey = 0;

        for (int i = 0; i < n; i++) {
            String tmp = sc.next().trim();
            for (int j = 0; j < n; j++){
                char a = tmp.charAt(j);
                if (a <= '9' && a >= '1'){
                    grid[i][j] = (a - '0');
                    coin.add(new Point(i, j, grid[i][j]));
                }
                else if (a == 'S'){
                    grid[i][j] = 10;
                    x = i;
                    y = j;
                }
                else if (a == 'E'){
                    grid[i][j] = 100;
                    ex = i;
                    ey = j;
                }
            }
        }

        coin.sort(Comparator.comparingInt(c -> c.dist));

        if (coin.size() < 3){
            System.out.print(-1);
            return ;
        }

        min = Integer.MAX_VALUE;

        int size = coin.size();
        for (int i = 0; i < size - 2; i++){
            for (int j = i + 1; j < size - 1; j++){
                for (int k = j + 1; k < size; k++){
                    visited = new boolean[n][n][4];
                    int total = 0;
                    // lst[0] = coin.get(i).get(0);
                    // lst[1] = coin.get(j);
                    // lst[2] = coin.get(k);
                    total = find(x, y, coin.get(i).x, coin.get(i).y);
                    total += find(coin.get(i).x, coin.get(i).y,
                        coin.get(j).x, coin.get(j).y);
                    total += find(coin.get(j).x, coin.get(j).y,
                        coin.get(k).x, coin.get(k).y);
                    total += find(coin.get(k).x, coin.get(k).y, ex, ey);
                    min = Math.min(total, min);
                }
            }
        }

        if (min == Integer.MAX_VALUE)
            min = -1;

        System.out.print(min);
        // s - 동전 3개의 조합 - e       

    }
}