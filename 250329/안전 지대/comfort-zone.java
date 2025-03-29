import java.util.*;
public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static int maxHeigh;
    public static int max;
    public static boolean[][] visited;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void dfs(int x, int y, int heigh){
        if (!inRange(x, y) || visited[x][y] || grid[x][y] <= heigh)
            return ;
        
        visited[x][y] = true;
        
        dfs(x + 1, y, heigh);
        dfs(x - 1, y, heigh);
        dfs(x, y + 1, heigh);
        dfs(x, y - 1, heigh);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        maxHeigh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
                maxHeigh = Math.max(maxHeigh, grid[i][j]);
            }
        }

        max = 0;
        int[] check = new int[maxHeigh];
        for (int heigh = 1; heigh < maxHeigh; heigh++){
            int cnt = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (visited[i][j] == false && grid[i][j] > heigh){
                        cnt++;
                        dfs(i, j, heigh);
                    }
                }
            }
            max = Math.max(cnt, max);
            check[heigh] = cnt;
        }

        for (int i = 0; i < maxHeigh; i++){
            if (check[i] == max){
                System.out.print(i + " " + max);
                break ;
            }
        }
        
        // System.out.print(max);
    }
}