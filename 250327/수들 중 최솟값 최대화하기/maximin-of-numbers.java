import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int min;
    // public static int max;
    public static List<Integer> colored = new ArrayList<>();
    public static boolean[][] visited;

    public static boolean checkVisited(int idx, int y){
        for (int i = 0; i < idx; i++){
            if (visited[i][y])
                return false;
        }
        return true;
    }

    public static void find(int idx){
        if (idx == n){
            if (colored.size() == n){
                int tmp = Collections.min(colored);
                min = Math.max(tmp, min);
            }
            return ;
        }

        for (int i = 0; i < n; i++){
            if (idx > 0 && !checkVisited(idx, i))
                continue;

            colored.add(grid[idx][i]);
            visited[idx][i] = true;
            find(idx + 1);
            colored.remove(colored.size() - 1);
            visited[idx][i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        min = Integer.MIN_VALUE;
        // max = Integer.MIN_VALUE;
        visited = new boolean[n][n];
        find(0);
        System.out.print(min);

    }
}