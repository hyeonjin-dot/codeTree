import java.util.Scanner;
public class Main {
    public static int[][] grid;
    public static int n;
    public static int m;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 시계방향
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int x;
    public static int y;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void find(int a){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == a){
                    x = i;
                    y = j;
                    return ;
                }
            }
        }
    }

    public static void move(){
        for (int a = 1; a <= n * n; a++){
            find(a);
            int max = 0;
            int maxX = 0;
            int maxY = 0;
            for (int idx = 0; idx < 8; idx++){
                if (!inRange(x + dx[idx], y + dy[idx]))
                    continue;
                int tmp = grid[x + dx[idx]][y + dy[idx]];
                max = Math.max(max, tmp);
                if (max == tmp){
                    maxX = x + dx[idx];
                    maxY = y + dy[idx];
                }
            }
            int tmp = grid[x][y];
            grid[x][y] = max;
            grid[maxX][maxY] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i = 0; i < m; i++)
            move();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}