import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        // dp[1] = 1;
        // dp[2] = 2;
        // dp[3] = 5;

        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum = 0;
            for (int j = 0; j < i; j++)
                sum += dp[j] * dp[i - 1 - j];
            dp[i] = sum;
        }

        System.out.print(dp[n]);
    }
}