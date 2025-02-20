import java.util.*;

public class Main {
    public static int[][] lst;
    public static int n;

    public static int find_sum_1(int i, int j){
        int ret = 0;
        int x = i;
        int y = j;

        if (x < 2 || y < 1)
            return ret;
        
        // ret += lst[x][y]; // 현재

        // System.out.println(x + " " + y);

        while (x >= 1 && y < n){
            // System.out.print(x + " " + y + " ");
            ret += lst[x--][y++];
        }

        if (y >= n && x != 0){
            // System.out.println();
            // System.out.println("result : " + ret);
            return 0;
        }

        y -= 2;

        // System.out.print(" / ");

        while (x < i && y != j - 1){
            // System.out.print( " " + x + " " + y);
            ret += lst[x++][y--];
        }

        ret += lst[x][y];

        // System.out.println();
        // System.out.println("result : " + ret);
        return ret;
    }

    public static int find_sum_2(int i, int j){
        int ret = 0;
        int x = i;
        int y = j;

        if (x < 2 || y < 1)
            return ret;

        ret += lst[x][y];

        x--;
        y++;

        if (y >= n || x <= 0)
            return 0;

        while (x >= 0 && y >= 1){
            // System.out.print(" " + x + " " + y + " ");
            ret += lst[x--][y--];
        }

        if (x != -1 && y < 0){
            // System.out.print(x + " " + y);
            return 0;
        }

        x += 2;
        // System.out.print(" / ");

        while (x <= i - 1 && y <= j - 1){
            // System.out.print(" " + x + " " + y + " ");
            ret += lst[x++][y++];
        }

        // System.out.println("\n ret : " + ret);
        return ret;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        lst = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                lst[i][j] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int sum = Math.max(find_sum_1(i,j), find_sum_2(i, j));
                // System.out.println(i + " " + j + " " + sum);
                max = Math.max(max, sum);
            }
        }

        System.out.print(max);
    }
}