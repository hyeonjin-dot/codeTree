import java.util.*;

public class Main {
    public static int[][] lst;
    public static int n;

    public static int find_sum(int i, int j){
        int ret = 0;

        for (int odd = 1; odd <= n; odd++){
            for (int even = 1; even <= n; even++){
                int sum = 0;
                boolean valid = true;

                int x = i;
                int y = j;

                // 1
                for (int k = 0; k < odd; k++){
                    x--;
                    y++;
                    if (x < 0 || y >= n){
                        valid = false;
                        break;
                    }
                    sum += lst[x][y];
                }

                if (!valid)
                    continue;

                // 2
                for (int k = 0; k < even; k++){
                    x--;
                    y--;
                    if (x < 0 || y < 0){
                        valid = false;
                        break;
                    }
                    sum += lst[x][y];
                }
                if (!valid)
                    continue;

                // 3
                for (int k = 0; k < odd; k++){
                    x++;
                    y--;
                    if (x >= n || y < 0){
                        valid = false;
                        break;
                    }
                    sum += lst[x][y];
                }
                if (!valid)
                    continue;

                // 4
                for (int k = 0; k < even; k++){
                    x++;
                    y++;
                    if (x >= n || y >= n){
                        valid = false;
                        break;
                    }
                    sum += lst[x][y];
                }
                if (!valid)
                    continue;     

                ret = Math.max(sum, ret);           
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        lst = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                lst[i][j] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int sum = find_sum(i, j);
                max = Math.max(max, sum);
            }
        }

        System.out.print(max);
    }
}