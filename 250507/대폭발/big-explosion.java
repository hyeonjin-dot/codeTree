import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int m;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        
        grid = new int[n][n];
        grid[r][c] = 1;

        for (int i = 1; i <= m; i++){
            int[][] tmp = new int[n][n];
            for (int x = 0; x < n; x++){
                for (int y = 0; y < n; y++){
                    if (grid[x][y] == 1){
                        tmp[x][y] = 1;
                        for (int k = 0; k < 4; k++){
                            int nx = x + (int)Math.pow(2, i - 1) * (dx[k]);
                            int ny = y + (int)Math.pow(2, i - 1) * (dy[k]);
                            if (inRange(nx, ny))
                                tmp[nx][ny] = 1;
                        }
                    }
                }
            }
            grid = tmp;
        }

        int sum = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                sum += grid[i][j];
        }

        System.out.print(sum);
    }
}