import java.util.Scanner;
public class Main {
    public static int[][] grid;
    public static int n;

    public static void antiClock(int r, int c, int m1, int m2, int m3, int m4){
        int x = r;
        int y = c;

        int tmp = grid[r][c];

        for (int i = m4; i > 0; i--)
            grid[x][y] = grid[--x][--y];
        
        for (int i = m3; i > 0; i--)
            grid[x][y] = grid[--x][++y];
                
        for (int i = m2; i > 0; i--)
            grid[x][y] = grid[++x][++y];
        
        for (int i = m1; i > 1; i--)
            grid[x][y] = grid[++x][--y];

        grid[x][y] = tmp;
    }

    public static void clock(int r, int c, int m1, int m2, int m3, int m4){
        int x = r;
        int y = c;

        int tmp = grid[r][c];

        for (int i = m1; i > 0; i--)
            grid[x][y] = grid[--x][++y];
        
        for (int i = m2; i > 0; i--)
            grid[x][y] = grid[--x][--y];
        
        for (int i = m3; i > 0; i--)
            grid[x][y] = grid[++x][--y];

        for (int i = m4; i > 1; i--)
            grid[x][y] = grid[++x][++y];        

        grid[x][y] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();
        
        if (dir == 0)
            antiClock(r, c, m1, m2, m3, m4);
        else
            clock(r, c, m1, m2, m3, m4);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}