import java.util.*;

public class Main {
    public static int[][] tile = new int[2001][2001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            int x1 = sc.nextInt() + 1000;
            int y1 = sc.nextInt() + 1000;
            int x2 = sc.nextInt() + 1000;
            int y2 = sc.nextInt() + 1000;

            int color = i % 2 == 0 ? 1 : 2;
            for (int x = x1; x < x2; x++){
                for (int y = y1; y < y2; y++){
                    tile[x][y] = color;
                }
            }
        }

        int blue = 0;

        for (int i = 0 ; i < 2001; i++){
            for (int j = 0; j < 2001; j++){
                if (tile[i][j] == 2)
                    blue++;
            }
        }

        System.out.print(blue);
    }
}