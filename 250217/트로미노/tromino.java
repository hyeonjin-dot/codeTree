import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] lst = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                lst[i][j] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;

        //x x+1 x+2
        //y y+1 y+2

        for (int j = 0; j < m; j++){
            for (int i = 0; i < n - 2; i++){
                int tmp = lst[i][j] + lst[i + 1][j] + lst[i + 2][j];
                max = Math.max(max, tmp);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m - 2; j++){
                int tmp = lst[i][j] + lst[i][j + 1] + lst[i][j + 2];
                max = Math.max(max, tmp);
            }
        }

        // (x y) (x y+1) (x+1 y+1)
        // (x y) (x+1 y) (x y+1)
        // (x y) (x+1 y) (x+1 y+1)
        // (x y) (x+1 y) (x+1 y-1)

        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < m - 1; j++){
                int tmp1 = lst[i][j] + lst[i][j + 1] + lst[i +1][j + 1];
                int tmp2 = lst[i][j] + lst[i + 1][j] + lst[i][j + 1];
                int tmp3 = lst[i][j] + lst[i + 1][j] + lst[i +1][j + 1];
                int tmp = Math.max(tmp1, tmp2);
                tmp = Math.max(tmp, tmp3);
                max = Math.max(max, tmp);
            }
        }

        for (int i = 0; i < n - 1; i++){
            for (int j = 1; j < m; j++){
                int tmp = lst[i][j] + lst[i + 1][j] + lst[i + 1][j - 1];
                max = Math.max(max, tmp);
            }
        }

        System.out.print(max);
    }
}