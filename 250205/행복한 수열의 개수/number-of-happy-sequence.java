import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] lst = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                lst[i][j] = sc.nextInt();
        }

        if (m == 1){
            System.out.print(n * 2);
            return ;
        }

        int cnt = 0;

        for (int i = 0; i < n; i++){// 가로
            int check = 0;
            int max_check = -1;
            for (int j = 1; j < n; j++){
                // System.out.println(lst[i][j] + " " + lst[i][j-1]);
                if (lst[i][j] == lst[i][j - 1])
                    check++;
                else{
                    // System.out.println(i +" "+j+ " "+check);
                    max_check = Math.max(max_check, check);
                    check = 0;
                }
               
            }
            if (check >= m - 1 || max_check >= m - 1)
                cnt++;
        }

        for (int i = 0; i < n; i++){// 세로
            int check = 0;
            int max_check = 0;
            for (int j = 1; j < n; j++){
                if (lst[j][i] == lst[j - 1][i])
                    check++;
                else{
                    max_check = Math.max(max_check, check);
                    check = 0;
                }
            }
            if (check >= m - 1 || max_check >= m - 1)
                cnt++;
        }


        System.out.print(cnt);
    }
}