import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int min = n;
        for (int i = 0; i < n; i++){
            for (int j = k; j < k + m; j++){
                if (grid[i][j] == 1){
                    min = Math.min(min, i);
                }
            }
        }

        min--;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (j >= k && j < k + m && i == min)
                    grid[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}