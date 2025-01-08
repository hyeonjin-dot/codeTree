import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] lst = new int[n + 1];

        for (int i = 1; i <= n; i++)
            lst[i] = sc.nextInt();
        
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++){
            int tmp = 0;
            int idx = i;
            for (int j = 0; j < m; j++){
                tmp += lst[idx];
                idx = lst[idx];
            }
            max = Math.max(max, tmp);
        }

        System.out.print(max);
    }
}