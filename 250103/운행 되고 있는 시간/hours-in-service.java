import java.util.*;

public class Main {
    public static boolean[] working;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] lst = new int[n][2];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            working = new boolean[1001];
            int tmp = 0;
            for (int j = 0; j < n; j++){
                if (i == j)
                    continue;
                for (int k = lst[j][0] ; k < lst[j][1]; k++){
                    if (!working[k]){
                        tmp++;
                        working[k] = true;
                    }
                }
            }
            max = Math.max(tmp, max);
        }

        System.out.print(max);
    }
}