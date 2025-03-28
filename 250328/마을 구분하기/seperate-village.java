import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static List<Integer> lst = new ArrayList<>();
    public static boolean[][] visited;
    public static int size;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void dfs(int x, int y){
        if (!inRange(x, y) || visited[x][y] || grid[x][y] == 0)
            return ;
        
        visited[x][y] = true;
        size++;

        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1 && visited[i][j] == false){
                    size = 0;
                    dfs(i, j);
                    lst.add(size);
                }
            }
        }
        
        Collections.sort(lst);
        
        System.out.println(lst.size());
        for (int i = 0; i < lst.size(); i++)
            System.out.println(lst.get(i));
    }
}