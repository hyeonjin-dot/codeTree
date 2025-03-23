import java.util.Scanner;
public class Main {
    public static int n;
    public static int m; // 도둑
    public static int c;
    public static int[][] grid;
    public static int max;
    public static boolean[][] visited;

    public static int findMax(int i, int j) {
        int res = 0;
        int[] values = new int[m];
        
        for (int y = 0; y < m; y++) {
            values[y] = grid[i][j + y];
        }
        
        // 비트마스크로 부분집합 탐색
        for (int mask = 1; mask < (1 << m); mask++) {
            int sum = 0;
            int power = 0;
            for (int k = 0; k < m; k++) {
                if ((mask & (1 << k)) != 0) {
                    sum += values[k];
                    power += values[k] * values[k];
                }
            }
            if (sum <= c) {
                res = Math.max(res, power);
            }
        }

        return res;
    }

    public static void find(int idx, int sum){
        if (idx == 2){
            max = Math.max(max, sum);
            return ;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - m + 1; j++){
                boolean vaild = true;
                for (int k = 0; k < m; k++){
                    if (visited[i][j + k])
                        vaild = false;
                }

                if (!vaild)
                    continue;

                for (int k = 0; k < m; k++)
                   visited[i][j + k] = true;
                
                int add = findMax(i, j);
                find(idx + 1, sum + add);

                for (int k = 0; k < m; k++)
                   visited[i][j + k] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        max = 0;
        visited = new boolean[n][n];

        find(0, 0);
        System.out.print(max);
    }
}