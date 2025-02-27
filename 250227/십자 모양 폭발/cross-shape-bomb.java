import java.util.*;

public class Main {
    public static int[][] grid;
    public static int n;

    public static void boom(int r, int c){
        int range = grid[r][c] - 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == r){
                    if (j >= c - range && j <= c + range)
                        grid[i][j] = 0;
                }
                else if (j == c){
                    if (i >= r - range && i <= r + range)
                        grid[i][j] = 0;
                }
            }
        }

        moveDown();
    }

    public static void moveDown(){
        for (int j = 0; j < n; j++){ // 세로로 한줄씩
            int[] tmp = new int[n];
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i--){
                if (grid[i][j] == 0)
                    continue;
                tmp[idx--] = grid[i][j];
            }
            // int newIdx = 0;
            for (int i = 0; i < n; i++){
                if (i < idx)
                    grid[i][j] = 0;
                else
                    grid[i][j] = tmp[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1; // 터질 곳 

        boom(r, c);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j]+ " ");
            System.out.println();
        }

        
    }
}