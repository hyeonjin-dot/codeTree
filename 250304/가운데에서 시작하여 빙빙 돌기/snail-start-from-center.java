import java.util.Scanner;

public class Main {
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int n;
    
    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] lst = new int[n][n];
        int input = n * n;
        int idx = 0;

        lst[n - 1][n - 1] = input--;
        int x = n - 1;
        int y = n - 1;

        for (int i = 1; i < n * n; i++){
            if (!inRange(x + dx[idx], y + dy[idx]) 
                || lst[x + dx[idx]][y + dy[idx]] != 0)
                idx++;
            
            idx %= 4;
            x += dx[idx];
            y += dy[idx];

            lst[x][y] = input--;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(lst[i][j] + " ");
            System.out.println();
        }
    }
}