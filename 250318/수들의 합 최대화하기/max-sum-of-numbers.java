import java.util.Scanner;
public class Main {
    public static int n;
    public static int[][] grid;
    public static boolean[] visited;
    public static int max;

    public static void findMax(int idx, int sum){
        if (idx == n){
            max = Math.max(max, sum);
            return;
        }
        
        for (int i = 0; i < n; i++){
            if (visited[i])
                continue ;
            
            visited[i] = true;
            findMax(idx + 1, sum + grid[idx][i]);
            visited[i] = false;
        }
        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n];
        max = 0;

        findMax(0, 0);
        
        System.out.print(max);
    }
}