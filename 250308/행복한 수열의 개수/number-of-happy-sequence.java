import java.util.Scanner;
  
public class Main {
    public static int[][] grid;
    public static int n;
    public static int m;

    public static int findRow(){ // 가로
        int res = 0;
        for (int i = 0; i < n; i++){
            int cnt = 0;
            for (int j = 1; j < n; j++){
                if (grid[i][j - 1] == grid[i][j])
                    cnt++;
                else {
                    if (cnt >= m - 1){
                        cnt = 0;
                        res++;
                        break ;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= m - 1)
                res++;
        }

        return res;
    }

    public static int findCor(){ // 세로
        int res = 0;
        for (int j = 0; j < n; j++){
            int cnt = 0;
            for (int i = 1; i < n; i++){
                if (grid[i - 1][j] == grid[i][j])
                    cnt++;
                else {
                    if (cnt >= m - 1){
                        cnt = 0;
                        res++;
                        break ;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= m - 1)
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        if (m == 1){
            System.out.print(2 * n);
            return ;
        }

        int res = 0;

        res += findRow();
        res += findCor();

        System.out.print(res);
    }
}