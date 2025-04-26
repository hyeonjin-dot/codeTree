import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] exp = new int[n][2];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            exp[i][0] = sc.nextInt();
            exp[i][1] = sc.nextInt();
            sum += exp[i][0];
        }

        Arrays.sort(exp, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++){
            for (int j = sum; j >= exp[i][0]; j--){
                if (dp[j - exp[i][0]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - exp[i][0]] + exp[i][1]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = m; i <= sum; i++){
            if (dp[i] != Integer.MAX_VALUE)
                min = Math.min(dp[i], min);
        }

        if (min == Integer.MAX_VALUE)
            min = -1;

        System.out.print(min);
    }
}