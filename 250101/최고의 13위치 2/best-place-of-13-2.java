import java.util.*;

public class Main {
    public static int[][] lst;
    public static List<Integer> sum = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        lst = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            for (int j = 0; j < n; j++){
                int tmp = sc.nextInt();
                lst[i][j] = tmp;
            }
        }
        int max_cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 2; j++){
                for (int k = 0; k < n; k++){
                    for (int m = 0; m < n - 2; m++){
                        if (i == k && Math.abs(j - m) <= 2)
                            continue;
                        int tmp = lst[i][j] + lst[i][j + 1] + lst[i][j + 2];
                        int tmp2 = lst[k][m] + lst[k][m + 1] + lst[k][m + 2];
                        max_cnt = max_cnt > (tmp + tmp2) ? max_cnt : (tmp + tmp2);
                    }
                }
                
            }
        }
        System.out.print(max_cnt);
    }
}