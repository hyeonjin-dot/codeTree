import java.util.Scanner;
public class Main {
    public static int n;
    public static int[][] lst;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static boolean inRange(int x, int y){
        return (x < n && x >= 0 && y < n && y >= 0);
    }

    public static int confortable(int x, int y){
        int cnt = 0;

        for (int i = 0; i < 4; i++){
            if (inRange(x + dx[i], y + dy[i]) && lst[x + dx[i]][y + dy[i]] == 1)
                cnt++;
        }

        if (cnt == 3)
            return 1;
        else 
            return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        lst = new int[n][n];

        for (int i = 0; i < m; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            lst[x][y]++;

            System.out.println(confortable(x, y));
        }
    }
}