import java.util.*;

public class Main {
    public static int[][] board;
    public static int n;
    public static int k;

    public static int findSum(int x, int y){
        int res = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (Math.abs(x - i) + Math.abs(y - j) <= k)
                    res += board[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                max = Math.max(max, findSum(i, j));
            }
        }

        System.out.print(max);
    }
}