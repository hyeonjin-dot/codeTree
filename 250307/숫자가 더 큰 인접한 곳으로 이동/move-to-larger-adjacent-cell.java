import java.util.Scanner;
public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n;
    public static int r;
    public static int c;
    public static int[][] grid;

    public static boolean isRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static boolean move(){
        int tmpR = -1;
        int tmpC = -1;
        int tmp = grid[r][c];

        for (int i = 0; i < 4; i++){
            if (!isRange(r + dx[i], c + dy[i]))
                continue;
            if (tmp < grid[r + dx[i]][c + dy[i]]){
                tmpR = r + dx[i];
                tmpC = c + dy[i];
                tmp = grid[r + dx[i]][c + dy[i]];
                break ;
            }
        }
        
        if (tmpR == -1)
            return false;

        r = tmpR;
        c = tmpC;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        boolean valid = true;
        System.out.print(grid[r][c] + " ");
        while (move()){
            System.out.print(grid[r][c] + " ");
        }
    }
}