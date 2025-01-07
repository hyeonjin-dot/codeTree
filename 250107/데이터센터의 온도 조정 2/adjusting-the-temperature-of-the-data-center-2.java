import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        
        int min = 1001;
        int max = -1;

        int[][] lst = new int[n][2];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
            min = Math.min(lst[i][0], min);
            max = Math.max(lst[i][1], max);
        }

        int res = -1;
        for (int i = min; i < max; i++){
            int tmp = 0;
            for (int j = 0; j < n; j++){
                if (lst[j][0] > i)
                    tmp += c;
                else if (lst[j][1] < i)
                    tmp += h;
                else
                    tmp += g;
            }
            res = Math.max(tmp, res);
        }

        System.out.print(res);
    }
}