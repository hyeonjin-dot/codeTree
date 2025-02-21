import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] lst;
    
    public static int cnt(int r1, int c1, int r2, int c2){
        int ret = 0;

        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j++){
                if (lst[i][j] <= 0)
                    return -1;
                ret++;
            }
        }

        return ret;
    }

    public static int find_max(){
        int max = -1;

        for (int r1 = 0; r1 < n; r1++){
            for (int c1 = 0; c1 < m; c1++){
                for (int r2 = r1; r2 < n; r2++){
                    for (int c2 = c1; c2 < m; c2++){
                        int tmp = cnt(r1, c1, r2, c2);
                        max = Math.max(tmp, max);
                    }
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        lst = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                lst[i][j] = sc.nextInt();
        }

        System.out.print(find_max());
    }
}