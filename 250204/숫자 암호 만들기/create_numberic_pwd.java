package java_algo;

import java.util.*;

public class dp {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] dp = new int[n + 1]; // 합
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // {1, 2, 3, 4}
        for (int i = 3; i <= n; i++){
            if (i == 3)
                dp[3] = dp[2] + dp[1] + dp[0];
            else
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }
        System.out.println(dp[n]);
    }
}
