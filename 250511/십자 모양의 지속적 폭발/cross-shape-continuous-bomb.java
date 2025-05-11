import java.util.*;
public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static int[] bombCols;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void boom(){
        for (int i = 0; i < m; i++){
            int[][] tmp = new int[n][n];
            int y = bombCols[i] - 1;

            for (int x = 0; x < n; x++){
                if (grid[x][y] > 0){
                    int erase = grid[x][y];
                    grid[x][y] = 0;
                    // 주변 i 개 지우기
                    for (int k = 0; k < erase; k++){
                        for (int cnt = 0; cnt < 4; cnt++){
                            if (inRange(x + k * dx[cnt], y + k * dy[cnt]))
                                grid[x + k * dx[cnt]][y + k * dy[cnt]] = 0;
                        }
                    }
                    break ;
                }
            }

            // 내리기
            for (int ny = 0; ny < n; ny++){
                int nx = n - 1;
                for (int x = n - 1; x >= 0; x--){
                    if (grid[x][ny] > 0){
                        tmp[nx][ny] = grid[x][ny];
                        nx--;
                    }
                }
            }

            grid = tmp;


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
        bombCols = new int[m];
        for (int i = 0; i < m; i++)
            bombCols[i] = sc.nextInt();
        
        boom();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}