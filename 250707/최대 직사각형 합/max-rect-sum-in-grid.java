import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                grid[i][j] = sc.nextInt();
        
        int[][] prexsum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                prexsum[i][j] = prexsum[i - 1][j] + prexsum[i][j - 1] - prexsum[i - 1][j - 1] + grid[i][j];
        
        int max = Integer.MIN_VALUE;

        for (int x1 = 1; x1 <= n; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                for (int x2 = x1; x2 <= n; x2++) {
                    for (int y2 = y1; y2 <= n; y2++) {
                        int sum = prexsum[x2][y2] 
                                - prexsum[x1 - 1][y2] 
                                - prexsum[x2][y1 - 1] 
                                + prexsum[x1 - 1][y1 - 1];
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        System.out.print(max);
    }
}