import java.util.Scanner;
public class Main {
    public static int n;
    public static int m;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] lst = new int[n][m];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int idx = 0;
        int x = 0;
        int y = 0;
        
        lst[x][y] = 1;
        
        int input = 2;

        for (int i = 1; i < n * m; i++){
            int nx = x + dx[idx % 4];
            int ny = y + dy[idx % 4];

            if (!inRange(nx, ny) || lst[nx][ny] > 0) 
                idx++;
            
            x += dx[idx % 4];
            y += dy[idx % 4];

            lst[x][y] = input++;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                System.out.print(lst[i][j] + " ");
            System.out.println();
        }
    }
}