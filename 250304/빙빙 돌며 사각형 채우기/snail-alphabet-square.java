import java.util.Scanner;
public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n;
    public static int m;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        char[][] lst = new char[n][m];

        char input = 'A';
        int x = 0;
        int y = 0;
        int idx = 0;

        lst[x][y] = input++;

        for (int i = 1; i < n * m; i++){
            if (!inRange(x + dx[idx], y + dy[idx])
                || lst[x + dx[idx]][y + dy[idx]] != 0)
                idx++;
            
            idx %= 4;
            x += dx[idx];
            y += dy[idx];

            lst[x][y] = input++;
            if (input > 'Z')
                input = 'A';
        }        

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                System.out.print(lst[i][j] + " ");
            System.out.println();
        }
    }
}