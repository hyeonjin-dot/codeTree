import java.util.*;
public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static int[][] tmp_grid;
    public static int[][] marbles;
    public static int[] check;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void move(){
        for (int i = 0; i < m; i++){
            if (marbles[i][0] == -1)
                continue ;
                
            int x = marbles[i][0];
            int y = marbles[i][1];

            int idx = -1;
            for (int j = 0; j < 4; j++){
                if (!inRange(x + dx[j], y + dy[j]))
                    continue;
                
                if (idx == -1)
                    idx = j;
                
                if (grid[x + dx[idx]][y + dy[idx]] 
                        < grid[x + dx[j]][y + dy[j]])
                    idx = j;
                
            }
            marbles[i][0] = x + dx[idx];
            marbles[i][1] = y + dy[idx];
            
            if (tmp_grid[marbles[i][0]][marbles[i][1]] == 0)
                tmp_grid[marbles[i][0]][marbles[i][1]] = i + 1;
            else{
                int flag = tmp_grid[marbles[i][0]][marbles[i][1]];
                // System.out.println(flag);
                tmp_grid[marbles[i][0]][marbles[i][1]] = -1;
                if (flag != -1)
                    marbles[flag - 1][0] = -1;
                
                marbles[i][0] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); // 구슬 개수
        int t = sc.nextInt(); // 시간
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            marbles[i][0] = sc.nextInt() - 1;
            marbles[i][1] = sc.nextInt() - 1;
        }

        // 두개 이상이 같은 위치가 되면 사라짐
        check = new int[m];
        for (int i = 0; i < t; i++){
            tmp_grid = new int[n][n];
            move();
        }

        int res = 0;
        for (int i = 0; i < m; i++){
            if (marbles[i][0] > 0)
                res++;
        }

        System.out.print(res);
    }
}