import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int[][] lst = new int[k][n];

        for (int i = 0; i < k; i++){
            for (int j = 0; j < n; j++)
                lst[i][j] = sc.nextInt() - 1;
        }
        
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j)
                    continue;
                
                int cnt = 0;
                for (int x = 0; x < k; x++){
                    int fir = 0;
                    int sec = 0;
                    for (int y = 0; y < n; y++){
                        if (lst[x][y] == i)
                            fir = y;
                        if (lst[x][y] == j)
                            sec = y;
                    }
                    if (fir < sec)
                        cnt++;
                }
                if (cnt == k)
                    res++;
            }
        }

        System.out.print(res);
    }
}