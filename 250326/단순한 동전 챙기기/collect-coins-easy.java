import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int min;
    public static List<Integer> lst = new ArrayList<>();
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean[][] visited;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y>= 0 && y < n);
    }

    public static void find(int x, int y, int move){
        if (!inRange(x, y) || visited[x][y])
            return ;

        if (grid[x][y] == 100){
            if (lst.size() >= 3)
                min = Math.min(min, move);
            return ;
        }

        visited[x][y] = true;

        if (grid[x][y] >= 1 && grid[x][y] < 10){
            int tmp = grid[x][y];
            lst.add(grid[x][y]);
            grid[x][y] = 0;
            for (int i = 0; i < 4; i++)
                find(x + dx[i], y + dy[i], move + 1);
            lst.remove(lst.size() - 1);
            grid[x][y] = tmp;
        } else {
            for (int i = 0; i < 4; i++)
                find(x + dx[i], y + dy[i], move + 1);
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        int x = 0;
        int y = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = sc.next().trim();
                for (int j = 0; j < n; j++){
                    char a = tmp.charAt(j);
                    if (a <= '9' && a >= '1')
                        grid[i][j] = (a - '0');
                    else if (a == 'S'){
                        grid[i][j] = 10;
                        x = i;
                        y = j;
                    }
                    else if (a == 'E')
                        grid[i][j] = 100;
                }
        }

        min = Integer.MAX_VALUE;
        
        find(x, y, 0);

        if (min == Integer.MAX_VALUE)
            min = -1;
        System.out.print(min);

    }
}