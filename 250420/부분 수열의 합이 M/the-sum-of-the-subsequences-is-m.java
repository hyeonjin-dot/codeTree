import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[m + 1];

        for (int i = 1; i < m + 1; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            for (int j = m; j >= 0; j--){
                if (j >= arr[i]){
                    if (dp[j - arr[i]] == Integer.MAX_VALUE)
                        continue;
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        if (dp[m] == Integer.MAX_VALUE)
            dp[m] = -1;
        System.out.print(dp[m]);
    }   
}