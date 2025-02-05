import java.util.*;

public class Main {
    public static int cnt(int[][] lst, int i, int j){
        int ret = 0;

        for (int x = i; x < i + 3; x++){
            for (int y = j; y < j + 3; y++){
                ret += lst[x][y];
            }
        }
        
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] lst = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                lst[i][j] = sc.nextInt();
        }

        int max = -1;

        for (int i = 0; i < n - 2; i++){
            for (int j = 0; j < n - 2; j++)
                max = Math.max(cnt(lst, i, j), max);
        }

        System.out.print(max);
    }
}