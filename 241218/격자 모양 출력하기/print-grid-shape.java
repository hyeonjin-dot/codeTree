import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] lst = new int[n][n];

        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            lst[x - 1][y - 1] = x * y;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(lst[i][j] + " ");
            System.out.println();
        }
    }
}